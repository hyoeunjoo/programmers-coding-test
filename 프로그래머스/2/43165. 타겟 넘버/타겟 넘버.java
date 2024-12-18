class Solution {
    public int solution(int[] nums, int tgt) {
        return explore(nums, tgt, 0, 0);
    }

    private int explore(int[] nums, int tgt, int idx, int currentSum) {
        if (idx == nums.length) {
            return currentSum == tgt ? 1 : 0;
        }
        return explore(nums, tgt, idx + 1, currentSum + nums[idx])
             + explore(nums, tgt, idx + 1, currentSum - nums[idx]);
    }
}