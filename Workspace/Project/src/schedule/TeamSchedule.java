package schedule;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamSchedule
{
	@JsonProperty("ID")
	String ID;
	
	@JsonProperty("City")
	String City;
	
	@JsonProperty("Name")
	String Name;
	
	@JsonProperty("Abbreviation")
	String Abbreviation;
	
	
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
