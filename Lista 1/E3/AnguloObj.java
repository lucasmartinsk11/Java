/*
*@author Lucas Martins
*/

import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.tan;
import static java.lang.Math.toRadians;
import static java.lang.Math.round;

public class AnguloObj
{
	
	private double arcRad;
	private double recbAngulo;
	 
	public AnguloObj(double a)
	{
		recbAngulo = a;	
		arcRad = arredondar(toRadians(this.recbAngulo));
		
	}
	public String toString()
	{
		try
		{
			return "Arco: " + this.converteAngulo() + "\n" + "Seno: " + this.funcaoSeno() + "\n" + "Cosseno: " + this.funcaoCoseno() + "\n" + "Tangente: " + this.funcaoTangente() + "\n" + "Cotan: " + this.funcaoCotangente() + "\n";
		}
		catch(Infinity e)
		{
			return "Arco: " + this.converteAngulo() + "\n" + "Seno: " + this.funcaoSeno() + "\n" + "Cosseno: " + this.funcaoCoseno() + "\n" + "Tangente: " + this.funcaoTangente() + "\n" + "Cotan: " + "Infinito" + "\n";
		}
		
	}
	
	private static double arredondar (double a)
	{
		return Math.round(a*100.0)/100.0;
	}
	
	public double converteAngulo () 
	{
		return arredondar(toRadians(this.recbAngulo));
	}
	public double funcaoSeno () 
	{
		return arredondar(sin(arcRad));
	}
	public double funcaoCoseno () 
	{
		return arredondar(cos(arcRad));
	}
	public double funcaoTangente () 
	{
		return arredondar(tan(arcRad));
	}
	public double funcaoCotangente () throws Infinity
	{
		if(funcaoTangente() == 0)
		{
			throw new Infinity ("Tendendo ao infinito");
		}
		else
		{
			double b = 1/funcaoTangente();
			return arredondar(b);
		}
		
	}
}