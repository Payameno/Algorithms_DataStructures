import java.util.*;

class Solution {

    public int[][] kClosest(int[][] points, int k) {
        
        //Max heap to hold tot points based on their distance
        Queue<int[]> maxHeap = new PriorityQueue<>((a,b) -> dist(b) - dist(a));

        //Add points to the heap
        for (int[] point : points) {
            maxHeap.add(point);
            //Remove the excess in the heap
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        //Define the result array and add points from the heap
        int[][] res = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            res[i++] = maxHeap.poll();
        }

        return res;

        }
    
    private int dist(int[] point) {
        int x = point[0];
        int y = point[1];

        return x*x + y*y;
    } 
}

/*
Time complexity:
O(NlogK) which acounts for N interations to map points into the maxHeap and 
logK time complexity for insertion or removal of itemsi into the maxHeap
There is also K iterations for adding point to res 

Space complexity:
0(K) which is K elements closest to the origin

Example 1:
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].


Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 

Constraints:

1 <= k <= points.length <= 104
-104 <= xi, yi <= 104
 */