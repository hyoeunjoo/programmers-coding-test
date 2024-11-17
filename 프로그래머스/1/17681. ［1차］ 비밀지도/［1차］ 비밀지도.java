class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            int orOperation = arr1[i] | arr2[i];
            
            String binaryString = String.format("%" + n + "s", Integer.toBinaryString(orOperation));
            answer[i] = binaryString.replace('1', '#').replace('0', ' ');
        }
        
        return answer;
    }
}
