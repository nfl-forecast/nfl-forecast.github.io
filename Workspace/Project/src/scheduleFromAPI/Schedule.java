package scheduleFromAPI;

import java.util.List;

public class Schedule
{
	String lastUpdatedOn;
	List<Games> gameentry;
	
	public void setLastUpdatedOn(String str)
	{
		lastUpdatedOn = str;
	}
	public void setGameentry(List<Games> games)
	{
		gameentry = games;
	}
	public String toString()
	{
		return gameentry.toString();
	}
}
