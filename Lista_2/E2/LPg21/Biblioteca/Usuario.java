package LPg21.Biblioteca;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
public class Usuario extends Pessoa implements Serializable
{
    private String endereco;
    private int codigoUsuario;
    private ArrayList <Emprestimo> Historico = new ArrayList<Emprestimo>();

    public Usuario(String nome, GregorianCalendar dataNascimento, String endereco, int codigoUsuario) {
        super(nome, dataNascimento);
        this.endereco = endereco;
        this.codigoUsuario = codigoUsuario;
    }

    public void addLivroHist(String dataEmprestimo,String dataDevolucao,String codigoLIvro)
    {
        Historico.add(new Emprestimo(dataEmprestimo,dataDevolucao,codigoLIvro));
    }

    public int getCodUsuario()
    {
        return codigoUsuario;
    }

    public GregorianCalendar getDataEmprestimo(String codLivro)
    {
        for (int i = 0; i < Historico.size(); i++)
        {
            if(Historico.get(i).getCodigoLIvro().equals(codLivro))
            {
                return Historico.get(i).getDataEmprestimo();
            }
        }
        return null;
    }
    public GregorianCalendar getDataDevolucao(String codLivro)
    {
        for (int i = 0; i < Historico.size(); i++)
        {
            if(Historico.get(i).getCodigoLIvro().equals(codLivro))
            {
                return Historico.get(i).getDataDevolucao();
            }
        }
        return null;
    }

    public String toString ()
    {
        String historico = "";
        for (int i = 0; i <= Historico.size()-1; i++)
        {
            historico = historico + Historico.get(i);
        }
        return super.toString() + "Endereco: " + endereco + "\n" + "Codigo Usuario: " + codigoUsuario +"\n"+ historico+"\n";
    }

}
