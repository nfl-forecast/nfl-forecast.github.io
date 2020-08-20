package data;

import java.util.List;

public class overallteamstandings
{
	private String lastUpdatedOn;
	private List<TeamStats> teamstandingsentry;
	
	public String toString()
	{
		String str = "";
		for(TeamStats t : teamstandingsentry)
			str += t.toString() + "\n\n";
		return str;
	}
	public void setLastUpdatedOn(String str)
	{
		lastUpdatedOn = str;
	}
	public void setTeamstandingsentry(List<TeamStats> t)
	{
		teamstandingsentry = t;
	}
	public List<TeamStats> getTeamstandingsentry()
	{
		return teamstandingsentry;
	}
}
