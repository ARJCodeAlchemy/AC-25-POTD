//---------------------------------------------------------APPROACH 1 --------------------------------------------------------------------
/*
Time Complexity: O(n)
Space Complexity: O(n)
*/

//--------------------------------------------------------- JAVA CODE --------------------------------------------------------------------
class Solution {
    public String reverse(String s) {

        Stack<Character> st = new Stack<>();

        // push all characters onto the stack
        for (char c : s.toCharArray()) {
            st.push(c);
        }

        StringBuilder sb = new StringBuilder();

        // pop characters to get them in reverse order
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    }
}

//--------------------------------------------------------- CPP CODE --------------------------------------------------------------------
class Solution {
public:
    string reverse(string s) {

        stack<char> st;

        // push all characters onto the stack
        for (char c : s) {
            st.push(c);
        }

        string result;

        // pop characters to get them in reverse order
        while (!st.empty()) {
            result.push_back(st.top());
            st.pop();
        }

        return result;
    }
};

//-----------------------------------------------------------------------------------------------------------------------------

/*
Our approach is perfect for learning stacks:
LIFO nature naturally reverses a string
Very intuitive and readable
But in real interviews, they might ask:
“Can you do it without extra space?”
This opens the door to two-pointer or in-place reversal.
*/