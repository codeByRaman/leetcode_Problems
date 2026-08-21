class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();

        int n = str1.length;
        int m = str2.length;

        int i = 0, j = 0, k = 0;

        char[] str3 = new char[n+m];

        while ( i < n || j < m){
            if (i < n){
                str3[k] = str1[i];
                k++;
                i++;
            }

            if( j < m){
                str3[k] = str2[j];
                k++;
                j++;
            }
        }

        return new String(str3);
    }
}