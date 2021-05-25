package LPg21.Biblioteca;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class EmprestadosPara implements Serializable
{
    private GregorianCalendar dataEmprestimo;
    private GregorianCalendar dataDevolucao;
    private int codUsuario;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public EmprestadosPara(GregorianCalendar dataEmprestimo, GregorianCalendar dataDevolucao, int codUsuario) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.codUsuario = codUsuario;

    }

    public String toString()
    {
        return "Emprestado para: "+codUsuario+"Data de Emprestimo: " + formatter.format(dataEmprestimo.getTime()) + "- Data de Devolucao: " + formatter.format(dataDevolucao.getTime());
    }
}
