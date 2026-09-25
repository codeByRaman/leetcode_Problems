import java.util.*;

class Solution {
    int i = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parseExpression(expression);

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    // Handles union: A,B
    Set<String> parseExpression(String s) {
        Set<String> result = parseTerm(s);

        while (i < s.length() && s.charAt(i) == ',') {
            i++; // skip ','

            Set<String> next = parseTerm(s);
            result.addAll(next);
        }

        return result;
    }

    // Handles concatenation: AB
    Set<String> parseTerm(String s) {
        Set<String> result = new HashSet<>();
        result.add("");

        while (i < s.length()
                && s.charAt(i) != '}'
                && s.charAt(i) != ',') {

            Set<String> next = parseFactor(s);

            Set<String> combined = new HashSet<>();

            for (String a : result) {
                for (String b : next) {
                    combined.add(a + b);
                }
            }

            result = combined;
        }

        return result;
    }

    // Handles character or {...}
    Set<String> parseFactor(String s) {
        Set<String> result;

        if (s.charAt(i) == '{') {
            i++; // skip '{'

            result = parseExpression(s);

            i++; // skip '}'
        } else {
            result = new HashSet<>();
            result.add(String.valueOf(s.charAt(i)));
            i++;
        }

        return result;
    }
}