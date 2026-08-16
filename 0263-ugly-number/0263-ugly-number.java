class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        int[] factor = {2,3,5};

        for (int factors : factor){
            while (n % factors == 0){
                n /= factors;
            }
        }
        return n == 1;
    }
}