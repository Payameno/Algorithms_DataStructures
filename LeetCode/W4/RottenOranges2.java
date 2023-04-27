import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges2 {

  int[][] arr;
  
  boolean inRange(int i, int j) {
    return !(i<0||i>=arr.length||j<0||j>=arr[0].length);
  }
  
  public int orangesRotting(int[][] grid) {
    
    arr = grid;
    int ans=0;
    Queue<int[]> q = new LinkedList<>();
    int zero=0,one=0,two=0;

    //possible movements
    int[] v = new int[] {0,0,-1,1};
    int[] h = new int[] {-1,1,0,0};


    //---Count zeros,ones and twos and add rotten positions to the queu
    for (int i=0;i<arr.length;i++) {
      for (int j=0;j<arr[0].length;j++) {
        if(arr[i][j]==0) {
          zero++;
        } else if(arr[i][j]==1) {
          one++;
        } else {
          two++;
          q.add(new int[] {i,j,0});
        }
      }
    }

    //--Where all cells have same value
    int size = arr.length*arr[0].length;
    if (size==zero || size==two) return 0;
    if(size==one) return -1;

    //--
    while(!q.isEmpty()) {
      size=q.size();

      for (int k=0;k<size;k++) {
        int[] temp = q.poll();
        int lapse = temp[2];

        for(int l=0;l<4;l++) {
          int a = temp[0]+v[l];
          int b = temp[1]+h[l];
          if (inRange(a, b) && arr[a][b]==1) {
            q.add(new int[] {a,b,lapse+1});
            arr[a][b]=2;
            ans=lapse+1;
            one--;
          }
        }
      }
      if(one<=0) break; //if there are no more fresh fruis break the loop
    }
    if (one!=0) return -1; //return -1 if it is impossible to infect all furits
    return ans;
  }

}
