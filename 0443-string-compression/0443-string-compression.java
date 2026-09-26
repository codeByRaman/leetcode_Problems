class Solution {
    public int compress(char[] chars) {

        int n = chars.length;
        int answer = 0;
        int count = 1;

        for (int i = 1; i <= n; i++) {

            if (i < n && chars[i] == chars[i - 1]) {
                count++;
            } 
            else {

                // Character write karo
                chars[answer++] = chars[i - 1];

                // Count write karo
                if (count > 1) {

                    String s = String.valueOf(count);

                    for (int j = 0; j < s.length(); j++) {
                        chars[answer++] = s.charAt(j);
                    }
                }

                count = 1;
            }
        }

        return answer;
    }
}