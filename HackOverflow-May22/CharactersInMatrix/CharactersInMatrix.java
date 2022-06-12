import java.util.Scanner;

public class Medium1CharactersInMatrix {

    public static Character[][] SpiralMatrix(int n){
        Character [][] arr = new Character[n][n];
        int count = 0;
        int top = 0, right = n - 1, bottom = n -1, left = 0;
        while (top <= bottom && left <= right){
            for (int i = left; i <= right; i++){

                arr[top][i] = (char)(count%26+97);
                count++;

            }
            top++;
            for (int i = top; i <= bottom; i++){

                arr[i][right] = (char)(count%26+97);
                count++;
            }
            right--;
            if (top<=bottom){
                for (int i = right; i >= left; i--){

                    arr[bottom][i] =(char)(count%26+97);
                    count++;
                }
                bottom--;
            }
            if (left<=right){
                for (int i = bottom; i >= top; i--){

                    arr[i][left] = (char)(count%26+97);
                    count++;
                }
                left++;
            }
        }

        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Character [][] res = SpiralMatrix(n);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
