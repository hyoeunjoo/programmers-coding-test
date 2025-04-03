import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
       
        int minLength =0;
        
        int maxLength = Arrays.stream(sizes).flatMapToInt(Arrays::stream).max().getAsInt();
        
        minLength = Arrays.stream(sizes).mapToInt(row -> Math.min(row[0],row[1])).max().getAsInt();
        
    return maxLength*minLength;

    }
}