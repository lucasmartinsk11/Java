public class PerfectNumber 
{
	int Numb, Soma;
	
	public PerfectNumber(int Numb)
	{
		this.Numb = Numb;
	}
	
	public String perfectnumber()
	{	
		for(int i = 1; i < Numb; i++)
		{
			if(Numb%i == 0)
			{
				Soma = Soma+i;
			}
		}
		if (Soma == Numb)
		{
			return Soma + " Eh perfeito";
		}
		else
		{
			return Numb + " Nao eh perfeito";
		}
	}
}