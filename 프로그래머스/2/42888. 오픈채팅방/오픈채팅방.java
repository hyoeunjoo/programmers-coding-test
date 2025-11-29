import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String,String> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        
         for (String r : record) {
            String[] parts = r.split(" ");
            String command = parts[0];
            String id = parts[1];
             
            // 처음 들어온 사용자와 기존 사용자에게 해줘야 하는 행동은 동일함
            // Change와도 동일함
            if (command.equals("Enter") || command.equals("Change")) {
                String name = parts[2];
                map.put(id, name);
            }
        }

        
        // 2단계: 메시지 저장
        for (String r : record) {
            String[] parts = r.split(" ");
            String command = parts[0];
            String id = parts[1];

            if (command.equals("Enter")) {
                result.add(map.get(id) + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                result.add(map.get(id) + "님이 나갔습니다.");
            }
        }

        
        return result.toArray(new String[0]);
    }
}