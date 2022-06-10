# Characters In Matrix

<b>PROBLEM SETTER:</b> <a href="https://github.com/aruto-code">Arushee Tomar</a>

<b>PROBLEM STATEMENT:</b><br>
Given a positive integer n, generate an n x n character matrix filled with characters from a to z in spiral order.
If the matrix size i.e n * n is greater than 26 i.e number of alphabets available repeat characters from a again.

<b>INPUT FORMAT:</b><br>
First line contains integer n which is dimension of matrix.

<b>OUTPUT FORMAT:</b><br>
Character matrix having alphabets in spiral order.
```
 ->-> -> -> ->
|  a   b   c  |
|  h   i   d  |
|  g   f   e  |
<-<-<-<-<-<-<-
```

<b>SAMPLE INPUT:</b>
```
3
```

<b>SAMPLE OUTPUT:</b>
```
a b c 
h i d 
g f e
```
<br>

## Solution (In Java)

``` java
package com.company;

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
```
