//----------------------------- Approach : 1 ----------------------------------
/*
Time Complexity:
- O(n^2) because we use two nested loops comparing each pair.
Space Complexity:
- O(1) since we use only constant extra space.
*/

//------------------------------------------ JAVA -----------------------------

class Solution {
    public int numIdenticalPairs(int[] nums) {
        // Variable to store the total count of good pairs
        int count = 0;

        // Length of the array
        int n = nums.length;

        // Outer loop: pick each element one by one
        for(int i = 0; i < n; i++) {

            // Inner loop: compare nums[i] with all elements to its right
            for(int j = i + 1; j < n; j++) {

                // If both elements are equal, it's a good pair
                if(nums[i] == nums[j])
                    count++;
            }
        }

        // Return the total number of good pairs found
        return count;
    }
}

//----------------------------------- CPP --------------------------------


class Solution {
    public int numIdenticalPairs(int[] nums) {
        // Variable to store the total count of good pairs
        int count = 0;

        // Length of the array
        int n = nums.length;

        // Outer loop: pick each element one by one
        for(int i = 0; i < n; i++) {

            // Inner loop: compare nums[i] with all elements to its right
            for(int j = i + 1; j < n; j++) {

                // If both elements are equal, it's a good pair
                if(nums[i] == nums[j])
                    count++;
            }
        }

        // Return the total number of good pairs found
        return count;
    }
}

//-----------------------------------------  Approach 2: --------------------------------
/*
Time Complexity:
- O(n), because we traverse the array once and all HashMap operations are O(1) on average.

Space Complexity:
- O(k), where k is the number of distinct integers in nums, for storing frequencies.
*/


//------------------------------------ JAVA ----------------------------------------------

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0; // stores total number of good pairs
        int n = nums.length;

        // HashMap to store frequency of each number encountered so far
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            // If this number has appeared before,
            // each previous appearance forms a good pair with the current index.
            if (map.containsKey(nums[i])) 
                count += map.get(nums[i]);  // add how many times this number has appeared

            // Increase the count of nums[i] in the map
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return count;
    }
}


//----------------------------------------------- CPP ------------------------------
class Solution {
public:
    int numIdenticalPairs(vector<int>& nums) {
        int count = 0; // total good pairs

        // unordered_map acts like HashMap in Java
        unordered_map<int, int> freq;

        for (int num : nums) {

            // If num appeared before, all previous occurrences
            // form good pairs with this occurrence
            if (freq.count(num))
                count += freq[num];

            // Increase frequency of current number
            freq[num]++;
        }

        return count;
    }
};

