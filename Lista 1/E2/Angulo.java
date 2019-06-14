import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.tan;
import static java.lang.Math.toRadians;
import static java.lang.Math.round;

public class Angulo
{
		
	public static double arredondar (double a)
	{
		return Math.round(a*100.0)/100.0;
	}
	
	public static double converteAngulo (double a) 
	{
		double b = toRadians(a);
		return arredondar(b);
	}
	public static double funcaoSeno (double a) 
	{
		return arredondar(sin(toRadians(a)));
	}
	public static double funcaoCoseno (double a) 
	{
		return arredondar(cos(toRadians(a)));
	}
	public static double funcaoTangente (double a) 
	{
		return arredondar(tan(toRadians(a)));
	}
	public static double funcaoCotangente (double a) throws Infinity
	{
		if(tan(a) == 0)
		{
			throw new Infinity ("Infinito");
		}
		return arredondar(1/(tan(toRadians(a))));
	}
}