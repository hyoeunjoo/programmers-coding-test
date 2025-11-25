class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        
        //캐릭터의 현 위치
         int[] answer = new int[]{0,0};
        
        //가로 세로
        int width = board[0];
        int height = board[1];
        
        int maxWidth = (width - 1)/2;
        int maxHeight = (height - 1)/2;
        
 for (String c : keyinput) {

            if (c.equals("left")) {
                answer[0] = Math.max(answer[0] - 1, -maxWidth);
            }

            if (c.equals("right")) {
                answer[0] = Math.min(answer[0] + 1, maxWidth);
            }

            if (c.equals("up")) {
                answer[1] = Math.min(answer[1] + 1, maxHeight);
            }

            if (c.equals("down")) {
                answer[1] = Math.max(answer[1] - 1, -maxHeight);
            }
        }
        return answer;
    }
}