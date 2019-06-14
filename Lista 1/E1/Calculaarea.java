
import static java.lang.Math.PI;

public class Calculaarea
{
	private static float a;
	private static float b;
	private static float c;
	
	private static float arredondar (float a)
    {
        return Math.round(a*100.00)/100.0f;
    }
	
	private static float calcula (float raio) throws NotCircle
	{
		a = raio;
		if(a == 0)
		{
			throw new NotCircle("Nao e um circulo");
		}
        a = (float) (PI*a*a);
        return arredondar(a);
	}

	private static float calcula (float altura, float largura) throws NotRectangle
	{
		a = altura;
		b = largura;
		if (altura == 0 || largura == 0)
		{
			throw new NotRectangle ("Nao e um retangulo");
		}
		a =  a*b;
		return arredondar(a);
	}

	private static float calcula (float lado1, float lado2, float lado3) throws NotTriangle
	{
		a = lado1;
		b = lado2;
		c = lado3;
		
		if((a+b > c) && (c > Math.abs(a - b)) || (a+c > b) && (b > Math.abs(a - c)) || (b+c > a) && (a > Math.abs(b-c)))
		{
			float s = (a+b+c)/2;
			float area = (float) Math.sqrt((s*(s-a)*(s-b)*(s-c)));
		
			if(a == b && b == c){System.out.println("Equilatero");}
			else if(a == b || a == c || b == c){System.out.println("Isoiceles");}
			else {System.out.println("Escaleno");}		
			return arredondar(area);
		}
		else 
		{
			throw new NotTriangle ("Nao e um triangulo");
		}
		
	}
	
	public Calculaarea (float arg1)
	{
		try{System.out.println("A area do circulo e: " + calcula(arg1));}
		catch(NotCircle e){System.out.println(e.getMessage());}
		
	}
	public Calculaarea (float arg1, float arg2)
	{
		try{System.out.println("A area do retangulo e: " + calcula(arg1,arg2));}
		catch(NotRectangle e){System.out.println(e.getMessage());}
	}
	public Calculaarea (float arg1, float arg2, float arg3)
	{
		try
		{
			System.out.println("A area do triangulo e: " + calcula(arg1,arg2,arg3));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
