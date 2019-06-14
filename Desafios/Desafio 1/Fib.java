import java.util.Scanner;
import java.util.ArrayList;

public class Fib
{
			Scanner lendo = new Scanner(System.in);
			ArrayList <FibonacciArray> f = new ArrayList<FibonacciArray>();
			int quantidade = 0;
			
			public Fib(int quantidade)
			{
				this.quantidade = quantidade;
			}
			
			public void fib()
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
								System.out.print("Digite o fib a ser calculado: ");
								aux = Integer.parseInt(lendo.nextLine());
								if(aux < 0 || aux > 60)
								{
									testedenegativo = false;
									System.out.println("Voce ditou um numero menor que 0 ou maior que 60");
								}
							}while(testedenegativo !=true);
						
							f.add(new FibonacciArray(aux));
						
						}
						catch(NumberFormatException e)
						{
							testecriacaoarray = false;
							System.out.println("Prfv digite um numero inteiro");
						}
					}while(testecriacaoarray != true);
				}
				
				for(int i = 0; i < quantidade; i++)
				{
					System.out.println(f.get(i));
				}
			}
}