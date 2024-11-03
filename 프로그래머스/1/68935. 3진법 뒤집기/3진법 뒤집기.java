class Solution {
    public int solution(int n) {
        String basedTernary = new StringBuilder(Integer.toString(n, 3)).reverse().toString();
        int answer = Integer.parseInt(basedTernary, 3);
        
        return answer;
    }
}
