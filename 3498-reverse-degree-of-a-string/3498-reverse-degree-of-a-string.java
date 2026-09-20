class Solution {
    public int reverseIndex(char s){
        return -(s - 'a' - 26);
    }
    public int reverseDegree(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++){
            sum += (reverseIndex(s.charAt(i))*(i+1));
        }    
        return sum;
    }
}