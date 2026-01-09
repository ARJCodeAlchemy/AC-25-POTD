//====================================================
//----------- Approach -------
//====================================================
/*
Time Complexity:
- Outer loop runs at most min(31, n) times.
- Inner loop scans all n elements.
- Overall: O(31 * n) ≈ O(n)

Space Complexity:
- O(n) for the visited array.

Short Explanation:
- We want to reorder the array to maximize the prefix bitwise OR values.
- We maintain a running OR (curOr).
- In each step, we greedily pick the unused number that maximizes (curOr | a[i]).
- After at most 31 steps, curOr becomes saturated (all bits set),
  so further choices don’t improve OR value.
- Remaining elements can be printed in any order.
*/


//====================================================
//----------- JAVA Solution -------
//====================================================
static void solve() throws IOException {

    int n = ii();
    int[] a = new int[n];

    // read array
    for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
    }

    int curOr = 0;               // current accumulated OR
    boolean[] vis = new boolean[n]; // marks elements already chosen

    /*
     We only need at most 31 iterations because:
     - Integers are up to 32 bits
     - Once all bits are set in curOr, OR will no longer change
    */
    for (int i = 0; i < Math.min(31, n); i++) {

        int bestOr = 0;
        int bestIdx = -1;

        /*
         Greedily choose the unused element which gives
         the maximum OR value when combined with curOr
        */
        for (int j = 0; j < n; j++) {
            if (vis[j]) continue;

            int newOr = curOr | a[j];

            if (newOr > bestOr) {
                bestOr = newOr;
                bestIdx = j;
            }
        }

        // place the chosen element
        System.out.print(a[bestIdx] + " ");
        vis[bestIdx] = true;
        curOr |= a[bestIdx];
    }

    /*
     Remaining elements do not affect OR anymore,
     so we can print them as they are
    */
    for (int i = 0; i < n; i++) {
        if (!vis[i]) {
            System.out.print(a[i] + " ");
        }
    }

    System.out.println();
}


//====================================================
//----------- C++ --------------
//====================================================
/*
void solve() {
    int n;
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    int curOr = 0;
    vector<bool> vis(n, false);

    // at most 31 useful iterations
    for (int i = 0; i < min(31, n); i++) {

        int bestOr = 0;
        int bestIdx = -1;

        // choose the best unused element
        for (int j = 0; j < n; j++) {
            if (vis[j]) continue;

            int newOr = curOr | a[j];
            if (newOr > bestOr) {
                bestOr = newOr;
                bestIdx = j;
            }
        }

        cout << a[bestIdx] << " ";
        vis[bestIdx] = true;
        curOr |= a[bestIdx];
    }

    // print remaining elements
    for (int i = 0; i < n; i++) {
        if (!vis[i]) {
            cout << a[i] << " ";
        }
    }

    cout << "\n";
}
*/


//====================================================
//----------- Extra Insights ----------
//====================================================
/*
Key Greedy Insight:
- Bitwise OR only increases when new bits are introduced.
- Once all bits are set, no future OR operation can improve the value.

Why 31 iterations is enough:
- An integer has at most 31 useful bits (for typical constraints).
- Each iteration can set at least one new bit.
- After that, OR becomes stable.

Why Greedy Works Here:
- We always choose the element that maximizes immediate OR gain.
- Future gains depend only on which bits are already set,
  not on order beyond saturation.

Pattern Recognition:
- This is a classic "bitmask greedy" problem.
- Similar ideas appear in:
  - Maximizing OR prefixes
  - Greedy bit contribution problems
  - Mask saturation problems

How to Get Better at These Problems:
1) Think in terms of **bits, not numbers**.
2) Ask: "What changes, and what becomes useless after some point?"
3) Always check if the process saturates early (like 31 here).
4) Practice problems involving OR / AND greedily.

One-Line Takeaway:
- When OR is involved, think about **bit contribution and saturation**, not permutations.
*/
