class Solution {
    public int mirrorDistance(int n) {
        int reverse = 0,temp = n;
        while(temp  != 0){
            reverse = (reverse * 10) + (temp % 10);
            temp = temp / 10;
        }
        return Math.abs(reverse - n);
    }
}