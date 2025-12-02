import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        int numGoal = nums.length/2;
        
        for(int i : nums){
            if(!map.containsKey(i)){
                map.put(i,1);
            }

            int value = map.get(i);
            map.put(i, value + 1);
        }
        
        // 종류가 더 많으면 사이즈 반환, 그 반대의 경우 종류 반환
        if( numGoal < map.size()){
            return numGoal;
        }else 
            return map.size();

    }
}