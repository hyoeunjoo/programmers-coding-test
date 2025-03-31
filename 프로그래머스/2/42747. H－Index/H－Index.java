import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int left = 0;
        int right = citations.length - 1;
        
        while (left <= right) {
            int medianIndex = (left + right) / 2; 
            int medianValue = citations[medianIndex];
            
            int moreCount = citations.length - medianIndex; 
            
            if (moreCount == medianValue) { 
                return medianValue;
            } else if (moreCount > medianValue) { 
                left = medianIndex + 1;
            } else { 
                right = medianIndex - 1;
            }
        }
        
        return citations.length - left; 
    }
}
