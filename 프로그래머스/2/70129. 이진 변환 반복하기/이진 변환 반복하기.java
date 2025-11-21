class Solution {
    public int[] solution(String s) {
        
        // 정답 배열
        int[] answer = new int[2];
        
        // 변수
        int changeCount = 0;
        int removeCount = 0;
        
        while(!s.equals("1")){
            
            int oldLength = s.length();
            int oneCount = 0;
            
            for (char c : s.toCharArray()) {
                if (c == '1') oneCount++;
            }
            
            removeCount += oldLength - oneCount;
            
            s = Integer.toBinaryString(oneCount);        
            
            changeCount++;
        }
        
        answer[0] = changeCount;
        answer[1] = removeCount;
    
        return answer;
        
    }
}