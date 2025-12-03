import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
      
    int max = 0;
        
    for (int[]  s : sizes) {
         for (int v : s) {
            max = Math.max(max, v);
        }
    }
    
    int min = 0;
    for(int i = 0; i < sizes.length; i++){
        int width = sizes[i][0];
        int height = sizes[i][1];

        // 둘 중 작은 값 선택
        int smaller = Math.min(width, height); 

        // 현재 min보다 크면 업데이트
        if (smaller > min) {          
            min = smaller;
        }
    }
        
        return min*max;
    }
}