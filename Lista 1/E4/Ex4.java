import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection; 
import java.util.ArrayList;
public class Ex4 
{
	int Quantidade;
	public Ex4 (int a)
	{
		Quantidade = a;
	}
	
	public void calculaSalarios()
	{
		FuncionarioContratado f[] = new FuncionarioContratado[Quantidade];
		boolean testerecb = false;
		System.out.println("---- Cadastro de Funcionarios ----");
		for (int i = 0; i < Quantidade; i++)
		{
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader ler = new BufferedReader(in);
			try
			{
				String Nome;
				System.out.println("Nome:");
				do
				{
					Nome = ler.readLine();
					if(Nome.length() == 0 && !Nome.equals(" ")){System.out.println("Seu funcionario precisa de um nome");}
				}while(Nome.length() == 0 && !Nome.equals(" "));
				
				String codFuncionario;
				System.out.println("Codigo do funcionario:");
				do
				{
					codFuncionario = ler.readLine();
					if(codFuncionario.length() == 0 && !codFuncionario.equals("  ")){System.out.println("Seu funcionario precisa de um codigo");}
				}while(codFuncionario.length() == 0 && !codFuncionario.equals("  "));
				
			
				float Salario =  0.0f;
				do
				{
					try
					{

						System.out.println("Salario:"); 
						Salario = Float.parseFloat(ler.readLine());
						testerecb = true;						
					}
					catch(NumberFormatException e)
					{
						System.out.println("Voce nao digitou o salario\n");
					}
				}while(testerecb == false);
				
				testerecb = false;
				int numDependentes = 0;
				do
				{
					try
					{

						System.out.println("Numero de dependentes:"); 
						numDependentes = Integer.parseInt(ler.readLine());
						testerecb = true;						
					}
					catch(NumberFormatException e)
					{
						System.out.println("O numero de depedendes precisa ser um inteiro\n");
					}
					catch(NullPointerException e)
					{
						System.out.println("Programa encerrado a forca");
					}
				}while(testerecb == false);
			
			
				f[i] = new FuncionarioContratado(Nome,codFuncionario,Salario,numDependentes);
				if(numDependentes > 0)
				{
					f[i].calculaSalario(numDependentes);
				}
				else
				{
					f[i].calculaSalario();
				}
			
				System.out.println("\n");
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
		System.out.println("---- Folha Salarial ----");
		for (int i = 0; i < Quantidade; i++)
		{
			System.out.println(f[i]+"\n----");
		}
		
	}
	
	
	

	
	public static void main (String args[])
	{
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader ler = new BufferedReader(in);
		boolean teste = false;
		int Quant = 0;
		try
		{
			do
			{
				try
				{

					System.out.println("Digite a Quandidade de dados a serem lidos");
					Quant = Integer.parseInt(ler.readLine());
					teste = true;						
				}
				catch(NumberFormatException e)
				{
					System.out.println("Voce nao digitou um numero inteiro\n");
				}
				catch(NullPointerException e)
				{
					System.out.println("Programa encerrado a forca");
				}
			}while(teste == false);
			
			System.out.println("\n");
			Ex4 a = new Ex4(Quant);
			a.calculaSalarios();
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