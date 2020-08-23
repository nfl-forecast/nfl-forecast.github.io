package dataFromHTML;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stat
{
	
	public String abbreviation;
	
	
	public String value;
	
	private double a, b, c;
	public String toString()
	{
		return abbreviation + ": " + value + "\n";
	}
	public void setAbbreviation(String str)
	{
		abbreviation = str;
	}
	public void setValue(String str)
	{
		value = str;
	}
	
	public void setCoefs(double one, double two, double three)
	{
		a = one;
		b = two;
		c = three;
	}
	
	public String getValue()
	{
		return value;
	}
	
	public double getA()
	{
		return a;
	}
	
	public double getB()
	{
		return b;
	}
	public double getC()
	{
		return c;
	}
}
