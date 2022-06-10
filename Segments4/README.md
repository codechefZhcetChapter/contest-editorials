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

## Solution (In C++)

``` cpp
#include <bits/stdc++.h>
using namespace std;
typedef pair<int,int> pii;
typedef pair<int,pii> pip;
const int MAXN = 200005;
unordered_map <int,int> M;
vector <int> que[MAXN];
vector <pip> intervals;
int l[MAXN], r[MAXN], k[MAXN], x[MAXN], lo[MAXN], hi[MAXN], mid[MAXN], BIT[3*MAXN];
void BIT_upd(int pos, int val)
{
	while(pos < 3*MAXN)
	{
		BIT[pos]+=val;
		pos+=(pos & (-pos));
	}
}
int BIT_get(int pos)
{
	int ret = 0;
	while(pos > 0)
	{
		ret+=BIT[pos];
		pos-=(pos & (-pos));
	}
	return ret;
}
int main()
{
	int n;
	scanf("%d", &n);
	vector <int> nums;
	for (int i = 0; i < n; ++i)
	{
		scanf("%d %d", &l[i], &r[i]);
		nums.push_back(l[i]);
		nums.push_back(r[i]);
	}
	int q;
	scanf("%d", &q);
	for (int i = 0; i < q; ++i)
	{
		scanf("%d %d", &k[i], &x[i]);
		nums.push_back(x[i]);
	}
	sort(nums.begin(), nums.end());
	nums.resize(unique(nums.begin(), nums.end()) - nums.begin());
	for (int i = 0; i < nums.size(); ++i)
	{
		M[nums[i]] = i + 1;
	}
	for (int i = 0; i < n; ++i)
	{
		intervals.push_back(pip(r[i] + 1 - l[i], pii(M[l[i]],M[r[i]])));
	}
	sort(intervals.begin(), intervals.end());
	for (int i = 0; i < q; ++i)
	{
		lo[i] = 0;
		hi[i] = n;
		mid[i] = (lo[i] + hi[i])/2;
		que[mid[i]].push_back(i);
	}
	bool changed = true;
	while(changed)
	{
		changed = false;
		memset(BIT, 0, sizeof BIT);
		for (int i = 0; i < n; ++i)
		{
			int l = intervals[i].second.first, r = intervals[i].second.second;
			BIT_upd(l,1);
			BIT_upd(r+1,-1);
			while(!que[i].empty())
			{
				int qnum = que[i].back();
				que[i].pop_back();
				int pos = M[x[qnum]];
				if(BIT_get(pos) >= k[qnum])
					hi[qnum] = mid[qnum];
				else
					lo[qnum] = mid[qnum] + 1;
				if(lo[qnum] < hi[qnum])
				{
					changed = true;
					mid[qnum] = (lo[qnum] + hi[qnum])/2;
					que[mid[qnum]].push_back(qnum);
				}
			}
		}
	}
	for (int i = 0; i < q; ++i)
	{
		if(lo[i] >= n)
			printf("-1\n");
		else
			printf("%d\n", intervals[lo[i]].first);
	}
	return 0;
}
```
