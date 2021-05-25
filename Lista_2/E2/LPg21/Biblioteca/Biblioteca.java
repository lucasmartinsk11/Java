package LPg21.Biblioteca;
import javax.imageio.IIOException;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Biblioteca implements Serializable
{
    private Hashtable <Integer,Usuario> cadastroUsuarioHashtable;
    private Hashtable <String,Livro> cadastroLivroHashtable;

    public Biblioteca()
    {
        cadastroUsuarioHashtable = new Hashtable<Integer,Usuario>();
        cadastroLivroHashtable = new Hashtable<String,Livro>();
    }
    public Biblioteca(String nomeArqUsuario, String nomeArqLivro) throws FileNotFoundException,IOException,ClassNotFoundException
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArqUsuario));
        cadastroUsuarioHashtable = new Hashtable<Integer, Usuario> ((Hashtable)in.readObject());
        in.close();
        ObjectInputStream inn = new ObjectInputStream(new FileInputStream(nomeArqLivro));
        cadastroLivroHashtable = (Hashtable)inn.readObject();
        in.close();

    }

    public void cadastroUsuario(Usuario usuario)
    {
        cadastroUsuarioHashtable.put(usuario.getCodUsuario(),usuario);
    }
    public void cadastroLivro(Livro livro)
    {
        cadastroLivroHashtable.put(livro.getCodLivro(),livro);
    }

    public void salvaArquivo(Hashtable salva, String arquivo) throws FileNotFoundException,IOException
    {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
        out.writeObject(salva);
        out.close();
    }

    public void leArquivoUsuarios(String arquivo) throws FileNotFoundException,IOException,ClassNotFoundException
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo));
        cadastroUsuarioHashtable = (Hashtable <Integer,Usuario>)in.readObject();
    }
    public void leArquivoLivros(String arquivo) throws FileNotFoundException,IOException,ClassNotFoundException
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo));
        cadastroLivroHashtable = (Hashtable<String, Livro>) in.readObject();
    }

    public void emprestaLivro (String codLivro,int codUsuario) throws CopiaNaoDisponivelEx,ParseException
    {
        cadastroLivroHashtable.get(codLivro).empresta();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String aux = sdf.format(new Date( System.currentTimeMillis()));
        System.out.print("Digite a data de devolucao");
        Scanner ler = new Scanner(System.in);
        Date dataDevolucao = sdf.parse(ler.nextLine());
        String _dataDevolucao = sdf.format(dataDevolucao);
        cadastroUsuarioHashtable.get(codUsuario).addLivroHist(aux,_dataDevolucao,codLivro);
    }

    public void devolverLivro (int codUsuario, String codLivro) throws NenhumaCopiaEmprestadaEx
    {
        Usuario usuario = cadastroUsuarioHashtable.get(codUsuario);
        Livro livro = cadastroLivroHashtable.get(codLivro);
        GregorianCalendar gd = new GregorianCalendar();
        gd.setTime(new Date (System.currentTimeMillis()));
        if (usuario.getDataDevolucao(codLivro).before(gd))
        {
            System.out.println("Aplicar Multa!");
        }
        livro.devolve();
        livro.addUsarioHist(usuario.getDataEmprestimo(livro.getCodLivro()),usuario.getDataDevolucao(codLivro),usuario.getCodUsuario());

    }

    public String imprimeLivro()
    {
        ArrayList <Livro> tmp = new ArrayList<Livro>(cadastroLivroHashtable.values());
        Collections.sort(tmp,tituloC);

        String titulo = "";
        for (int i = 0 ; i <= tmp.size()-1; i++)
        {
            titulo = titulo + "\n" +tmp.get(i).getCodLivro()+" - "+tmp.get(i).getTitulo();
        }

        return titulo;
    }

    private Comparator tituloC = new Comparator()
    {
        public int compare (Object p1, Object p2)
        {
            int result  = ((Livro) p1).getTitulo().compareToIgnoreCase(((Livro) p2).getTitulo());
            return result ;
        }
    };

    public String imprimeUsuario()
    {
        ArrayList <Usuario> tmp = new ArrayList<Usuario>(cadastroUsuarioHashtable.values());
        Collections.sort(tmp,nomeC);

        String nome = "";
        for (int i = 0 ; i <= tmp.size()-1; i++)
        {
            nome = nome + "\n" + tmp.get(i).getCodUsuario()+" - "+tmp.get(i).getNome();
        }

        return nome;
    }
    private Comparator nomeC = new Comparator()
    {
        public int compare (Object p1, Object p2)
        {
            int result  = ((Usuario) p1).getNome().compareToIgnoreCase(((Usuario) p2).getNome());
            return result ;
        }
    };

    public Livro getLivro(String cod) throws LivroNaoCadastradoEx
    {
        Livro l = cadastroLivroHashtable.get(cod);
        if (l == null) throw new LivroNaoCadastradoEx ("Livro nao cadastrado");
        return l;
    }

    public Usuario getUsuario(int cod) throws UsuarioNaoCadastradoEx
    {
        Usuario u = cadastroUsuarioHashtable.get(cod);
        if (u == null) throw new UsuarioNaoCadastradoEx ("Usuario nao cadastrado");
        return u;
    }

    public Hashtable getUsuarioHashtable()
    {
        return cadastroUsuarioHashtable;
    }

    public Hashtable getLivroHashtable()
    {
        return cadastroLivroHashtable;
    }


}
