class Solution {
    public int firstMatchingIndex(String s) {
        char[] ch = s.toCharArray();

        int n = ch.length;

        int left = 0;
        int right = n - 1;

        while (left <= right){
            if (ch[left] == ch[right]){
                return left;
            }
            left ++;
            right --;
        }
        return -1;
    }
}