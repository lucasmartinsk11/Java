import java.util.Scanner;
import java.util.ArrayList;

public class D5 
{
	public static void main (String [] args )
	{
		try
		{
			int Quantidade = LerNumEntradas.lernumentradas();
			Scanner lendo = new Scanner(System.in);
			ArrayList <DigitsCount> D = new ArrayList <DigitsCount>();
			for (int i = 0; i < Quantidade; i++)
			{
				D.add(new DigitsCount(lendo.next(),lendo.next()));
			}
			for(int i = 0; i < Quantidade; i++)
			{
				int [] X = D.get(i).digitscount();
				for(int j = 0; j < 10; j++)
				{
					System.out.print(X[j]+" ");
				}
				System.out.println("");
			}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		
	}
}