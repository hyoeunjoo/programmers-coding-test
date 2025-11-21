class Solution {
    
    static int arrow;
    static int apeach[];
    static int ryan[];
    
    static int best[];
    
    static boolean win[];
    static int maxDiff;
    
    
    public int[] solution(int n, int[] info) {
        
        arrow = n;
        apeach = info; // 입력 배열 직접 참조
        ryan = new int[11];
        
        // 배열의 길이를 지정하지 않고 초기값 1만 넣음.
        best = new int[]{-1};
        win = new boolean[11];
        
        maxDiff = 0;
        
        //dfs
        dfs(0, n);
        return best;
    }
    
    //dfs 구현
    private void dfs(int idx, int arrow){
        
        // 종료 조건 (어쨌든 인덱스의 끝에 도달했다는게 종료 조건임)
        // 인덱스의 끝에 도달했거나 화살이 없는 경우
        if(idx == 11 || arrow == 0){
            //인덱스의 끝에 도달했는데 화살이 남은 경우
            if(idx == 11 && arrow > 0){
                // 마지막 인덱스에 화살을 몰아 넣는다.
                ryan[10] += arrow;
            }
            
            // 이제 계산을 해줘야 됨. 인덱스의 끝에 도달했으니까
            
            int apeachScore = 0;
            int ryanScore = 0;
            
            for(int i = 0 ; i < 11 ; i++){
                // 둘 다 0점인 경우
                if(apeach[i] == 0 && ryan[i] == 0){
                    continue;
                }
                // 라이언이 이긴 경우
                if(win[i] == true){
                    //주의 ㅋㅋ 10점부터임
                    ryanScore += (10-i);
                }
                //동점인 경우 -> 어피치 승
                else if(apeach[i] > 0){
                    apeachScore += (10-i);
                }
            }
            
            int diff = ryanScore - apeachScore;
            
            if (diff > 0) {
                if(diff > maxDiff || (diff == maxDiff && isBest(ryan,best))){
                    //갱신
                    maxDiff = diff;
                    best = ryan.clone();
                }
            }
            
            //아까의경우임. 근데 아까도 그렇고 같은 조건에서 arrow자체를 없앤건 아님.
            //배열 내의 값을 바꿔준다고 생각하면 됨.
            if (idx == 11 && arrow > 0) {
                ryan[10] -= arrow; 
            }
            return; // 종료 시 반드시 return 해줘야 함
        }
        
        // 해당 점수에서 이긴 경우 (apeach보다 남아있는 화살이 많은 경우에만 가능 )
        if(arrow > apeach[idx]){
            win[idx] = true;
            ryan[idx] = apeach[idx] + 1;
            
            dfs(idx + 1 , arrow - ryan[idx]);
            
            // 복구
            win[idx] = false;
            ryan[idx] = 0;
        }  
        
        // 해당 점수에서 진 경우
        dfs(idx + 1, arrow);
    }
    
    private boolean isBest(int current[], int prev[]){
        if(prev[0] == -1) return true;
        
        for (int i = 10; i >= 0; i--) { 
            if (current[i] != prev[i]) {
                return current[i] > prev[i]; 
            }
        }
        return false; 
    }
}
