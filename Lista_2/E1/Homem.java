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
			double resultIMC = this.calculaIMC();

			if (resultIMC <20.7)
 			{
				result = "Abaixo do peso ideal";
			}
			else if (resultIMC  >= 20.7 && resultIMC  <= 26.4)
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

	public int retornaSexo()
	{
		return 1;
	}
	
	public String toString()
	{
		return super.toString() + "Resultado:" + resultIMC();
	}
	
	
}