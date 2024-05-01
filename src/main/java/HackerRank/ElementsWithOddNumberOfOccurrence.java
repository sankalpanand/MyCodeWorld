package HackerRank;

import java.util.*;

public class ElementsWithOddNumberOfOccurrence {

    public static void main(String[] args) {


//        Scanner in = new Scanner(System.in);
//
//        int length = Integer.parseInt(in.next());
//        int[] nums = new int[length];
//
//        for(int i=0; i < length; i++) {
//            nums[i] = Integer.parseInt(in.next());
//        }



        String numString = "1 2 4 4 5";
        int[] nums = {1,2,4,4,5};

        ElementsWithOddNumberOfOccurrence.find_elements_with_odd_number_of_occurrences(nums);
    }

    public static void find_elements_with_odd_number_of_occurrences(int[] numsString) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int num : numsString) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {

            if(entry.getValue() % 2 != 0) { // It means this element occurred odd number of times
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);

        for(int num : result) {
            System.out.print(num + " ");
        }
    }
}
