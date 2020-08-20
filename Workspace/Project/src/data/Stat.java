package data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stat
{
	@JsonProperty("@category")
	private String category;
	@JsonProperty("@abbreviation")
	private String abbreviation;
	
	@JsonProperty("#text")
	private String text;
	
	private double a, b, c;
	public String toString()
	{
		return abbreviation + ": " + text + "\n";
	}
	
	public void setCategory(String str)
	{
		category = str;
	}
	public void setAbbreviation(String str)
	{
		abbreviation = str;
	}
	public void setText(String str)
	{
		text = str;
	}
	
	public void setCoefs(double one, double two, double three)
	{
		a = one;
		b = two;
		c = three;
	}
	
	public String getText()
	{
		return text;
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
