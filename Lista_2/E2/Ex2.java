import LPg21.Biblioteca.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex2{
    static Scanner ler = new Scanner(System.in);

    public static void salvarArquivo(Biblioteca biblioteca)
    {
        //Menu salvar
         String criterio;
        boolean testacriterio;
        do
        {
            System.out.println("       1.Salvar Livro"+"\n"+"       2.Salvar Usuario"+"\n"+"       3.Voltar ao Menu Principal");
            criterio = ler.nextLine();
            testacriterio = true;
            if(criterio.equals("1"))
            {
                System.out.println("Digite o nome do arquivo de Livros");
                try
                {
                    biblioteca.salvaArquivo(biblioteca.getLivroHashtable(),ler.nextLine());
                } catch (FileNotFoundException e) {
                    System.out.println("Arquivo de livros não encontrado, prfv verifique o nome e realize a operacao novamnete");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else if(criterio.equals("2"))
            {
                System.out.println("Digite o nome do arquivo de Usuarios");
                try
                {
                    biblioteca.salvaArquivo(biblioteca.getUsuarioHashtable(),ler.nextLine());
                } catch (FileNotFoundException e) {
                    System.out.println("Arquivo de usuarios não encontrado, prfv verifique o nome e realize a operacao novamnete");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else if (criterio.equals("3"))
            {
                System.out.println("Voltando ao menu principal");
            }
            else {System.out.println("Opcao incorreta"); testacriterio = false;}

        }while(!testacriterio);
    }

    public static Livro cadLivro()
    {
        System.out.print("Digite o codigo do livro: ");
        String codigo = ler.nextLine();
        System.out.print("Digite o titulo do livro: ");
        String titulo = ler.nextLine();
        System.out.print("Digite o categoria do livro: ");
        String categoria = ler.nextLine();
        System.out.print("Digite a quantidade: ");
        int quantidade = 0;
        boolean testaquantidade;
        do {
            testaquantidade = true;
            try
            {
                quantidade = Integer.parseInt(ler.nextLine());
                if(quantidade  <= 0)
                {
                    System.out.println("Quanditade tem que ser maior que 0");
                    testaquantidade = false;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Você não digitou um numero inteiro, prfv digite novamente");
                testaquantidade = false;
            }
        }while(!testaquantidade);
        Livro livro = new Livro(codigo,titulo,categoria,quantidade,0);

        return livro;
    }

    public static Usuario cadUsuario ()
    {
        boolean testatudo;
        String nome;
        GregorianCalendar dataNascimento = new GregorianCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        do
        {
            testatudo = true;
            System.out.print("Digite o nome do usuario: ");
            nome = ler.nextLine();
            if(nome.matches("[^A-z]*") && !nome.equals(null))
            {
                System.out.println("Digite um nome valido");
                testatudo = false;
            }

        }while(!testatudo);
        do
        {
            testatudo = true;
            System.out.print("Digite a data de nascimento do usuario: ");
            try
            {
                String data = ler.nextLine();
                dataNascimento.setTime(formatter.parse(data));
            } catch (ParseException e) {
                System.out.println("Voce digitou uma data invalida, prfv digite novamente");
                testatudo = false;
            }

        }while (!testatudo);

        String endereco = "";
        do
        {
            testatudo = true;
            System.out.println("Digite o endereco do usuario: ");
            endereco = ler.nextLine();
            if (endereco.equals(null))
            {
                System.out.println("Endereco nao pode ser vazio");
                testatudo = false;
            }
        }while(!testatudo);

        int codUsuario = 0;
        do
        {
            testatudo = true;
            try
            {
                System.out.println("Digite o codigo do usuario: ");
                codUsuario = Integer.parseInt(ler.nextLine());
            }
            catch (NumberFormatException e)
            {
                testatudo = false;
            }
        }while(!testatudo);

        Usuario usuario = new Usuario(nome,dataNascimento,endereco,codUsuario);
        return usuario;
    }

    public static  void empresta(Biblioteca biblioteca)
    {
        System.out.print("Digite o codigo do livro a ser empretsado: ");
        String codLivro = ler.nextLine();
        boolean teste;
        int codUsuario = 0;
        Livro livro = null;
        Usuario usuario = null;
        do
        {
            teste = true;
            try
            {
                System.out.print("Digite o codigo do usuario: ");
                codUsuario = Integer.parseInt(ler.nextLine());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Prfv digite apenas numeros");
                teste = false;
            }
        }while (!teste);

        try {
            usuario = biblioteca.getUsuario(codUsuario);
        } catch (UsuarioNaoCadastradoEx usuarioNaoCadastradoEx) {
            usuarioNaoCadastradoEx.printStackTrace();
        }

        try {
            livro = biblioteca.getLivro(codLivro);
        } catch (LivroNaoCadastradoEx livroNaoCadastradoEx) {
            livroNaoCadastradoEx.printStackTrace();
        }

        try
        {
            biblioteca.emprestaLivro(codLivro,codUsuario);
            System.out.println(livro);
            System.out.println(usuario);
        } catch (CopiaNaoDisponivelEx copiaNaoDisponivelEx) {
            System.out.println("Nao existe copia disponivel para emprestimo");
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    public static void devolve(Biblioteca biblioteca)
    {
        System.out.print("Digite o codigo do livro a ser devolvido: ");
        String codLivro = ler.nextLine();
        boolean teste;
        int codUsuario = 0;
        do
        {
            teste = true;
            try
            {
                System.out.print("Digite o codigo do usuario: ");
                codUsuario = Integer.parseInt(ler.nextLine());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Prfv digite apenas numeros");
                teste = false;
            }
        }while (!teste);

        try {
            System.out.println(biblioteca.getUsuario(codUsuario));
        } catch (UsuarioNaoCadastradoEx usuarioNaoCadastradoEx) {
            usuarioNaoCadastradoEx.printStackTrace();
        }

        try {
            System.out.println(biblioteca.getLivro(codLivro));
        } catch (LivroNaoCadastradoEx livroNaoCadastradoEx) {
            livroNaoCadastradoEx.printStackTrace();
        }

        try
        {
            biblioteca.devolverLivro(codUsuario,codLivro);
        } catch (NenhumaCopiaEmprestadaEx nenhumaCopiaEmprestadaEx) {
            System.out.println("Nao ha nenhuma copia do livro a ser devolvida prfv verificar o estoque");
        }

    }

    public static void relatorio(Biblioteca biblioteca)
    {
        String criterio;
        boolean testacriterio2;
        do
        {
            System.out.println("      1.Imprimir lista de livros"+"\n"
                    +"      2.Imprimir lista de usuarios"+"\n"
                    +"      3.Imprimir detalhe de livro"+"\n"
                    +"      4.Imprimir detalhe usuario"+"\n"
                    +"      5.Sair");
            criterio = ler.nextLine();
            testacriterio2 = true;
            if(criterio.equals("1"))
            {
                System.out.println(biblioteca.imprimeLivro()+"\n");
            }
            else if (criterio.equals("2"))
            {
                System.out.println(biblioteca.imprimeUsuario()+"\n");
            }
            else if (criterio.equals("3"))
            {
                testacriterio2 = imprimeDetalheLivro(biblioteca);
                System.out.println("");
            }
            else if (criterio.equals("4"))
            {
                testacriterio2 = imprimeDetalheUsuario(biblioteca);
                System.out.println("");

            }
            else if(criterio.equals("5"))
            {
                testacriterio2 = true;
                System.out.println("Voltando ao menu principal");
            }
            else
            {
                testacriterio2 = false;
            }
        }while (!testacriterio2);
    }


    private static boolean imprimeDetalheUsuario(Biblioteca biblioteca)
    {
        boolean testaentrada;
        int codUsuario = 0;
        System.out.print("Digite o codigo do usuario: ");
        do
        {
            testaentrada = true;
            try
            {
                codUsuario = Integer.parseInt(ler.nextLine());
            }
            catch (Exception e)
            {
                System.out.println("Codigo invalido");
                testaentrada = false;
            }

        }while(!testaentrada);

        try {
            System.out.println(biblioteca.getUsuario(codUsuario));

        } catch (UsuarioNaoCadastradoEx usuarioNaoCadastradoEx) {
            System.out.println("Usuario não cadastrado");
            return false;
        }
        return true;
    }

    private static boolean imprimeDetalheLivro(Biblioteca biblioteca)
    {
        System.out.print("Digite codigo do livro: ");
        String codLivro = ler.nextLine();

        try {
            System.out.println(biblioteca.getLivro(codLivro));
        } catch (LivroNaoCadastradoEx livroNaoCadastradoEx) {
            return false;
        }
        return true;
    }

    private static void lerarquivo (Biblioteca biblioteca)
    {
        System.out.println("       1.Ler arquivo de usuarios"+"\n" +
                ""+"       2.Ler arquivo de livros");
        String criterio = ler.nextLine();
        if(criterio.equals("1"))
        {
            System.out.print("Digite o nome do arquivo a ser lido: ");
            try
            {
                biblioteca.leArquivoUsuarios(ler.nextLine());
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado, prfv verificar e realizar novamente a opercao");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }
        else if (criterio.equals("2"))
        {
            System.out.print("Digite o nome do arquivo a ser lido: ");
            try
            {
                biblioteca.leArquivoLivros(ler.nextLine());
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado, prfv verificar e realizar novamente a opercao");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{System.out.println("Opcao invalida voltando ao menu principal");}

    }

    public static void main(String [] args )
    {
        System.out.println("1.Criar nova biblioteca"+"\n"+"2.Abrir uma já existente"+"\n"+"3. Sair");
        Scanner ler = new Scanner(System.in);
        Biblioteca biblioteca = null;
        String criterio;

        boolean testacriterio;
        boolean testasaida = true;
        //Menu de inicializacao
        do
        {
            testacriterio = true;
            criterio = ler.nextLine();
            if(criterio.equals("1"))
            {
               biblioteca = new Biblioteca();
            }
            else if (criterio.equals("2"))
            {
                System.out.print("Prfv digite o nome do arquivo de usuarios: ");
                String arqUsuario = ler.nextLine();
                System.out.print("Prfv digite o nome do arquivo de livros: ");
                String arqLivro = ler.nextLine();
                try
                {
                    biblioteca = new Biblioteca(arqUsuario,arqLivro);
                } catch (FileNotFoundException e) {
                    System.out.println("Um ou mais arquivos nao encontrados");
                    testacriterio = false;
                } catch (IOException e) {
                    e.printStackTrace();
                    testasaida = false;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    testasaida = false;
                }


                System.out.println("\n");
            }
            else if (criterio.equals("3"))
            {
                System.out.println("Saindo do Sistema");
                testasaida = false;
            }
            else
            {
                System.out.println("Você digitou uma opcao invalida, prfv digite uma opcao valida");
                testacriterio = false;
            }

        }while (!testacriterio);

        //Menu Principal
        while(testasaida)
        {
            System.out.println("1.Cadastrar Livros" +"\n"
                    +"2.Cadastrar Usuarios" +"\n"
                    +"3.Salvar Arquivos"+"\n"
                    +"4.Emprestimos"+"\n"
                    +"5.Devolucao"+"\n"
                    +"6.Relatorios"+"\n"
                    +"7.Ler arquivo"+"\n"
                    +"8.Sair"+"\n");
            criterio = ler.nextLine();
            do {
                testacriterio = true;
                if (criterio.equals("1"))
                {
                    biblioteca.cadastroLivro(cadLivro());
                }
                else if (criterio.equals("2"))
                {
                    biblioteca.cadastroUsuario(cadUsuario());
                }
                else if (criterio.equals("3"))
                {
                    salvarArquivo(biblioteca);
                }
                else if (criterio.equals("4"))
                {
                    empresta(biblioteca);
                }
                else if (criterio.equals("5"))
                {
                    devolve(biblioteca);
                }
                else if (criterio.equals("6"))
                {
                    relatorio(biblioteca);
                }
                else if (criterio.equals("7"))
                {
                    lerarquivo(biblioteca);
                }
                else if (criterio.equals("8"))
                {
                    System.out.println("Saindo do Sistema");
                    testasaida = false;
                }
                else
                {
                    System.out.println("Opcao invalida");
                }
            }while(!testacriterio);
        }
    }
}
