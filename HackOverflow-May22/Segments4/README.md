# Segments 4

<b>PROBLEM SETTER:</b> <a href="https://github.com/SumirVats2003">Sumir Vats</a>

<b>PROBLEM STATEMENT:</b><br>
You are given N segments [L,R], where L <= R. Now, you need to answer some queries based on these segments.

Overall, you need to answer Q queries. In each query you shall be given 2 integers K and X. You need to find the size of the K(th) smallest segment that contains point X.

If no K segments contain point X , print -1 instead as the answer to that query.

A segment [L,R] (L, R included) is said to contain a point X, if L<=X<=R. When we speak about the K(th) smallest segment, we refer to the one having the K(th) smallest size. We define the size of a segment to be the number of integral points it contains, i.e. R+1-L

<b>INPUT FORMAT: </b><br>
The first line contains a single integer N,

Each of the next N lines contains 2 space separated integers, where the 2 integers on the i(th) line denote the start and end points of the i(th) segment given to you.

The next line contains a single integer Q.

Each of the next Q lines contains 2 space separated integers K and X.

<b>OUTPUT FORMAT:</b><br>
Print the ansnwer to each query on a new line.
If multiple sizes are the same then print the minimum index

<b>CONSTRAINTS: </b><br>
```
1 <= N,Q <= 2*10^5
1 <= Li <= Ri <= 10^9, where 1 <= i <= N
1 <= K <= N
1 <= X <= 10^9
```

<b>SAMPLE INPUT:</b><br>
```
5
1 2
1 3
2 4
4 8
1 9
2
2 4
4 2
```
<b>SAMPLE OUTPUT:</b><br>
```
5
9
```
