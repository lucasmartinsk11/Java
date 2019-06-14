import java.util.ArrayList;

public class Palindrome
{
	private String S;
	private String aux = "";
	private String aux2 = "";
	char[] string; 
	public Palindrome (String S)
	{
		this.S = S.toUpperCase();
	}
	
	public String palindrome()
	{	
		if(S.matches("[A-Z]*") != true)
		{
			return "entrada invalida";
		}
		
		boolean teste = false;
		for (int i = this.S.length()-1;i >= 1 ; i--)
		{
			for(int j = 0; j < i; j++)
			{
				if(this.S.charAt(i) == this.S.charAt(j))
				{
					if(verifica(i,j) == true)
					{
						if(aux.length() > aux2.length())
						{
							aux2 = aux;
							teste = true;
						}
					}
				}
			}
		}
		if(teste == false){return "sem resultados";}
		return aux2;
	}
	
	private boolean verifica (int i,int j)
	{
		int x = i;
		int y = j;
		
		while (i >= j)
		{
			if (this.S.charAt(i) != this.S.charAt(j))
			{
				return false;
			}
			i--;
			j++;
		}
		aux = S.substring(y,x+1);
		return true;
	}
}