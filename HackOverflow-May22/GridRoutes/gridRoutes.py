def factorial(a):
	prd = 1
	for i in range(2, a+1):
		prd = prd*i;
	return prd;

def cut_fact(a):
	prd=1
	for i in range(int((a/2)+1), a+1):
		prd = prd*i
	return prd

if __name__ == "__main__":
	t = int(input())
	while t>0:
		x = int(input())
		fact2 = cut_fact(2*x)
		fact = factorial(x)
		print(int(fact2/fact))
		t = t-1
