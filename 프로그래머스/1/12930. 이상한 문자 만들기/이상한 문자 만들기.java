class Solution {
    public String solution(String s) {
     StringBuilder answer = new StringBuilder();
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == ' ') {
                answer.append(currentChar);
                index = 0;
            } else {
                if (index % 2 == 0) {
                    answer.append(Character.toUpperCase(currentChar));
                } else {
                    answer.append(Character.toLowerCase(currentChar));
                }
                index++;
            }
        }

        return answer.toString();
    }
    }