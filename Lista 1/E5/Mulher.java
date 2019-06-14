public class Mulher extends PessoaIMC
{
	public Mulher (String nome, String dataNascimento, double peso, double altura ) 
	{
		super(nome,dataNascimento,peso,altura);
	}
	
	public String resultIMC()
	{
		String result = "";
		try
		{
			if (super.calculaIMC()<19.0)
			{
				result = "Abaixo do peso ideal";
			}
			else if (super.calculaIMC() >= 19.0 || super.calculaIMC() <= 25.8)
			{
				result = "Peso ideal";
			}
			else
			{
				result = "Acima do peso ideal";
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return result;
		
	}
	
	public String toString()
	{
		return super.toString() + "Resultado:" + resultIMC();
	}
	
}