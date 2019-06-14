import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Ex3
{
	public static void main (String args[])
	{
		
		try
		{	
			String s;
			boolean testeconversao = false;
			int qAngulo = 0;
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader ler = new BufferedReader(in);
			do
			{
				try
				{
						System.out.println("Digite a quantidade de Angulos: ");
						s = ler.readLine();
						qAngulo =  Integer.parseInt(s);
						if(qAngulo > 0){testeconversao = true;}
						else{System.out.println("Digite um inteiro maior que 0");}
				}
				catch(NumberFormatException e)
				{
					System.out.println("Voce nao digitou um numero inteiro");
				}
			}while(testeconversao == false);
			
			AnguloObj a[] = new AnguloObj[qAngulo];
			
			for(int i = 0; i < qAngulo; i++ )
			{
				do
				{
					try
					{
						System.out.println("Digite seu "+(i+1)+" angulo\n");
						a[i] = new AnguloObj(Double.parseDouble(ler.readLine()));
						testeconversao = true;
					}
					catch(NumberFormatException e)
					{
						System.out.println("Voce nao digitou um angulo\n");
						testeconversao = false;
					}
					
				}while(testeconversao == false);
			}
			System.out.println("Resultados===============================================\n	");
			for(int i = 0; i < qAngulo; i++)
			{
				System.out.println("Resultado "+(i+1)+" =======");
				System.out.println(a[i]);
			}
	
		}
		catch(NullPointerException e)
		{
			System.out.println("Programa encerrado a forca");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}