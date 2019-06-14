import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Ex2
{
	public static void main (String args[])
	{
		
		try
		{	
			String s;
			Angulo a;
			if(args.length >= 1)
			{
				if (args.length > 1){System.out.println("Apenas sera utilizado o primeiro argumento\n");}
				try
				{
					double b = Double.parseDouble(args[0]);
					System.out.println("Arco:  "+Angulo.converteAngulo(b)+" rad");
					System.out.println("Seno:  "+Angulo.funcaoSeno(b));
					System.out.println("Coseno:  "+Angulo.funcaoCoseno(b));
					System.out.println("Tangente:  "+Angulo.funcaoTangente(b));
					System.out.println("Cotangente:  "+Angulo.funcaoCotangente(b)+"\n\n");
				}
				catch(Infinity e)
				{
					System.out.print("Contangente: Infinita\n\n");
				}
				catch(NumberFormatException e)
				{
					System.out.println("Isto nao e uma numero " + args[0]);
				}
				
				InputStreamReader in = new InputStreamReader(System.in);
				BufferedReader ler = new BufferedReader(in);
				System.out.println("Digite o angulo: ");
				s = ler.readLine();
				double b;
				if(s.equals(""))
				{
					System.out.print("Programa Encerrado");
				}
				else 
				{					
					do
					{
						try
						{
							b = Double.parseDouble(s);
							System.out.println("Arco:  "+Angulo.converteAngulo(b)+" rad");
							System.out.println("Seno:  "+Angulo.funcaoSeno(b));
							System.out.println("Coseno:  "+Angulo.funcaoCoseno(b));
							System.out.println("Tangente:  "+Angulo.funcaoTangente(b));
							System.out.println("Cotangente:  "+Angulo.funcaoCotangente(b)+"\n");
						}
						catch(Infinity e)
						{
							System.out.print("Contangente: Infinita\n\n");
						}
						catch(NumberFormatException e)
						{
							System.out.println("Caracter Invalido" + s +"\n");
						}
						System.out.println("Digite o angulo ou aperte enter para encerrar");
						s = ler.readLine();
					}while(s.isEmpty()!= true);
					System.out.println("Programa Encerrado");
				}	
			}
			else 
			{
				InputStreamReader in = new InputStreamReader(System.in);
				BufferedReader ler = new BufferedReader(in);
				System.out.println("Digite o angulo: ");
				s = ler.readLine();
				double b;
				if(s.equals(""))
				{
					System.out.print("Programa Encerrado");
				}
				else 
				{ 
					do
					{
						try
						{
							b = Double.parseDouble(s);
							System.out.println("Arco:  "+Angulo.converteAngulo(b)+" rad");
							System.out.println("Seno:  "+Angulo.funcaoSeno(b));
							System.out.println("Coseno:  "+Angulo.funcaoCoseno(b));
							System.out.println("Tangente:  "+Angulo.funcaoTangente(b));
							System.out.println("Cotangente:  "+Angulo.funcaoCotangente(b)+"\n");
						}
						catch(Infinity e)
						{
							System.out.print("Contangente: Infinita\n\n");
						}
						catch(NumberFormatException e)
						{
							System.out.println("Voce nao digitou um numero\n");
						}
						System.out.println("Digite o angulo: ");
						s = ler.readLine();
					}while(s.isEmpty()!= true);
					System.out.println("Programa Encerrado");	
				}
				
				
			}
		}
		catch(NullPointerException e)
		{
			System.out.println ("Encerramento forcado do programa");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}