class Solution {
    public int maxProduct(int n) {
        int max = Integer.MIN_VALUE;
        int secondmax = 0;
        while (n != 0){
            int num = n % 10;
            if (max <= num){
                secondmax = max;
                max = num;
            }else if (num > secondmax && num != max){
                secondmax = num;
            }
            n = n / 10;
        }
        return max * secondmax;
    }
}