public class D1
{
	public static void main (String [] args)
	{
		try
		{
			Fib F = new Fib(LerNumEntradas.lernumentradas());
			F.fib();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}