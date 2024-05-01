package Leetcode.Medium;

public class ShortestWayToFormString {
    // "xyz"    "xzyxz"
    // "yz"     "zyxz"  // x eliminated
    // "z"      "zyxz"  // nothing for y
    // ""       "yxz"   // z eliminated
    // "xyz"    "yxz"   // reset the string
    // "yz"     "yxz"   // nothing for x
    // "z"      "xz"    // y eliminated
    // ""       "xz"    // nothing for z
    // "xyz"    "xz"    // reset the string
    // "yz"     "z"     // x eliminated
    // "z"      "z"     // nothing for y
    // ""       ""      // z eliminated

    public static void main(String[] args) {
        ShortestWayToFormString obj = new ShortestWayToFormString();
        System.out.println(obj.shortestWay("xyz", "xzyxz"));
    }

    public int shortestWay(String source, String target) {
        int t = 0;
        int ans = 0;

        while (t < target.length()) {
            int pt = t;

            for (int s = 0; s < source.length(); s++) {
                if (t < target.length() && source.charAt(s) == target.charAt(t)) {
                    t++;
                }
            }

            if (t == pt) {
                return -1;
            }
            ans++;
        }

        return ans;
    }

    public int shortestWay2(String source, String target) {

        int count=0;
        int i=0;

        while(target.length() > 0) {

            if(!source.contains(String.valueOf(target.charAt(0)))) {
                return -1;
            }

            int j=0;
            String tempSource = source;

            while (true) {


                if(target.length() == 0) {
                    break;
                }

                if(target.charAt(0) == tempSource.charAt(0)) {
                    target = target.substring(1);
                }
                tempSource = tempSource.substring(1);

                if(tempSource.length() == 0) {
                    tempSource = source;
                    count++;
                    j=0;
                }
            }
        }

        return count;
    }

}
