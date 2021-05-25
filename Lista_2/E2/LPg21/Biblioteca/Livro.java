package LPg21.Biblioteca;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Livro implements Serializable
{
    private String codigoLivro;
    private String tituloLivro;
    private String categoria;
    private int quantidade;
    private int emprestados;
    private ArrayList<EmprestadosPara> Historico = new ArrayList<EmprestadosPara>();
    public Livro(String codigoLivro, String tituloLivro, String categoria, int quantidade, int emprestados)
    {
        this.codigoLivro = codigoLivro;
        this.tituloLivro = tituloLivro;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.emprestados = emprestados;
    }
    public Livro(String tituloLivro)
    {
        this.tituloLivro = tituloLivro;
    }

    public void empresta() throws CopiaNaoDisponivelEx
    {
        if(emprestados == quantidade) new CopiaNaoDisponivelEx("Copia nao disponivel");
        emprestados = emprestados + 1;

    }
    public void devolve() throws NenhumaCopiaEmprestadaEx
    {
        if(emprestados == 0) new NenhumaCopiaEmprestadaEx ("Nao ah nenhuma copia emprestada");
        emprestados = emprestados - 1;
    }

    public void addUsarioHist(GregorianCalendar dataEmprestimo,GregorianCalendar dataDevolucao,int codUsuario)
    {
        Historico.add(new EmprestadosPara(dataEmprestimo,dataDevolucao,codUsuario));
    }

    public String getCodLivro()
    {
        return codigoLivro;
    }

    public String getTitulo()
    {
        return tituloLivro;
    }

    public String toString ()
    {
        String historico = "";

        for(int i = 0; i <= Historico.size()-1; i++)
        {
            historico = historico + Historico.get(i);
        }
        return "Codigo do Livro: " + getCodLivro() + " - Titulo: " + getTitulo() +" - Categoria: "+ categoria+
                "\n"+"Quantidade Emprestado: " + emprestados +"\n"+"Quantidade: "+ quantidade +"\n"+ historico;
    }


}
