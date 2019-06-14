public class Funcionario
{
	protected String Nome;
	protected String codEmpregado;
	protected float Salario;
	protected float salLiquido;
	
	public Funcionario (String Nome, String codEmpregado, float Salario)
	{
		this.Nome = Nome;
		this.codEmpregado = codEmpregado;
		this.Salario = Salario;
		this.salLiquido = Salario;
	}
	
	private static float arredondar (float a)
	{
		return Math.round(a*100.0f)/100.0f;
	}
	
	public String toString()
	{
		return "Nome: " + this.Nome +"\n"+"Codigo do Empregado: "+ this.codEmpregado +"\n"+"Salario - Base: "+this.Salario;
	}
	
	float calculaSalario (float desconto)
	{
		return salLiquido = arredondar(Salario - (Salario*desconto));
	}
	
	public String getNome ()
	{
		return Nome;
	}
	public String getcodEmpregado()
	{
		return codEmpregado;
	}
	public float getSalario ()
	{
		return Salario;
	}
	public float getsalLiquido ()
	{
		return salLiquido;
	}
	
}