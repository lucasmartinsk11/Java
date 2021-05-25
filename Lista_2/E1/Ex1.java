import java.util.Scanner;

public class Ex1
{
	public static void lista(MinhaListaOrdenavel minhalistaordenavel) {
		minhalistaordenavel.adicionar(new Homem("Lucas", "11/09/1997", 87.7, 1.85));
		minhalistaordenavel.adicionar(new Mulher("Nathalia", "18/12/1997", 67.7, 1.65));
		minhalistaordenavel.adicionar(new Homem("Renato", "04/09/1999", 75.7, 1.78));
		minhalistaordenavel.adicionar(new Mulher("Carol", "10/01/1998", 80.7, 1.75));
		minhalistaordenavel.adicionar(new Homem("Breno", "25/01/1997", 90.7, 1.75));
		minhalistaordenavel.adicionar(new Homem("Douglas", "10/10/1998", 85.7, 1.86));
		minhalistaordenavel.adicionar(new Mulher("Thais", "10/01/1999", 82.7, 1.78));
		minhalistaordenavel.adicionar(new Homem("João Gabriel", "10/03/1999", 83.7, 1.79));
		minhalistaordenavel.adicionar(new Mulher("Bia", "15/06/1999", 55.7, 1.70));
		minhalistaordenavel.adicionar(new Homem("Paulo", "10/03/1999", 120.7, 1.80));
	}

	public static void main(String [] args)
	{
		MinhaListaOrdenavel minhalistaordenavel = new MinhaListaOrdenavel();
		lista(minhalistaordenavel);
		
		try
		{
			Scanner lendo = new Scanner(System.in);
			boolean testacriterios;
			do
			{
				testacriterios = false;
				System.out.println("1.Imprimir Lista"+"\n"+"2.Sair");
				System.out.print("Digite sua opcao: ");
				try {
					int criterio = Integer.parseInt(lendo.nextLine());
					if (criterio == 1) {

						System.out.println("				Escolha seu modo de ordenacao" + "\n" + "1.Alfabetica (A-Z)" + "\n" + "2.Alfabetica (Z-A)" + "\n" + "3.Menor Peso" + "\n" + "4.Maior Peso" + "\n" + "5.Menor Altura" + "\n"+"6.Maior Altura"+"\n" + "7.Menor IMC" + "\n" + "8.Homem / Mulher");
						boolean testacriterios2;
						do {
							testacriterios2 = true;
							try {
								System.out.print("Digite sua opcao: ");
								int criterio2 = Integer.parseInt(lendo.nextLine());
								minhalistaordenavel.ordena(criterio2);
								if (criterio >= 1 && criterio <= 7) {
									for (int i = 0; i < minhalistaordenavel.getTamanhoLista(); i++)
										System.out.println(minhalistaordenavel.getPessoa(i));
								}
								testacriterios = false;
							} catch (NumberFormatException e) {
								System.out.println("Prfv digite uma opcao valida");
								testacriterios2 = false;
							}
						} while (!testacriterios2);

					} else if (criterio == 2) {
						testacriterios = true;
						System.out.println("Voce esta saindo");
					} else {
						System.out.println("Opcao invalida");
						testacriterios = false;
					}
				}
				catch(NumberFormatException e)
				{
					System.out.println("Digite uma opcao valida");
					testacriterios = false;
				}
			}while(!testacriterios);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}