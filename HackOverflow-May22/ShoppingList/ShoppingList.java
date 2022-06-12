import java.util.HashMap;
import java.util.Scanner;

public class ShoppingList {

    public static int[] Shopping(int[] shoppingList, int money){
        int [] res = new int[2];
        int n = shoppingList.length;
        HashMap<Integer,Integer> h = new HashMap<>();
        for (int i = 0; i< n; i++){
            if (h.containsKey(money-shoppingList[i])){
                res[1] = i;
                res[0] = h.get(money-shoppingList[i]);
                break;
            }
            h.put(shoppingList[i],i);   // 7,0    8,1   2,2,
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] shoppingList = new int[n];
        for (int i = 0; i<n; i++){
            shoppingList[i] = sc.nextInt();
        }
        int money = sc.nextInt();
        int [] res = Shopping(shoppingList,money);
        for (int e : res){
            System.out.print(e+" ");
        }
    }
}
