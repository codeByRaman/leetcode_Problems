class Solution {
    public String reverse(String s){
        StringBuilder reverse = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i--){
            reverse.append(s.charAt(i));
        }
        return reverse.toString();
    }
    public boolean isPalindrome(String s) {
        StringBuilder temp = new StringBuilder();
        s = s.toLowerCase();
        for(int i = 0; i < s.length() ; i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                temp.append(s.charAt(i));
            }
        }

        String rev = reverse(temp.toString());
        return rev.contentEquals(temp);
    }
}