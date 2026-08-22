class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int left = 0;
        int right = n - 1;

        ArrayList<Character> list = new ArrayList<>(Arrays.asList(
            'A', 'E', 'I', 'O', 'U',
            'a', 'e', 'i', 'o', 'u'
        ));

        while (left < right){
            if (list.contains(ch[left]) && list.contains(ch[right])){
                // swap those value;
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left ++;
                right --;
            }
            else if (!list.contains(ch[left])){
                left ++;
            }
            else if (!list.contains(ch[right])){
                right --;
            }
        }
        return new String(ch);
    }
}