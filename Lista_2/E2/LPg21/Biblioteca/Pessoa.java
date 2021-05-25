package LPg21.Biblioteca;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Pessoa implements Serializable
{
    private String nome;
    private GregorianCalendar dataNascimento;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public Pessoa(String nome, GregorianCalendar dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome()
    {
        return nome;
    }

    public String getDataNascimento()
    {
        return formatter.format(dataNascimento.getTime());
    }

    public String toString ()
    {
        return "Nome: "+getNome()+"\n"+"Data de Nascimento: "+getDataNascimento()+"\n";
    }
}
