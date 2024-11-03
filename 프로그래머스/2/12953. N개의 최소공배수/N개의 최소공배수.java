class Solution {
    public int solution(int[] numbers) {
        int lcmAnswer = numbers[0];  

        for (int i = 1; i < numbers.length; i++) {
            lcmAnswer = calculateLCM(lcmAnswer, numbers[i]);
        }

        return lcmAnswer;
    }

    private int calculateLCM(int a, int b) {
        int gcd = calculateGCD(a, b);  
        return (a / gcd) * b;  
    }

    private int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
