class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums){
            set.add(num);
        }

        int answer = k;

        while (set.contains(answer)){
            answer += k;
        }

        return answer;
    }
}