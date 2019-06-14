
public class FuncionarioContratado extends Funcionario 
{
	private int numDepedentes;
	private float salFamilia;
	private static float valorPorDep = 9.58f;
	private static float aliquotaIR = 0.15f;

	public FuncionarioContratado (String Nome, String codFuncionario, float Salario, int numDepedentes)
	{
		super(Nome,codFuncionario,Salario);
		this.numDepedentes = numDepedentes;
	}
	public void calculaSalario(int numDepedentes)
	{
		salFamilia = valorPorDep * numDepedentes;
		Salario = Salario + salFamilia;
		salLiquido = super.calculaSalario (aliquotaIR);
	}
	
	public void calculaSalario()
	{
		salLiquido = super.calculaSalario(aliquotaIR);
	}
	
	
	public String toString ()
	{
		return super.toString() +"\n"+ "Salario-Liquido: " + salLiquido;
	}
	
	public int getNumDepedentes()
	{
		return numDepedentes;
	}
	public float getsalFamilia()
	{
		return salFamilia;
	}
	public float getvalorPorDep()
	{
		return valorPorDep;
	}
	public float getaliquoataIR()
	{
		return aliquotaIR;
	}
}