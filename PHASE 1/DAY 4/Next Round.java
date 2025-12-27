import java.util.*;
public class codef {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
 
        int[] ar =  new int[n];
        for(int i=0; i<n;i++){
            ar[i]= sc.nextInt();
        }
        int t = ar[k-1],c=0;
        for(int i=0;i<n;i++){
            if(t!=0){
              if(ar[i]>=t)
              c++;
            }
            else if(ar[i]>t) c++;
        }
        System.out.println(c);
        sc.close();
    
    }
    
}