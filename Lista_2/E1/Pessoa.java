public class Pessoa
{
	protected String nome;
	protected String dataNascimento;
	
	public Pessoa(String nome, String dataNascimento)
	{
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	public String toString()
	{
		return "Nome: " + nome + "\n" + "Data de Nascimento: " + dataNascimento + "\n" ;
	}
	public String getNome ()
	{
		return nome;
	}
	public String getDataNascimento ()

	{
		return dataNascimento;
	}
	
}