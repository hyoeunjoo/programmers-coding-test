import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int listLenght = id_list.length;
        int[] answer = new int[listLenght];

        // 유저 이름 + 인덱스 번호
        Map<String, Integer> nameMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            nameMap.put(id_list[i], i);
        }

        // 중복 제거
        Set<String> uniqueReports = new HashSet<>(Arrays.asList(report));

        // 횟수 세기
        Map<String, Integer> reportCountMap = new HashMap<>();
        for (String r : uniqueReports) {
            String[] parts = r.split(" ");
            String reported = parts[1];
            reportCountMap.put(reported, reportCountMap.getOrDefault(reported, 0) + 1);
        }

        // 정지된 유저
        Set<String> banned = new HashSet<>();
        for (String user : reportCountMap.keySet()) {
            if (reportCountMap.get(user) >= k) {
                banned.add(user);
            }
        }

        for (String r : uniqueReports) {
            String[] parts = r.split(" ");
            String reportTo = parts[0];
            String reported = parts[1];

            if (banned.contains(reported)) {
                answer[nameMap.get(reportTo)]++;
            }
        }

        return answer;
    }
}
