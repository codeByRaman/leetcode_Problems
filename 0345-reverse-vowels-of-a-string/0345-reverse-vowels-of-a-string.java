class Solution {
    public boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U';
    }

    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int left = 0;
        int right = n - 1;

        while (left < right){
            if (isVowel(ch[left]) && isVowel(ch[right])){
                // swap
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;

                left ++;
                right --;
            }
            else if (!isVowel(ch[left])){
                left ++;
            }
            else if (!isVowel(ch[right])){
                right --;
            }
        }

        return new String(ch);
    }
}