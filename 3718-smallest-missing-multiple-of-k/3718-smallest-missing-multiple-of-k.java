class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++){
            list.add(nums[i]);
        }

        int answer = 0; 

        for (int i = 0; i < n ; i++){
            answer += k;
            if (!list.contains(answer)){
                return answer;
            }
        }
        return k * (n + 1);
    }
}