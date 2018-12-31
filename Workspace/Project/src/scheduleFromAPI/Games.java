package scheduleFromAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Games
{
	String id;
	String date;
	String time;
	String location;
	public TeamSchedule awayTeam, homeTeam;
	public String week;
	String ScheduleStatus;
	
	
	public void setScheduleStatus(String str)
	{
		ScheduleStatus = str;
	}
	public void setWeek(String str)
	{
		week = str;
	}
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
	public String toString()
	{
		return awayTeam + " @ " + homeTeam;
	}
}
