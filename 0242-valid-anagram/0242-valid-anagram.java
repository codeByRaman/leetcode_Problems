class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n != m) return false;

        int[] count_character = new int[26];

        for (int i = 0; i < n ; i ++){
           count_character[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < m ; i ++){
           count_character[t.charAt(i) - 'a']--;
        }

        for (int nums : count_character){
            if (nums != 0) return false;
        }

        return true;
    }
}