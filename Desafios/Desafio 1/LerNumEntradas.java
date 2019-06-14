import java.util.Scanner;
public class LerNumEntradas
{
	public static int lernumentradas()
	{
		Scanner lendo = new Scanner(System.in);
		int Quantidade = 0;
		boolean TesteQuantidade;
		do
		{
			TesteQuantidade = true;
			try
			{
				System.out.print("Digite a quantidade a ser testada: ");
				String aux = lendo.nextLine();
				if(aux.matches("[0-9]*") != true)
				{
					TesteQuantidade = false;
				}
				else
				{
					Quantidade = Integer.parseInt(aux);
				}
				if (Quantidade < 0)
				{
					TesteQuantidade = false;
					System.out.println("Digite um numero positivo");
				}
			}
			catch(Exception e)
			{
				TesteQuantidade = false;
				System.out.println(e);
			}
		}while(TesteQuantidade != true);
		
		return Quantidade;
			
	}
}