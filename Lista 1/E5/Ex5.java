import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex5
{
	public static void main(String [] args)
	{
		
		try
		{
			
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader ler = new BufferedReader(in);
			int quantidade = 0;
			
			//Perguta a quantidade de pessoas
			boolean teste = true;
			do
			{
				teste = true;
				try
				{
					System.out.println("Digite a quantidade de pessoas: ");
					quantidade = Integer.parseInt(ler.readLine());
				}
				catch(NumberFormatException e)
				{
					System.out.println("Valor incorreto, prfv digite um numero inteiro \n");
					teste = false;
				}
			}while (teste != true);
			
			
			//Cria Array de pessoas
			ArrayList <Pessoa> P = new ArrayList <Pessoa>();
			
			//Pergunta a informacao das pessoas
			for (int i = 0; i < quantidade; i++ )
			{	
				String nome = "";
				String Sexo = "";
				String dataNascimento = "";
				double peso = 0.0;
				double altura = 0.0;
				//Nao deixa a pessoa digitar nome vazio
				do
				{
					System.out.println("Digite o nome da pessoa: ");
					nome = ler.readLine();
					
				}while(nome.equals(""));
				//Nao deixa a pessoa digitar sexo invalido
				do
				{
					System.out.println("Digite o sexo de " + nome + " caso Homem digite h caso Mulher digite m:");
					Sexo = ler.readLine();
					if(!Sexo.equals("h")&&!Sexo.equals("m")){System.out.println("Sexo invalido");}
					
				}while(!Sexo.equals("h")&&!Sexo.equals("m"));
				//Nao deixa a pessoa digitar data de nascimento vazia
				do
				{
					System.out.println("Digite a data de nascimento de " + nome + ": ");
					dataNascimento = ler.readLine();
					
				}while(dataNascimento.equals(""));
				//Recla se o usuario deixar vazio ou digitar algo que nao seja um numero
				boolean teste1 = true;
				do
				{
					teste1 = true;
					try
					{
						System.out.println("Digite o peso de " + nome + ": ");
						peso = Double.parseDouble(ler.readLine());
					}
					catch(NumberFormatException e)
					{
						teste1 = false;
					}
					if (peso == 0){System.out.println("Prfv digite uma peso valiada"); teste1 = false;}
					
				}while(teste1 != true);
				//Recla se o usuario deixar vazio ou digitar algo que nao seja um numero
				boolean teste2 = true;
				do
				{
					teste2 = true;
					try
					{
						System.out.println("Digite a altura de " + nome + ": ");
						altura = Double.parseDouble(ler.readLine());
					}
					catch(NumberFormatException e)
					{
						teste2 = false;
					}
					if (altura == 0){System.out.println("Prfv digite uma altura valiada"); teste2 = false;}
					
				}while(teste2 != true);
				
				//testa para ver se e homem ou mulher
				if (Sexo.equals("h"))
				{
					P.add(new Homem (nome,dataNascimento,peso,altura));
				}
				else
				{
					P.add(new Mulher(nome,dataNascimento,peso,altura));
				}
			}
			
			//imprime as pessoas
			for (int i = 0; i < quantidade; i++)
			{
				System.out.println(P.get(i));
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}