package W4;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * 2 1 1
 * 1 1 0
 * 0 1 1
 */

class RottenOranges {

  public int orangesRotting(int[][] grid) {
    if (grid==null || grid.length==0) return -1;

    AtomicInteger numMinutes = new AtomicInteger(0);
    AtomicInteger numFresh = new AtomicInteger(0);
    int numRows = grid.length;
    int numCols = grid[0].length;
    
    //Find the number of fresh oranges using a nested loop
    for (int i=0; i<numRows; i++) {
      
      for (int j=0; j<numCols; j++) {
        if (grid[i][j]==1) {
          numFresh.getAndIncrement();
        }
      }
      
    }
    
    //Vertical - Find rotten oranges and set minute per loop
    Thread thread1 = new Thread(()-> {
      for (int i=0; i<numRows; i++) {
        AtomicInteger prevNumFresh = numFresh;
  
        for (int j=0; j<numCols; j++) {
  
          if (grid[i][j]==2) {
            
            int[] right = {i+1,j};
            int[] left = {i-1,j};
            int[] top = {i,j+1};
            int[] bottom = {i,j-1};
    
            int[][] neighbors = {right,left,top,bottom};
  
            //check cell's neighbors for fresh fruits - set them as rotten and indicate 1 minute
            for (int[] idx : neighbors) {
                int row = idx[0];
                int col = idx[1];
  
                if(idx[0]<0 || numRows<=row || col<0 || numCols<=col) continue;
  
                if (grid[row][col]==1) {
                  grid[row][col]=2;
                  
                  numFresh.getAndDecrement();
                }
              }
          }
          if (prevNumFresh.get()>numFresh.get()) {
            numMinutes.getAndIncrement();
            prevNumFresh = numFresh;
          }
        }
       }
    });

        //Horizental - Find rotten oranges and set minute per loop
        Thread thread2 = new Thread(()-> {
          for (int j=0; j<numCols; j++) {
            AtomicInteger prevNumFresh = numFresh;
      
            for (int i=0; i<numRows; i++) {
      
              if (grid[i][j]==2) {
                
                int[] right = {i+1,j};
                int[] left = {i-1,j};
                int[] top = {i,j+1};
                int[] bottom = {i,j-1};
        
                int[][] neighbors = {right,left,top,bottom};
      
                //check cell's neighbors for fresh fruits - set them as rotten and indicate 1 minute
                for (int[] idx : neighbors) {
                    int row = idx[0];
                    int col = idx[1];
      
                    if(idx[0]<0 || numRows<=row || col<0 || numCols<=col) continue;
      
                    if (grid[row][col]==1) {
                      grid[row][col]=2;
                      
                      numFresh.getAndDecrement();
                    }
                  }
              }
              if (prevNumFresh.get()>numFresh.get()) {
                numMinutes.getAndIncrement();
                prevNumFresh = numFresh;
              }
            }
           }
        });

    thread1.start();
    thread2.start();

    return numFresh.get() == 0 ? numMinutes.get(): -1;
  }  

}