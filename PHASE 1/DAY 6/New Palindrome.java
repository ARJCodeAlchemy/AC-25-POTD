/* -------------------------------------Approach 1------------------------------------------ */
// ----------------- SOLVE HERE -----------------
static void solve() throws IOException {

    String s = ss();

    // take the first character as reference
    char c = s.charAt(0);

    // check only the first half
    for (int i = 1; i < s.length() / 2; i++) {

        // if any character differs, answer is YES
        if (s.charAt(i) != c) {
            op("YES");
            return;
        }
    }

    // all characters matched
    op("NO");
}
/* --------------------------------------------Approach 2------------------------------------------------------ */
/**
 The approach is to find if there exists two such different characters with even frequency, then it is possible
*/
static void solve() throws IOException {
    String s = ss();

    // frequency of each character
    Map<Character, Integer> map = new HashMap<>();

    char first = '*', second = '*';

    for (char c : s.toCharArray()) {

        map.put(c, map.getOrDefault(c, 0) + 1);

        // track characters whose count becomes even
        if (map.get(c) % 2 == 0) {

            if (first == '*') {
                first = c;
            } else if (c != first) {
                second = c;
            }
        }
    }

    // need at least two different characters with even count
    if (second == '*') {
        op("NO");
    } else {
        op("YES");
    }
}
