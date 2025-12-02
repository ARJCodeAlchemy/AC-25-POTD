/*
    Just providing the idea for the solution.
    To refer the complete solution check submissions of :- ninjahathori001
    ii() - custom function for input
    op() - custom function for output.
*/

    // ----------------- Main -----------------
    public static void main(String[] args) throws IOException {
        // int t = in.nextInt();
        // while (t-- > 0) {
            solve();
        // }
        out.flush();
    }

    // ----------------- SOLVE HERE -----------------
    static void solve() throws IOException {
        int k = ii(); //k dollars for first banana
        int n = ii(); //has to buy w bananas
        int w = ii(); //has n dollars
        int sum = 0; //total money for w bananas
        for(int i = 1; i <= w;i++){
            sum += (k*i); //adding the cost of each banana
        }
        if(sum <= n){
            op(0); //if total cost for w bananas is less than his balance
        }
        else{ //else extra needed.
            op(sum-n);
        }

    }
