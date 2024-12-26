package leetcode.heap;

import java.util.*;

public class FindMedianFromDataStream {

    public static void main(String[] args) {

    }

    static class MedianFinder {

        PriorityQueue<Integer> minheap;
        PriorityQueue<Integer> maxheap;

        public MedianFinder() {
            maxheap = new PriorityQueue<>(Collections.reverseOrder());
            minheap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            maxheap.offer(num);

            minheap.offer(maxheap.poll());

            if (maxheap.size() < minheap.size()) {
                maxheap.add(minheap.poll());
            }
        }

        public double findMedian() {
            if (maxheap.size() > minheap.size()) {
                return maxheap.peek();
            } else {
                return (minheap.peek() + maxheap.peek()) / 2.0;
            }
        }
    }
}
