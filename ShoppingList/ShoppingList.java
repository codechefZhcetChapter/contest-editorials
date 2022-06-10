/* PROBLEM NAME: Shopping List

Problem Setter: Arushee Tomar

PROBLEM STATEMENT: You are given an integer array whose elements are the prices of items in your shopping list. You have a specific amount of money given.
Return indices of the two items such that they add up to the given money.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

INPUT FORMAT:
First line contains n, size of the integer array.
Second lines containes n space separated integers, representing the array items
Third line contains an integer which is money.

OUTPUT FORMAT:
Array having indices of two shopping items

SAMPLE INPUT:

4
5 7 2 1
8

SAMPLE OUTPUT:
1 3

Explanation: Because 7 + 1 == 8, we return [1, 3].

Constraint : 
2 <= N <= 10^5
-10^9 <= N[i] <= 10^9
-10^9 <= Money <= 10^9

*/


package com.company;

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
