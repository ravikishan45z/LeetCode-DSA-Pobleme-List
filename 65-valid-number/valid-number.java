class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExp = false;
        boolean seenDot = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // check digit -> yes/no
            if (Character.isDigit(ch)) {
                seenDigit = true;
            }

            // check sign --> +/-
            else if (ch == '+' || ch == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            // check decimal point '.'
            else if (ch == '.') {
                if (seenDot || seenExp) {
                    return false;
                }
                seenDot = true;
            }

            // check exponent
            else if (ch == 'e' || ch == 'E') {

                if (seenExp || !seenDigit) {
                    return false;
                }
                seenExp = true;
                seenDigit = false;
            }

            // invalid character.
            else {
                return false;
            }

        }
        return seenDigit;
    }
}