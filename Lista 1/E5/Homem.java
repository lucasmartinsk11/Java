public class Homem extends PessoaIMC
{
	public Homem (String nome, String dataNascimento, double peso, double altura ) 
	{
		super(nome,dataNascimento,peso,altura);
	}
	
	public String resultIMC()
	{
		String result = "";
		try
		{
			if (super.calculaIMC()<20.7)
			{
				result = "Abaixo do peso ideal";
			}
			else if (super.calculaIMC() >= 20.7 || super.calculaIMC() <= 26.4)
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