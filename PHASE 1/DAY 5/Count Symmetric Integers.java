class Solution {

    public int countSymmetricIntegers(int low, int high) {

        int count = 0;

        // check every number in the range
        for (int i = low; i <= high; i++) {

            // convert to string for easy digit access
            String s = String.valueOf(i);

            // odd length numbers can't be symmetric
            if (s.length() % 2 != 0) continue;

            if (isSymmetric(s)) {
                count++;
            }
        }

        return count;
    }

    public boolean isSymmetric(String s) {

        // simple case: 2-digit number
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1);
        }

        // compare sum of both halves
        int left = (s.charAt(0) - '0') + (s.charAt(1) - '0');
        int right = (s.charAt(2) - '0') + (s.charAt(3) - '0');

        return left == right;
    }
}

/*
Time Complexity: O(high - low)
Space Complexity: O(1)
*/
