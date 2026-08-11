class Solution {
    public String ReverseStr(String s){
        int n = s.length() -1;
        String temp = "";
        for (int i = n; i >= 0 ; i--){
            temp += s.charAt(i);
        }
        return temp;
    }

    public String addBinary(String a, String b) {
        int n = a.length()-1;
        int m = b.length()-1;
        int carry = 0;

        String result = "";

        while (n >= 0 || m >= 0 || carry > 0){
            int sum = carry;
            if (n >= 0){
                sum += a.charAt(n) - '0';
                n--;
            }

            if ( m >= 0){
                sum += b.charAt(m) - '0';
                m--;
            }

            int temp = sum % 2;
            result += temp;
            carry = sum / 2;
        }
        return ReverseStr(result);
    }
}