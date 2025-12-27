// ----------------- SOLVE HERE -----------------
    static void solve() throws IOException {
        int n = ii();
        int x = 0;
 
        for(int i = 0; i < n; i++){
            String s = ss(); 
            //order doesn't matter, it's simple addition or subtraction
            if(s.indexOf('-')!= -1){  //if - present subtract 1
                x--;
            }
            else{ //else add 1
                x++;
            }
        }
        op(x);
    }