package data;

public class TeamStats
{
	private TeamData team;
	private String rank;
	private FullStats stats;
	
	public void setTeam(TeamData t)
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
	
	public TeamData getTeam()
	{
		return team;
	}
	
	public FullStats getStats() {
		return stats;
	}
}
