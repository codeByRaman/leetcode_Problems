class Solution {
    
    public String addBinary(String a, String b) {
        int n = a.length()-1;
        int m = b.length()-1;
        int carry = 0;

        StringBuilder result = new StringBuilder();

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

            result.append(sum % 2);
            carry = sum / 2;
        }
        return result.reverse().toString();
    }
}