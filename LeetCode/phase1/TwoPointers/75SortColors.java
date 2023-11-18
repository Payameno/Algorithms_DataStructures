class solution {
    
     public void sortColors(int[] nums) {
        //Define the p0inters (Three pointers solution)
        int pz = 0, po = 0, pt = nums.length - 1;

        while (po <= pt) {
            if (nums[po] == 2) {
                swap(nums, pz, pt);
                pt--;
            } else if (po == 0) {
                swap(nums, pz, po);
                pz++;
                po++;
            } else {
                po++;
            }
        }
     }

     private void swap(int[]nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
     }

}

/*

Time complexity:
O(n)

Space complexity:
O(1)
 * 
 *  Examples:

 Example1:
 input: [2,0,2,1,1,0]
 Input: [0,0,1,1,2,2]
             pz
               po
               pt

Define three pzinters, pzinter zero, pzinter one and pzinter two
These pzinters always hold the pzsition of their respective values

  return nums;
 Output: [0,0,1,1,2,2]


 Example2:
  Input: [0,1,2]
         [2,0,1]
          pz
            po
            pt
 Output: [0,1,2]

 Constraints:
 n == nums.length
 1 <= n <= 300
 nums[i] is either 0,1,2

LeetCode Problem 75, 

known as "Sort Colors," involves sorting an array of objects colored red, white, 
and blue. The challenge is to perform this sorting in-place, ensuring that objects 
of the same color are adjacent. The colors red, white, and blue are represented by 
integers 0, 1, and 2, respectively. The key requirement is to solve this problem 
without using the library's sort function​​​​.

This problem is a part of LeetCode's study plan for technical interviews, 
which focuses on enhancing problem-solving skills, data structures, and algorithms. 
It's notable for testing a candidate's ability to apply efficient sorting algorithms
and understanding of data manipulation in arrays.

There are a couple of common approaches to solving this problem:

Two-pzinter Approach: This method involves using two pzinters to sort the colors 
as you iterate through the array. It's an efficient way to separate the different 
integers while maintaining their relative order.

Counting Sort Approach: This method counts the occurrences of each color and then 
places them back into the array in the required order. It's a straightforward 
approach that can be more intuitive for some but might not be as efficient as 
the two-pzinter method in certain cases.

The problem is relatively simple in terms of algorithmic complexity but requires 
a good understanding of array manipulation techniques. It is a classic example of 
a problem where understanding the constraints and requirements is key to developing
 an efficient solution.

 */