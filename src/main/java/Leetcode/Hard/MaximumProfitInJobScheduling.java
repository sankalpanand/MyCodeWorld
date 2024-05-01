package Leetcode.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class MaximumProfitInJobScheduling {
    class Job {
        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit)
    {
        int n = profit.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        // Sort the jobs by endTime
        Arrays.sort(jobs, (j1, j2) -> Integer.compare(j1.end, j2.end));

        // dp[end_time] = max profit can be obtained from time 0 to end_time
        List<Integer> dpEndTime = new ArrayList<>();

        List<Integer> dpProfit = new ArrayList<>();
        dpEndTime.add(0); // base case to avoid IndexOutBoundExp
        dpProfit.add(0);

        for (Job job : jobs) {
            int prevIdx = largestSmaller(dpEndTime, job.start + 1); // previous job can end at job.start, so we use "job.start + 1"

            // Case 2: do this job
            int case2Profit = dpProfit.get(prevIdx) + job.profit;

            // Case 1: don't do this job
            int case1Profit = dpProfit.get(dpProfit.size() - 1);

            if (case2Profit > case1Profit) {
                dpEndTime.add(job.end);
                dpProfit.add(case2Profit);
            }
        }

        return dpProfit.get(dpProfit.size() - 1);
    }

    // return the index of the largest element < target in the given list (assume there must exist one element < target)
    // This is doing binary search for optimization. You can use a normal for loop too.
    private int largestSmaller(List<Integer> dpEndTime, int target) {
        int left = 0;
        int right = dpEndTime.size() - 1;

        while (left + 1 < right)
        {
            int mid = left + (right - left) / 2;

            if (dpEndTime.get(mid) < target)
            {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return dpEndTime.get(right) < target ? right : left;
    }
}
