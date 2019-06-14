public class D2
{
	public static void main (String [] args)
	{
		try
		{
			Perfect p = new Perfect(LerNumEntradas.lernumentradas());
			p.perfect();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}