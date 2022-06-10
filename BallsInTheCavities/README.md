# Balls In the Cavities

<b>PROBLEM SETTER:</b> <a href="https://github.com/aruto-code">Arushee Tomar</a>

<b>PROBLEM STATEMENT:</b><br>
A fair in going on in a village named Groenwijckc. Jacob saw a game and wished to play it. The rules of the game are simple.
There is a board on the wall with bars which make cavity to hold the ball. As shown in below figure, second bar can hold 1 ball in between 1st and 3rd bar.
Similarly 4th bar can hold 2 balls one over another in between 3rd and 5th bar.



For every ball thrown in the cavity Jacob gets 1 point and the ball will stay there in order to fill the cavity.
You are given an integer array where elements represent the bar. Determine the maximum points Jacob can score in the game.

<b>INPUT FORMAT:</b><br>
First line contains n, size of the array<br>
Second line contains n space separated integers representing elements of array

<b>OUTPUT FORMAT:</b><br>
Integer representing maximum points Jacob can score.

<b>SAMPLE INPUT:</b>
```
5
2 1 4 1 3
```

<b>SAMPLE OUTPUT:</b>
```
3
```
<br>

## Solution (In Java) 
``` java
package com.company;

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
        int [] bars = {3,1,4,0,4};
        System.out.println(MaximumSCore(bars));
    }
}
```
