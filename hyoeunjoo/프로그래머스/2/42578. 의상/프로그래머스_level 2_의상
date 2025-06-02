import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> clothesPerCategory = new HashMap<>();
        
        for(String[] cloth : clothes) {
            
            String category = cloth[1];
            
            if(clothesPerCategory.containsKey(category)){
                
                int count = clothesPerCategory.get(category);
                clothesPerCategory.put(category, count+1);
                    
            }else{
                clothesPerCategory.put(category,1);
            }
        }
        
        int answer = 1;
        for(int count :clothesPerCategory.values()) {
            answer *= (count+1);
        }
        
        return answer-1;
        
        
        
        
        
    }
}