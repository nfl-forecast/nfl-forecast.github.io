package scheduleFromHTML;

import java.util.List;

public class Schedule
{
	private String lastUpdatedOn;
	public List<Games> gameentry;
	
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
