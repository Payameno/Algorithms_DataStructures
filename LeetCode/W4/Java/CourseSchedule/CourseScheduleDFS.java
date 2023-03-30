package W4.Java.CourseSchedule;

import java.util.Stack;

/*
 *  * Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
 
class SolutionDFS {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
      
    //Create an ArrayList of Adjacency List
    List<List<Integers>> adjList = new ArrayList<>(numCourses);

    //Create a static array to record in-degrees
    int[] inDegree = int[numCourses];

    //Initialize adjList for the courses
    for (int i=0; i<numCourses; i++) {
      adjList.add(new ArrayList<>());
    }

    //set adj in the list, set indegrees
    for (int[] prerequisite : prerequisites) {
      int course = prerequisite[0];
      int pre = prerequisite[1];
      adjList.get(pre).add(course);
      inDegree[course]++;
    }

    //Topological sort - BFS

    //Create a stack (IFLO)
    Stack<Integer> stack = new Stack<>();

    //loop to find vertexes where indegree=0
    for (int vertex : inDegree) {
      if (vertex == 0) {
        stack.push(vertex);
      }
    }

    //Untill stack has vertexes continue visiting neighbours
    while(!stack.isEmpty()) {
      int node = stack.pop();

      for (int neighbour : adjList.get(node)) {
        inDegree[neighbour]--;
        if (inDegree[neighbour] == 0) {
          stack.push(neighbour);
        }

      }
    }

    //Check if all nodes have inDegree = 0 which means there is no cycle
    for (int i=0; i<numCourses; i++) {
      if (inDegree[i] > 0) {
        return false;
      }
    }
    return true;
  }

}