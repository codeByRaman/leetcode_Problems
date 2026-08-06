class Solution {
    public int hammingWeight(int n) {
      //  Brian Kernighan's Algorithm
        int count = 0;
        while (n != 0){
            count ++;
            n = n & (n - 1);
        }
        return count;
    }
}