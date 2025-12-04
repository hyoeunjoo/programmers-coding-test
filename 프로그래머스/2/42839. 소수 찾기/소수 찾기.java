import java.util.*;

class Solution {
    // 중복 방지
    Set<Integer> number = new HashSet<>();
    
    public int solution(String numbers) {
        // 주어진 string을 ""로 나누고 List에 넣기
         String[] numberString = numbers.split("");
        
        
        //방문 배열 생성
        boolean []visited = new boolean[numberString.length];
        dfs(numberString,visited, "");
        
        int answer = 0;
        
        for(int n : number){
            if(isPrime(n)){
                answer++;
            }
        }
        
        return answer;
        
    }
        private void dfs(String[] numberList, boolean[] visited, String current ){
            //현재 문자열이 비어있지 않다면 set에 넣기
            if(!current.isEmpty()){
                number.add(Integer.parseInt(current));
            }
            
            for(int i = 0 ;  i < numberList.length; i++){
                if(visited[i]) continue;
                
                 visited[i] = true;
                 dfs(numberList, visited, current + numberList[i]);
                 visited[i] = false;
            }
        }
        
        private boolean isPrime(int n){
            // n이 1보다 작은 경우 빼기
            if(n <= 1) return false;
            
            for(int i = 2; i*i <= n; i++){
                if(n%i == 0){
                    return false;
                }
            }
            return true;
        }
    
}