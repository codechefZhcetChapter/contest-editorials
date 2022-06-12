# Shopping List

<b>PROBLEM SETTER:</b> <a href="https://github.com/aruto-code">Arushee Tomar</a>

<b>PROBLEM STATEMENT:</b><br>
You are given an integer array whose elements are the prices of items in your shopping list. You have a specific amount of money given.
Return indices of the two items such that they add up to the given money.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

<b>INPUT FORMAT:</b><br>
First line contains n, size of the integer array.<br>
Second lines containes n space separated integers, representing the array items<br>
Third line contains an integer which is money.

<b>OUTPUT FORMAT:</b><br>
Array having indices of two shopping items

<b>SAMPLE INPUT:</b>
```
4
5 7 2 1
8
```
<b>SAMPLE OUTPUT:</b>
```
1 3
```

<b>Explanation:</b><br>
Because 7 + 1 == 8, we return [1, 3].

<b>Constraints:</b>
```
2 <= N <= 10^5
-10^9 <= N[i] <= 10^9
-10^9 <= Money <= 10^9
```