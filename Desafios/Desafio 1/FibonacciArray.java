public class FibonacciArray
{
	private int N;
	private long [] vector;
	public FibonacciArray(int N)
	{
		this.N = N;	
	}
	
	private long fib()
	{
		if(N == 0)
		{
			return 0;
		}
		if (N == 1)
		{
			return 1;
		}
		
		vector = new long[N+1];
		vector[0] = 0;
		vector[1] = 1;
		for (int i = 2; i <= N; i++)
		{
			vector[i] = vector[i-2] + vector [i-1];
		}	
		
		return vector[N];
	}
	public int getNum()
	{
		return N;
	}
	public long getFib()
	{
		return fib();
	}
	
	public String toString()
	{
		return "Fib("+N+") = " + fib();
	}
		
	
}