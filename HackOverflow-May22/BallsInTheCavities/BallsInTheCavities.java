public class BallsInTheCavities {

    public static int MaximumSCore(int [] arr){
        int res = 0;
        int [] lmax = new int[arr.length];
        int [] rmax = new int[arr.length];
        lmax[0] = arr[0];
        for (int i = 1; i < arr.length; i++){
            lmax[i] = Math.max(lmax[i-1], arr[i]);
        }
        rmax[arr.length-1] = arr[arr.length-1];
        for (int i = arr.length-2; i>= 0; i--){
            rmax[i] = Math.max(rmax[i+1], arr[i]);
        }
        for (int i = 0; i < arr.length; i++){
            res = res + (Math.min(lmax[i], rmax[i]) - arr[i]);
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] bars = new int[n];
        for (int i = 0; i < n; i++){
            bars[i] = sc.nextInt();
        }
        System.out.println(MaximumSCore(bars));
    }
}
