package data;

public class TeamStats
{
	public Team team;
	public String rank;
	public FullStats stats;
	
	public void setTeam(Team t)
	{
		team = t;
	}
	public void setRank(String str)
	{
		rank = str;
	}
	public void setStats(FullStats s)
	{
		stats = s;
	}
	public String  toString()
	{
		return team.toString() + " #" + rank + "\n" + stats.toString();
	}
}
