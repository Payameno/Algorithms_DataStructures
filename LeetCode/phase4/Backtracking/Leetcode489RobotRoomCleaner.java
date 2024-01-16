import java.util.*;

class Solution {
  int[][] DIRECTION = {{-1 , 0}, {0 , 1}, {1 , 0}, {0 , -1}};
  Set<String> visited = new HashSet<>();
  public void cleanRoom(Robot robot) {
    dfs(0, 0, robot, 0); //We consider current position of the robot as the center of the y&x axis
  }

  private void dfs(int row, int col, Robot robot, int arrow) {
    String cell = row + "," + col; // A string of the curret coordinates
    
    //Check whether the cell is visited
    if (!visited.contains(cell)) {
      visited.add(cell); // Add the current position to the set

      robot.clean(); // Clean the cell

      //Check if you can move to the direction, do dfs if possible
      for (int i = 0; i < 4; i++) {
        if (robot.move()) {
          int[] curDirc = DIRECTION[arrow];
          dfs(row + curDirc[0], col + curDirc[1], robot);
        }

        //Change direction of the robot and code to follow the move: respectively right, down, left
        robot.turnRight();
        arrow = (arrow + 1) % 4;

      }

    }

    //Backtrack
    moveBack(robot);

  }

  //Create a new method for the Robot iterface
  private void moveBack(Robot robot) {

    //Turn 180 Degrees
    robot.turnLeft();
    robot.turnLeft();

    //Move forward
    robot.move();

    //adjust the direction of the robot
    robot.turnRight();
    robot.turnRight();

  }
}

/*
Time complexity:
Linear or O(c) where c is the number of cells ( c = m*n )

Space complexity:
Overall O(n )
The space required for the hashSet is O(n)
Also the depth of the call stack determines the auxiliary space required, since
the robot turns in 4 directions in the worst case it would be O(n)

 interface Robot {
  // returns true if next cell is open and robot moves into the cell.
  // returns false if next cell is obstacle and robot stays on the current cell.
  boolean move();

  // Robot will stay on the same cell after calling turnLeft/turnRight.
  // Each turn will be 90 degrees.
  void turnLeft();
  void turnRight();

  // Clean the current cell.
  void clean();
}


Example:
Input:
room = [
  [1,1,1,1,1,0,1,1],
  [1,1,1,1,1,0,1,1],
  [1,0,1,1,1,1,1,1],
  [0,0,0,1,0,0,0,0],
  [1,1,1,1,1,1,1,1]
],
row = 1,
col = 3

Explanation:
All grids in the room are marked by either 0 or 1.
0 means the cell is blocked, while 1 means the cell is accessible.
The robot initially starts at the position of row=1, col=3.
From the top left corner, its position is one row below and three columns right.

Notes:
The input is only given to initialize the room and the robot's position internally. You must solve this problem "blindfolded". In other words, you must control the robot using only the mentioned 4 APIs, without knowing the room layout and the initial robot's position.
The robot's initial position will always be in an accessible cell.
The initial direction of the robot will be facing up.
All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
Assume all four edges of the grid are all surrounded by wall.
 */