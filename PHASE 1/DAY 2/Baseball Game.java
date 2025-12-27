//---------------------------------------------------------APPROACH 1 --------------------------------------------------------------------
/*
Time Complexity:
- O(n) because we process each operation once.

Space Complexity:
- O(n) for storing valid scores in the nums[] array.
*/

//--------------------------------------------------------- JAVA CODE --------------------------------------------------------------------
class Solution {
    public int calPoints(String[] op) {

        int n = op.length;
        int[] nums = new int[n]; // stores valid scores
        int sum = 0;
        int i = 0; // points to the next empty position in nums[]

        for (int j = 0; j < n; j++) {

            char c = op[j].charAt(0); // first character of the operation
            int k = 0;

            switch (c) {

                case '+':
                    // "+" means: add the last two valid scores
                    k = nums[i - 1] + nums[i - 2];
                    nums[i] = k;
                    i++; // move to next empty position
                    break;

                case 'C':
                    // "C" means: remove the last valid score
                    i--;            // go back one position (delete)
                    nums[i] = 0;    // not required but keeps array clean
                    break;

                case 'D':
                    // "D" means: double the previous valid score
                    k = nums[i - 1] * 2;
                    nums[i] = k;
                    i++;
                    break;

                default:
                    // Otherwise: the string is a number
                    k = Integer.parseInt(op[j]);
                    nums[i] = k;
                    i++;
                    break;
            }
        }

        // Calculate total sum of all valid scores
        for (int j = 0; j < i; j++) {
            sum += nums[j];
        }

        return sum;
    }
}

//--------------------------------------------------------- CPP CODE --------------------------------------------------------------------

class Solution {
public:
    int calPoints(vector<string>& op) {

        int n = op.size();
        vector<int> nums(n); // stores valid scores
        int i = 0;           // pointer to next empty position

        for (int j = 0; j < n; j++) {

            char c = op[j][0]; // first character of the operation
            int k = 0;

            switch (c) {

                case '+':
                    // "+" = sum of previous two scores
                    k = nums[i - 1] + nums[i - 2];
                    nums[i] = k;
                    i++;
                    break;

                case 'C':
                    // "C" = remove last valid score
                    i--;
                    nums[i] = 0;
                    break;

                case 'D':
                    // "D" = double previous valid score
                    k = nums[i - 1] * 2;
                    nums[i] = k;
                    i++;
                    break;

                default:
                    // Otherwise it's a number (string to int)
                    k = stoi(op[j]);
                    nums[i] = k;
                    i++;
                    break;
            }
        }

        // Sum all valid values
        int sum = 0;
        for (int j = 0; j < i; j++) {
            sum += nums[j];
        }

        return sum;
    }
};
