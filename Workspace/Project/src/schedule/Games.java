package schedule;

public class Games
{
	String id;
	String date;
	String time;
	String location;
	TeamSchedule awayTeam, homeTeam;
	
	public void setId(String str)
	{
		id = str;
	}
	public void setDate(String str)
	{
		date = str;
	}
	public void setTime(String str)
	{
		time = str;
	}
	public void setLocation(String str)
	{
		location = str;
	}
	public void setHomeTeam(TeamSchedule str)
	{
		homeTeam = str;
	}
	public void setAwayTeam(TeamSchedule str)
	{
		awayTeam = str;
	}
}
