import java.util.Scanner;
import java.util.ArrayList;
public class Perfect 
{
	ArrayList <PerfectNumber> perfect = new ArrayList <PerfectNumber>();
	Scanner lendo = new Scanner(System.in);
	int quantidade;
			
	public Perfect(int quantidade)
	{
		this.quantidade = quantidade;
	}
	
	public void perfect()
	{
		boolean testecriacaoarray;
			for(int i = 0; i < quantidade; i++)
			{
				do
				{
					testecriacaoarray = true;
					try
					{	
						int aux = 0;
						boolean testedenegativo;
						do
						{
							testedenegativo = true;
							System.out.print("Digite o numero a ser verificado: ");
							aux = Integer.parseInt(lendo.nextLine());
							if(aux  <1 || aux > 108)
							{
								testedenegativo = false;
								System.out.println("Voce ditou um numero menor que 1 ou maior que 108");
							}
						}while(testedenegativo !=true);
						perfect.add(new PerfectNumber(aux));
						
					}
					catch(NumberFormatException e)
					{
						testecriacaoarray = false;
						System.out.println("Prfv digite um numero inteiro");
					}
				}while(testecriacaoarray != true);
			}
			
			for(int index = 0; index < quantidade; index++)
			{
				System.out.println(perfect.get(index).perfectnumber());
			}
	}
			
			
}