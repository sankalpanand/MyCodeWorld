package Leetcode.Easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,1,1,1,1,1,2,3,4,5,5,5,5};
		System.out.println(majorityElement(array));

	}

	// https://www.youtube.com/watch?v=cLuLy6dy7n8
    public static int majorityElement(int[] nums)
    {
        if(nums.length == 1) {
            return nums[0];
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int num : nums)
        {
            if(map.containsKey(num) && map.get(num) + 1 > nums.length/2)
            {
                return num;
            }
            else
                map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return -1;
    }

    // Boyer-Moore Majority Vote
    // https://www.youtube.com/watch?v=n5QY3x_GNDg
    public int majorityElementO1(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }

}
