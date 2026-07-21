class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int temp = -1;
        for (int i = 1; i < nums.length ; i++){
            if(nums[i] == nums[i-1]){
                temp = nums[i];
            }
        }

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums){
            set.add(num);
        }

        int sum = 0;

        for(int num : set){
            sum += num;
        }

        int n = nums.length;

        int missing = (n * (n + 1) / 2) - sum;

        return new int[] {temp,missing};

    }
}