class Solution {
    public int reverse(int num){
        int store = 0;
        while (num != 0){
            store = (store * 10) + (num % 10);
            num = num / 10;
        }
        return store;
    }
    public boolean isPalindrome(int x) {
        if (x >= 0) {
            int store = reverse(x);
            if (store == x){
                return true;
            }
        }
        return false;
    }
}