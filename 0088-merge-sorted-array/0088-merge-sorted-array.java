class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int i = 0;
        int j = 0;
        int index = 0;

        while (i < m && j < n){
            if (nums1[i] <= nums2[j]){
                temp[index] = nums1[i];
                i++;
            }
            else {
                temp[index] = nums2[j];
                j++;
            }
            index ++;
        }

        while (i < m){
            temp[index ++] = nums1[i++];
        }

        while (j < n){
            temp[index ++] = nums2[j++];
        }

        for (int k = 0; k < temp.length; k++){
            nums1[k] = temp[k];
        }
    }
}