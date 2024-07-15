package Interviews.OA.amzn;

import java.util.List;

public class OA1 {
    public static void main(String[] args) {

    }

//    public static long findMaximumQuality(List<Integer> packets, int channels) {
//        // Write your code here
//
//
//    }
//
//    public static int getMaxNegativePnL(List<Integer> PnL) {
//        // Write your code here
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) ->  y - x);
//
//        int sum = PnL.get(0);
//
//        for(int i=1; i < PnL.size(); i++) {
//
//            int currPnL = PnL.get(i);
//
//            if(currPnL < sum) {
//                maxHeap.add(currPnL);
//                sum = sum - currPnL;
//            } else {
//                if(!maxHeap.isEmpty() && currPnL < maxHeap.peek()) {
//                    int num = maxHeap.poll();
//                    sum = sum + 2 * num - currPnL;
//                    maxHeap.add(currPnL);
//                } else {
//                    sum = sum + currPnL;
//                }
//            }
//        }
//        return maxHeap.size();
//    }
//
//    public static long findMaximumQuality(List<Integer> packets, int channels) {
//        // We first sort the input array
//        Collections.sort(packets);
//
//        // Base case, just one channel
//        if(channels == 1) {
//            return Math.round(getMedian(packets, 0, packets.size() -1));
//        }
//
//        // We can get the highest quality when the first channel gets the maximum packets, then rest of them get the remaining ones
//        int totalPackets = packets.size();
//        int upperBound = totalPackets - channels;
//        double curMedian = getMedian(packets, 0, upperBound);
//
//        upperBound++;
//        while(upperBound < totalPackets) {
//            curMedian = curMedian + packets.get(upperBound);
//            upperBound++;
//        }
//
//        return Math.round(curMedian);
//
//    }
//
//    // Standard method to get the median from a sorted array/list
//    public static double getMedian(List<Integer> list, int start, int end) {
//        int len = end - start + 1;
//        int mid = (start + end) / 2;
//
//        if(len % 2 == 0) {
//            double mid1 = list.get(mid);
//            double mid2 = list.get(mid+1);
//
//            double midVal = (mid1 + mid2)/2;
//            return midVal;
//        } else {
//            return list.get(mid);
//        }
//    }


}
