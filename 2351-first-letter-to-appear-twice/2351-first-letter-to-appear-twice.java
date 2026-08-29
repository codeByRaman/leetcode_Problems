class Solution {
    public char repeatedCharacter(String s) {
        HashSet<Character> set = new HashSet<>();

        char[] ch = s.toCharArray();

        for (char cha : ch){
            if (set.contains(cha)){
                return cha;
            }
            set.add(cha);
        }
        return ' ';
    }
}