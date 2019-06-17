/*

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1

*/


class Solution {
    public int minMeetingRooms(int[][] intervals)
    {
        int n = intervals.length;
        
        if (n <= 1) return n;
        
        // heap size will denote rooms occupied
        // value in each node will be meeting's end time of a room
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // add first interval's end time in heap
        pq.add(intervals[0][1]);
        
        for (int i = 1; i < n; i++)
        {
            // compare min end time with new interval's start time
            if (pq.peek() <= intervals[i][0])
            {
                // remove min end time from heap i.e. free this room for intervals[i]
                pq.poll();
				pq.add(intervals[i][1]);
            }
			else
				// occupy a new room for intervals[i]
				pq.add(intervals[i][1]);
        }
        
        return pq.size();
    }
}