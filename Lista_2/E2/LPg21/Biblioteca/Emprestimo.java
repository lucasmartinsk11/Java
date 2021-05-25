package LPg21.Biblioteca;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Emprestimo implements Serializable
{
    private GregorianCalendar dataEmprestimo;
    private GregorianCalendar dataDevolucao;
    private String codigoLIvro;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public Emprestimo(String dataEmprestimo, String dataDevolucao, String codigoLIvro) {
        this.dataEmprestimo = new GregorianCalendar();
        this.dataDevolucao = new GregorianCalendar();
        try
        {
            this.dataEmprestimo.setTime(formatter.parse(dataEmprestimo));
            this.dataDevolucao.setTime(formatter.parse(dataDevolucao));
            this.codigoLIvro = codigoLIvro;
        }
        catch (ParseException e)
        {

        }

    }

    public GregorianCalendar getDataEmprestimo()
    {
        return dataEmprestimo;
    }

    public GregorianCalendar getDataDevolucao() {
        return dataDevolucao;
    }

    public String getCodigoLIvro()
    {
        return codigoLIvro;
    }

    public String toString()
    {
        return "Codigo do Livro: " + codigoLIvro +"\n"+"Data de Emprestimo: "+formatter.format(getDataEmprestimo().getTime())+"\n"+"Data de Devolucao: " +formatter.format(getDataDevolucao().getTime())
                +"\n";
    }

}
