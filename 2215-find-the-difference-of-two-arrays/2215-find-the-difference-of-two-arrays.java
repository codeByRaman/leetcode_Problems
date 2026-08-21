class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();

        HashSet<Integer> temp2 = new HashSet<>();
        for (int num : nums2){
            temp2.add(num);
        }
        HashSet<Integer> temp3 = new HashSet<>();
        for (int num : nums1){
            if (!temp2.contains(num)){
                temp3.add(num);
            }
        }
        List<Integer> ans1 = new ArrayList<>(temp3);
        result.add(ans1);

        HashSet<Integer> temp = new HashSet<>();
        for (int num : nums1){
            temp.add(num);
        }

        HashSet<Integer> temp1 = new HashSet<>();
        for (int num : nums2){
            if (!temp.contains(num)){
                temp1.add(num);
            }
        }

        List<Integer> ans2 = new ArrayList<>(temp1);
        result.add(ans2);

        

        return result;
    }
}