/*
    Just providing the idea for the solution.
    To refer the complete solution check submissions of :- ninjahathori001
    ii() - custom function for input
    op() - custom function for output.
*/

    // ----------------- Main -----------------
    public static void main(String[] args) throws IOException {
        int t = in.nextInt();
        while (t-- > 0) {
            solve();
        }
        out.flush();
    }

    // ----------------- SOLVE HERE -----------------
    static void solve() throws IOException {
        int n = ii();
        if(n%2 == 1){
            op(0);
            return;
        }
        int ch = n/2; //finding number of chickens

        //if we know number of chicken then valid combinations will include
        //reducing 2 chicken and adding one cow.
        /* eg: n = 8 
            ch - 4 cow - 0
            removing two chicken
            ch - 2 cow - 1
            removing two chicken
            ch - 0 cow - 2
            therefore possible combinations depend on either number of chicken or cows.

            eg: n = 10
            ch - 5 cow - 0
            rem 2
            ch - 3 cow - 1
            rem 2
            ch - 1 cow - 2
            Only possible combinations, so taking the floor value of 
            (Number of chicken / 2) + 1;
        */
        op(ch/2 + 1);

    }