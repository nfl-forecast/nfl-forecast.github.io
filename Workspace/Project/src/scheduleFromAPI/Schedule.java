package scheduleFromAPI;

import java.util.List;

public class Schedule
{
	private String lastUpdatedOn;
	private List<Games> gameentry;
	
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
	public List<Games> getList()
	{
		return gameentry;
	}
}
