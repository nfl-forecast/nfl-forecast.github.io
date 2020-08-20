package data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamData
{
	@JsonProperty("ID")
	private String ID;
	
	@JsonProperty("City")
	private String City;
	
	@JsonProperty("Name")
	private String Name;
	
	@JsonProperty("Abbreviation")
	private String Abbreviation;
	
	
	public void setID(String str)
	{
		ID = str;
	}
	public void setName(String str)
	{
		Name = str;
	}
	public void setCity(String str)
	{
		City = str;
	}
	public void setAbbreviation(String str)
	{
		Abbreviation = str;
	}
	public String toString()
	{
		return City + " " +  Name;
	}
}
