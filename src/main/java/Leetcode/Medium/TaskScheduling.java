package Leetcode.Medium;

public class TaskScheduling {

    public static void main(String[] args) {
        TaskScheduling obj = new TaskScheduling();
        char[] tasks = {'A','A','A','B','B','B'};

        System.out.println(obj.leastInterval(tasks, 2));

    }

    // https://leetcode.com/problems/task-scheduler/discuss/104500/Java-O(n)-time-O(1)-space-1-pass-no-sorting-solution-with-detailed-explanation
    public int leastInterval(char[] tasks, int n)
    {
        int[] counter = new int[26];
        int maxFrequency = 0;        // This will track what's the maxFrequency frequency 
        int numElementsWithMaxFreq = 0;   // This will track how many elements have the maxFrequency frequency

        for(char task : tasks)
        {
            // Sabse pahle frequency badhao
            counter[task - 'A']++;

            // Agar frequency badhane ke baad wo frequency maxFrequency ho jaati hai, it means we got a tie.
            // Increase the counter.
            if(maxFrequency == counter[task - 'A'])
            {
                numElementsWithMaxFreq++;
            }

            // Agar frequency badhane ke baad wo frequency maxFrequency se badi ho jaati hai, it means we got a new max freq
            // Update the max frequence, also reset the count to 1
            else if(maxFrequency < counter[task - 'A'])
            {
                maxFrequency = counter[task - 'A'];
                numElementsWithMaxFreq = 1;
            }
        }

        int sections = maxFrequency - 1;
        int partLength = n - (numElementsWithMaxFreq - 1);
        int emptySlots = sections * partLength;
        int availableTasks = tasks.length - maxFrequency * numElementsWithMaxFreq;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}
