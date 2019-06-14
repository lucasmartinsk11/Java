public class DigitsCount
{
	String A;
	String B;	
	int [] X = new int [10];
	
	public DigitsCount (String A, String B)
	{
		this.A = A;
		this.B = B;
	}
	
	public int[] digitscount ()
	{
		try
		{
			for(int i = Integer.parseInt(A); i <= Integer.parseInt(B); i++)
			{
				String C = Integer.toString(i);
				for (int j = 0; j < C.length(); j++)
				{	
					String Y = C.substring(j,j+1);
					int Z = Integer.parseInt(Y);
					X[Z] = X[Z]+1;
				}
			
			
			}
			
		}
		catch (Exception e)
		{
			System.out.println("entrada invalida");
		}
		
		return X;
		
	} 
}

