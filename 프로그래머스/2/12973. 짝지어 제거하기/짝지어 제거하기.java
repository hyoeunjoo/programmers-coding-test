class Solution
{
    public int solution(String s)
    {
        StringBuilder result = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            int len = result.length();
            if (len > 0 && result.charAt(len - 1) == c) {
                result.deleteCharAt(len - 1);
            } else {
                result.append(c);
            }
        }
        
        if (result.length() == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
