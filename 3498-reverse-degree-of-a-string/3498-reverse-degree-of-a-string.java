class Solution {
    public int reverseIndex(char s){
        return -(s - 'a' - 26);
    }
    public int reverseDegree(String s) {
        char[] str = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < str.length; i++){
            int temp = reverseIndex(str[i]);
            sum = sum + ( temp * (i+1));
        }
        return sum;
    }
}