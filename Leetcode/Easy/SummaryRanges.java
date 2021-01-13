package Leetcode.Easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {

		int[] nums = {0,1,2,4,5,7};
		// int[] nums = {0,3,5};

		List<String> list = summaryRanges(nums); 

		System.out.println(list);
	}

	public static List<String> summaryRanges(int[] nums) {

        List<String> list = new ArrayList<>();
        if(nums.length==1){
            list.add(nums[0]+"");
            return list;
        }

        for(int i=0;i<nums.length;i++){
            int a=nums[i];

            // Jab tak sequence chal rahi hai, tab tak i ko aage badhao
            while(i+1 < nums.length && (nums[i+1]-nums[i])==1) {
                i++;
            }

            // Bahar aane par pichhe ki sequence check karo - 1 hi element tha ya jyada the
            if(a != nums[i]){
                list.add(a+"->"+nums[i]);
            } else {
                list.add(a+"");
            }
        }

        return list;
	}
}
