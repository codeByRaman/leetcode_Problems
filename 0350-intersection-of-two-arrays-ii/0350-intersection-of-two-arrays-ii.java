class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int min_index = Math.min(nums1.length,nums2.length);
        for (int num : nums1){
            list1.add(num);
        }
        
        for (int num_value : nums2){
            if(list1.contains(num_value)){
                list2.add(num_value);
                list1.remove(Integer.valueOf(num_value));
            }
        }

        int[] result = new int[list2.size()];

        int index = 0;
        for (int num : list2){
            result[index] = num;
            index ++;
        }
        return result;
    }
}