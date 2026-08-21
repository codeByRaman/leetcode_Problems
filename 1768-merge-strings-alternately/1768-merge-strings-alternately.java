class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();

        int n = str1.length;
        int m = str2.length;

        int i = 0, j = 0, k = 0;

        char[] str3 = new char[n+m];

        while (i < n && j < m){
            if (k % 2 == 0){
                str3[k] = str1[i];
                i ++;
            }else{
                str3[k] = str2[j];
                j ++;
            }
            k ++;
        }

        while (i < n){
            str3[k] = str1[i];
            i ++;
            k ++;
        }

        while (j < m){
            str3[k] = str2[j];
            j ++;
            k ++;
        }

        return new String(str3);
    }
}