import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        //동명이인 처리를 위한 등장횟수 기반 해시맵
        HashMap<String, Integer> answer = new HashMap<>();

        //참가자 넣기
        for (String name : participant) {
            answer.put(name, answer.getOrDefault(name, 0) + 1);
        }

        //완주자에 있는 사람이라면 횟수 차감
        for (String name : completion) {
            answer.put(name, answer.get(name) - 1);
        }

        //key들만 돌려본 뒤 그 안에서 value가 0이 아닌 애들만 출력
        for (String name : answer.keySet()) {
            if (answer.get(name) != 0) {
                return name;
            }
        }
    
        return "";
        
    }
}
