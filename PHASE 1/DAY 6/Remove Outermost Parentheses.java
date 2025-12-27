class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder sb = new StringBuilder();
        int c = 0; // keeps track of current nesting level

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                // add '(' only if it's not an outermost one
                if (c > 0) sb.append('(');
                c++;
            } else {
                c--;
                // add ')' only if it's not closing the outermost group
                if (c > 0) sb.append(')');
            }
        }

        return sb.toString();
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/
