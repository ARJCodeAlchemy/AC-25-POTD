//---------------------------------------------------------APPROACH 1 --------------------------------------------------------------------

/*
Time Complexity:
- O(n), where n is the size of the array.
- Each element is pushed and popped from the stack at most once.

Space Complexity:
- O(n), for the stack and the answer list.

Short Explanation:
- We traverse the array from right to left.
- A stack is used to keep elements in decreasing order.
- For each element, we remove all smaller or equal elements from the stack.
- The top of the stack (if any) is the next greater element.
- If the stack is empty, the next greater element does not exist.
*/



// Try yourself then Scroll down for the code :)






























// A little more
























//--------------------------------------------------------- JAVA CODE --------------------------------------------------------------------

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {

        Stack<Integer> st = new Stack<>();        // stack to store possible next greater elements
        ArrayList<Integer> list = new ArrayList<>(); // stores result in reverse order

        // traverse array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {

            // remove all elements smaller than or equal to current element
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }

            // if stack becomes empty, no greater element exists
            if (st.isEmpty()) {
                list.add(-1);
            }
            // top of stack is the next greater element
            else {
                list.add(st.peek());
            }

            // push current element for future comparisons
            st.push(arr[i]);
        }

        // reverse because we filled result from right to left
        Collections.reverse(list);

        return list;
    }
}


//--------------------------------------------------------- CPP CODE --------------------------------------------------------------------

class Solution {
public:
    vector<int> nextLargerElement(vector<int>& arr) {

        stack<int> st;              // stack to keep possible next greater elements
        vector<int> result;         // result will be built in reverse order

        // traverse from right to left
        for (int i = arr.size() - 1; i >= 0; i--) {

            // remove all elements smaller than or equal to current element
            while (!st.empty() && arr[i] >= st.top()) {
                st.pop();
            }

            // if stack is empty, no next greater element
            if (st.empty()) {
                result.push_back(-1);
            }
            // top of stack is the next greater element
            else {
                result.push_back(st.top());
            }

            // push current element into stack
            st.push(arr[i]);
        }

        // reverse to match original order
        reverse(result.begin(), result.end());

        return result;
    }
};


//--------------------------------------------------------- EXTRA INSIGHTS --------------------------------------------------------------------

🔹 This is a Monotonic Stack problem

The stack is maintained such that:

Elements are always in strictly decreasing order (from top to bottom).

This property allows us to efficiently find the next greater element.

//<><><><><><><><><><><><><><><><><><><><><><>><><><><><><><><><><><><><><><><><><><><><><><><><><>

🔹 Why traverse from right to left?

Because:

We want the next greater element.

Right side elements must already be processed and ready in the stack.

//<><><><><><><><><><><><><><><><><><><><><><>><><><><><><><><><><><><><><><><><><><><><><><><><><>

🔹 Pattern Recognition (Very Important)

This exact pattern appears in:

Next Greater Element

Next Smaller Element

Stock Span

Daily Temperatures

Histogram problems

Once you master this, 5 - 6 problems unlock instantly.

//<><><><><><><><><><><><><><><><><><><><><><>><><><><><><><><><><><><><><><><><><><><><><><><><><>

🔹 Common Mistake

Using two nested loops → O(n²) ❌
Stack-based approach reduces it to O(n) ✅