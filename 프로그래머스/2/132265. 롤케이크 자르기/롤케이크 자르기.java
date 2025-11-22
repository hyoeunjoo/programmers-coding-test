import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> right = new HashMap<>();
        Set<Integer> left = new HashSet<>();

        // 오른쪽에 전체 넣기
        for (int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }

        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];

            left.add(t);                 // 왼쪽 종류 증가
            right.put(t, right.get(t) - 1); // 오른쪽에서 1개 제거

            if (right.get(t) == 0) {     // 오른쪽에 아예 없어지면 종류 감소
                right.remove(t);
            }

            if (left.size() == right.size()) {
                answer++;
            }
        }

        return answer;
    }
}
