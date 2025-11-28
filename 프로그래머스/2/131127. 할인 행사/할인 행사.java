import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        // want와 number를 합친 해시맵 
        Map<String, Integer> objects = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            objects.put(want[i], number[i]);
        }

        int objectNum = Arrays.stream(number).sum();   // 필요한 총 개수
        int discountDays = discount.length;            // 할인 기간
        int count = 0;                                  // 정답
        
        for (int i = 0; i <= discountDays - objectNum; i++) {

            // 매번 객체 복사 (중요)
            Map<String, Integer> temp = new HashMap<>(objects);
            
            int max = i + objectNum;

            boolean valid = true;

            for (int j = i; j < max; j++) {

                // 필요한 물건이 아니면 실패 → break
                if (!temp.containsKey(discount[j])) {
                    valid = false;
                    break;
                }

                int value = temp.get(discount[j]);

                // value > 0이면 -1
                if (value > 0) {
                    temp.put(discount[j], value - 1);
                }
            }

            // 필요한 물건이 아예 없는 경우라면 skip
            if (!valid) continue;

            // temp의 value가 모두 0이면 성공
            boolean allZero = true;
            for (int v : temp.values()) {
                if (v != 0) {
                    allZero = false;
                    break;
                }
            }

            if (allZero) count++;
        }
        
        return count;
    }
}
