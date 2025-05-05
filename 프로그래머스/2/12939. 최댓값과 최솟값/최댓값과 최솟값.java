import java.util.*;

class Solution {
    public String solution(String s) {

        List<Integer> test = new ArrayList<>();
        for(String number : s.trim().split("\\s+")){
            test.add(Integer.parseInt(number));
                     }
                                           
    int min = Collections.min(test);
    int max = Collections.max(test);
                                           
        return min +" " + max;
    }
}
                                           