import java.util.HashMap;

class Solution {
    public int[] solution(int N, int[] stages) {
    
        
        int[] user = new int[N+2];
        
        for (int i=0; i< stages.length; i++){
            user[stages[i]] += 1;
        }
        
        HashMap<Integer, Double> failure = new HashMap<>();
        double total = stages.length;
        
        for(int i=1; i<= N; i++){
            if(user[i]==0){
                failure.put(i,0.);
            }
            else{
                failure.put(i,user[i]/total);
                total -= user[i];
            }
            
        }
        return failure.entrySet().stream().sorted((o1,o2) -> Double.compare(o2.getValue(), o1.getValue()))
            .mapToInt(HashMap.Entry::getKey)
            .toArray();
    }
}