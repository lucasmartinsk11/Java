public abstract class PessoaIMC extends Pessoa
{
	protected double peso;
	protected double altura;
	
	public PessoaIMC(String nome, String dataNascimento, double peso, double altura)
	{
		super(nome,dataNascimento);
		this.peso = peso;
		this.altura = altura;
	}
	
	public double getPeso()
	{
		return this.peso;
	}
	public double getAltura()
	{
		return this.altura;
	}
	
	public double calculaIMC() throws Infinity
	{
		if(altura == 0)
		{
			throw new Infinity("Nao e possivel altura 0 ");
		}
		double result = (peso/(altura*altura));
		return result;
	}
	
	abstract public String resultIMC();

	abstract public int retornaSexo();
	
	public String toString()
	{
		return super.toString() + "Peso: " + peso + "Kg \n" + "Altura: " + altura + "m\n";
	}
	
	
}