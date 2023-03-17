/**
 * 
 * @param numCourses 
 * @param prerequisites 
 * 
 * Example 1:
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

function canFinish(numCourses: number, prerequisites: number[][]): boolean {
  //BSF Solution
  let adjList: number[][] = new Array(numCourses).fill(null).map(() => []);
  let inEdges: number[] = new Array(numCourses).fill(0);
  const queue: number[] = [];

  for (const [course, pre] of prerequisites) {
    adjList[pre].push(course);
    inEdges[course]++;
  }

  for (let i = 0; i < numCourses; i++) {
    if (inEdges[i] === 0) {
      queue.push(i);
    }
  }
  
  let count = 0
  while (queue.length) {
    const node = queue.shift()!;
    count++;
    for (let neighbour of adjList[node]) {
      inEdges[neighbour]--;
      if (inEdges[neighbour] === 0) {
        queue.push(neighbour);
      }
    }
  }
  return count === numCourses;
};

function canFinishDSF(numCourses: number, prerequisites: number[][]): boolean {
  // Create an adjacency list to represent the graph
  const graph: Map<number, number[]> = new Map();
  for (let i = 0; i < numCourses; i++) {
    graph.set(i, []);
  }
  for (const [u, v] of prerequisites) {
    graph.get(v)!.push(u);
  }
  
  // Create an array to track the visited status of each node
  const visited: number[] = new Array(numCourses).fill(0);
  
  // DFS helper function to perform topological sort
  function dfs(node: number): boolean {
    // If this node is currently being visited, there is a cycle
    if (visited[node] === 1) {
      return false;
    }
    // If this node has already been visited, it's safe to skip it
    if (visited[node] === 2) {
      return true;
    }
    // Mark this node as being visited
    visited[node] = 1;
    // Recursively visit all neighbors of this node
    for (const neighbor of graph.get(node)) {
      if (!dfs(neighbor)) {
        return false;
      }
    }
    // Mark this node as visited
    visited[node] = 2;
    return true;
  }
  // Visit each node in the graph using DFS
  for (let i = 0; i < numCourses; i++) {
    if (!dfs(i)) {
      return false;
    }
  }
  
  // If we made it this far, there is no cycle in the graph
  return true;
}
