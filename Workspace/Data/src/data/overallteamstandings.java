package data;

import java.util.List;

public class overallteamstandings<t>
{
	String lastUpdatedOn;
	List<TeamStats> teamstandingsentry;
	
	public String toString()
	{System.out.println(teamstandingsentry);
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
}
