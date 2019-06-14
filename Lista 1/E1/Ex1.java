import java.lang.Character;

public class Ex1
{
	public static void main (String args [])
	{
		boolean cont = false;
		float[] vet = new float[args.length];
		try
		{
			if(args.length < 1 || args.length > 3)
			{
				if(args.length < 1)
				{
					System.out.println("Argumentos insuficientes");
				}
				else
				{
					System.out.println("Argumentos excessivos");
				}
				
			}
			else
			{
				for(int i = 0; i < args.length; i++)
				{
					try
					{
						vet[i] = Float.parseFloat(args[i]);
					}
					catch(NumberFormatException e)
					{
						System.out.println("Isso nao e um numero " + args[i] + " posicao " + (i+1));
						cont = true;
					}
				}
				if(cont != true)
				{
					if (args.length == 1){Calculaarea calc =  new Calculaarea(vet[0]); }
					else if (args.length == 2){Calculaarea calc =  new Calculaarea(vet[0],vet[1]);}
					else{Calculaarea calc =  new Calculaarea(vet[0],vet[1],vet[2]);}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}