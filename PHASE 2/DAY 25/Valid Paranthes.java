//---------------------------------------------------------APPROACH 1 --------------------------------------------------------------------

/*
Time Complexity: O(n)
- Each character of the string is processed once.

Space Complexity: O(n)
- In the worst case, all opening brackets are stored in the stack.

Short Explanation:
- Use a stack to keep track of opening brackets.
- Push opening brackets onto the stack.
- For every closing bracket, check if it matches the top of the stack.
- If mismatch or stack is empty, the string is invalid.
- At the end, the stack must be empty for the string to be valid.
*/


//--------------------------------------------------------- JAVA CODE --------------------------------------------------------------------

class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // push opening brackets
            if (ch == '{' || ch == '[' || ch == '(') {
                st.push(ch);
            } 
            else {
                // closing bracket without opening
                if (st.isEmpty()) return false;

                // check if it matches the top
                if (ch == '}' && st.peek() == '{') st.pop();
                else if (ch == ']' && st.peek() == '[') st.pop();
                else if (ch == ')' && st.peek() == '(') st.pop();
                else return false;
            }
        }

        // valid only if no unmatched brackets remain
        return st.isEmpty();
    }
}


//--------------------------------------------------------- CPP CODE --------------------------------------------------------------------

class Solution {
public:
    bool isValid(string s) {

        stack<char> st;

        for (char ch : s) {

            // push opening brackets
            if (ch == '{' || ch == '[' || ch == '(') {
                st.push(ch);
            }
            else {
                // closing bracket without opening
                if (st.empty()) return false;

                // check matching pair
                if (ch == '}' && st.top() == '{') st.pop();
                else if (ch == ']' && st.top() == '[') st.pop();
                else if (ch == ')' && st.top() == '(') st.pop();
                else return false;
            }
        }

        // stack should be empty at the end
        return st.empty();
    }
};

//--------------------------------------------------------- EXTRA INSIGHTS --------------------------------------------------------------------

🔹 Pattern to Remember

This problem is a stack + matching pattern.

Whenever you see:

- balanced

- valid

- matching pairs

👉 Try a stack first.

//-----------------<><><><><><><><><><><><><><><><><><><><><><>><><><><><><><><><><><><><>-----------------

🔹 Interview Tip

In interviews:

Explain stack approach

Mention why counters won’t work for {[()]} type problems

Say: “Order matters, so stack is needed”

This shows depth of understanding.

//-----------------<><><><><><><><><><><><><><><><><><><><><><>><><><><><><><><><><><><><>-----------------

🔹 Small Improvement Thought

Instead of multiple if-else, you can also use:

Map<closing, opening>

Cleaner and more extensible