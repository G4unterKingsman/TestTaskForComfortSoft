package ru.gaunter.testtask.util;

import java.util.PriorityQueue;

public class MinFinder {

    public static int getMin(int[] nums, int n) {
        if (n > nums.length || n <= 0)
            throw new IllegalArgumentException("Invalid N");

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            maxHeap.offer(num);

            if (maxHeap.size() > n) {
                maxHeap.poll();
            }

        }

        return maxHeap.peek();
    }
}
