import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MinhaListaOrdenavel
{

	private ArrayList <PessoaIMC> listapessoas;

	public MinhaListaOrdenavel()
	{
		listapessoas = new ArrayList <PessoaIMC>();

	}



	public ArrayList ordena(int criterio)
	{

		if(criterio == 1)
		{
			Collections.sort(this.listapessoas, nomeC);

		}
		else if (criterio == 2)
		{
			Collections.sort(this.listapessoas, nomeC);
			Collections.reverse(listapessoas);
		}
		else if (criterio == 3)
		{
			Collections.sort(this.listapessoas, pesoC);
			Collections.reverse(listapessoas);
		}
		else if (criterio == 4)
		{
			Collections.sort(this.listapessoas, pesoC);
		}
		else if (criterio == 5)
		{
			Collections.sort(this.listapessoas, alturaC);
			Collections.reverse(listapessoas);
		}
        else if (criterio == 6)
        {
            Collections.sort(this.listapessoas, alturaC);
        }
		else if (criterio == 7)
		{
			Collections.sort(this.listapessoas, imcC);
			Collections.reverse(listapessoas);
		}
		else if (criterio == 8)
		{
			Collections.sort(this.listapessoas, generoC);
		}
		else
		{
			System.out.println("Opcao invalida");
		}

		return listapessoas;
	}
	public void adicionar (PessoaIMC p)
	{
		listapessoas.add(p);
	}
	public String getPessoa(int i)
	{
		return listapessoas.get(i).toString();
	}
	public int getTamanhoLista()
	{
		return listapessoas.size();
	}

	private Comparator pesoC = new Comparator()
	{
		public int compare (Object p1, Object p2)
		{
			double pf1, pf2;
			pf2 = ((PessoaIMC) p2).getPeso();
			pf1 = ((PessoaIMC) p1).getPeso();
			return (int)Math.round (pf2 - pf1);
		}
	};

	private Comparator nomeC = new Comparator()
	{
		public int compare (Object p1, Object p2)
		{
			int result  = ((PessoaIMC) p1).getNome().compareToIgnoreCase(((PessoaIMC) p2).getNome());
			return result ;
		}
	};

	private Comparator alturaC = new Comparator()
	{
		public int compare (Object p1, Object p2)
		{
			double pf1, pf2;
			pf2 = 100*(((PessoaIMC) p2).getAltura());
			pf1 = 100*(((PessoaIMC) p1).getAltura());
			return (int)Math.round (pf2 - pf1);
		}
	};

	private Comparator imcC = new Comparator()
	{
		public int compare (Object p1, Object p2)
		{
			double pf1 = 0.0, pf2 = 0.0;
			try
			{
				pf2 = (((PessoaIMC) p2).calculaIMC());
				pf1 = (((PessoaIMC) p1).calculaIMC());
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
			return (int)Math.round (pf2 - pf1);
		}
	};

	private Comparator generoC = new Comparator()
	{
		public int compare (Object p1, Object p2)
		{
			double pf1, pf2;
			pf2 = 10*(((PessoaIMC) p2).retornaSexo());
			pf1 = 10*(((PessoaIMC) p1).retornaSexo());
			return (int)Math.round (pf2 - pf1);
		}
	};
}