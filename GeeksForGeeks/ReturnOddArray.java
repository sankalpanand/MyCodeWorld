package GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReturnOddArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(filter(nums)));
    }

    public static int[] filter(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            if(nums[i] % 2 != 0) {
                list.add(nums[i]);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
