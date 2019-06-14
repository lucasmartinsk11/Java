import java.util.Scanner;
import java.util.ArrayList;

public class D4
{
	public static void main (String [] args)
	{
		try
		{
			int Quantidade = LerNumEntradas.lernumentradas();
			Scanner lendo = new Scanner(System.in);
			ArrayList <Palindrome> p = new ArrayList <Palindrome>();
			
			for (int i = 0; i < Quantidade; i++)
			{
				p.add(new Palindrome(lendo.nextLine()));
			}
			for (int i = 0; i < Quantidade; i++)
			{
				System.out.println(p.get(i).palindrome());
			}
			

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}