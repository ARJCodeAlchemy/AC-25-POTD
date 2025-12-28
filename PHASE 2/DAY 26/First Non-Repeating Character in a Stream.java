//---------------------------------------------------------APPROACH 1 --------------------------------------------------------------------
/*
Time Complexity:
- O(n), where n is the length of the string.
- Each character is added and removed from the queue at most once.

Space Complexity:
- O(1), since at most 26 characters (lowercase English letters) are stored.

Short Explanation:
- We process the string character by character.
- A map is used to store frequency of each character.
- A queue is used to maintain the order of characters that appear only once.
- For each character, we remove repeating characters from the front of the queue.
- The front of the queue always represents the first non-repeating character.
*/

//--------------------------------------------------------- JAVA CODE --------------------------------------------------------------------

class Solution {
    public String firstNonRepeating(String s) {

        // queue to maintain order of non-repeating characters
        Queue<Character> queue = new LinkedList<>();

        // map to store frequency of each character
        Map<Character, Integer> map = new HashMap<>();

        // to build the final answer string
        StringBuilder sb = new StringBuilder();

        // process each character one by one
        for (char c : s.toCharArray()) {

            // if character appears for the first time, add it to queue
            if (!map.containsKey(c)) {
                queue.offer(c);
            }

            // update frequency of current character
            map.put(c, map.getOrDefault(c, 0) + 1);

            /*
             Remove characters from the front of the queue
             if they are no longer non-repeating
            */
            while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
                queue.poll();
            }

            // if no non-repeating character exists till now
            if (queue.isEmpty()) {
                sb.append('#');
            }
            // front of the queue is the first non-repeating character
            else {
                sb.append(queue.peek());
            }
        }

        return sb.toString();
    }
}

//--------------------------------------------------------- CPP CODE --------------------------------------------------------------------

class Solution {
public:
    string firstNonRepeating(string s) {

        // queue to maintain order of non-repeating characters
        queue<char> q;

        // map to store frequency of characters
        unordered_map<char, int> freq;

        string result = "";

        // process each character
        for (char c : s) {

            // if character appears first time, push into queue
            if (freq[c] == 0) {
                q.push(c);
            }

            // update frequency
            freq[c]++;

            /*
            Remove characters from front of queue
            if they are no longer non-repeating
            */
            while (!q.empty() && freq[q.front()] > 1) {
                q.pop();
            }

            // if queue becomes empty, no non-repeating character
            if (q.empty()) {
                result.push_back('#');
            }
            // front of queue is the answer
            else {
                result.push_back(q.front());
            }
        }

        return result;
    }
};

//--------------------------------------------------------- EXTRA INSIGHTS --------------------------------------------------------------------
🔹 Why Queue + Map Works Here

Map answers: how many times has a character appeared?

Queue answers: which character came first and is still valid?

Together they maintain order + frequency, which is the core requirement.

//<><><><><><><><><><><><><><><><><><><><><><>><><><><><><><><><><><><><><><><><><><><><><><><><><>

🔹 Pattern Recognition (Very Important)

This is a classic “stream processing” problem.

You’ll see the same idea in:

First non-repeating character in a stream

Sliding window problems

Real-time data processing questions

//<><><><><><><><><><><><><><><><><><><><><><>><><><><><><><><><><><><><><><><><><><><><><><><><><>

🔹 Common Mistake Students Make

Using only a map ❌
That loses order, which is crucial here.