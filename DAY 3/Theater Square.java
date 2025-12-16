static void solve() throws IOException {
        int l = ii(); 
        int b = ii(); 
        int a = ii();
        long ll = (l+a-1)/a; //taking the ceil number of tiles length wise 
        long bb = (b+a-1)/a; //simillarly breadth wise
        op(ll*bb);
    }
    //important thing was to keep in mind the type of the variable taken to avoid overflow.