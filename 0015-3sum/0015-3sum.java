class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 2; i++){

            // checking the element which is on positon of i is equal or not if equal then continue (skip).
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i + 1;
            int right = n - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    output.add(temp);
                    left ++;
                    right --;
                    
                    // checking the element which is on positon of left is equal or not if equal then increase left pointer.
                    while ( left < right && nums[left] == nums[left -1]){
                        left ++;
                    }

                    //  // checking the element which is on positon of right is equal or not if equal then decrease right pointer.
                    while (left < right && nums[right] == nums[right + 1]){
                        right --;
                    }
                }
                else if(sum < 0){
                    left ++;
                }
                else {
                    right --;
                }
            }
        }

        return output;
    }
}