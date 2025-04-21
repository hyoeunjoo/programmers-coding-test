import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[] moveX = {-1,1,0,0};
        int[] moveY = {0,0,-1,1};
        
        
        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[]{0,0}); //시작점
        
        while(bfsQueue.isEmpty() == false) {
            int[] currentLocation = bfsQueue.poll();
            int currentX = currentLocation[0];
            int currentY = currentLocation[1];
            
            for(int i = 0; i < 4; i++) {
                int nextX = currentX + moveX[i];
                int nextY = currentY + moveY[i];
                
                if(nextX>=0 && nextY >=0 && nextX<n && nextY <m){
                    if(maps[nextX][nextY]==1){
                        maps[nextX][nextY] = maps[currentX][currentY] + 1;
                        bfsQueue.add(new int[]{nextX,nextY});
                    }
                    
                }
            }
        }
        
        int answer = maps[n-1][m-1];
        return answer == 1 ? -1 : answer;        
    }
}