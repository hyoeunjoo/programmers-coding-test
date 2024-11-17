class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            int newChar = c;

            int next = 0;
            while (next < index) {
                newChar++;
                if (newChar > 'z') {
                    newChar = 'a'; 
                }
               
                if (skip.indexOf((char) newChar) == -1) {
                    next++;
                }
            }
            answer.append((char) newChar); 
        }
        return answer.toString();
    }
}
