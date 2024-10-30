class Solution {
    public int[] solution(int brown, int yellow) {
        int sumOfCells = brown + yellow;

        for (int h = 3; h * h <= sumOfCells; h++) {
            if (sumOfCells % h == 0) {
                int w = sumOfCells / h;

                if ((w - 2) * (h - 2) == yellow) {
                    return new int[]{w, h};
                }
            }
        }
        return new int[0];
    }
}
