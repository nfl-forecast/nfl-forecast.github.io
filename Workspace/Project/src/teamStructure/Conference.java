package teamStructure;

import java.util.ArrayList;
import java.util.List;

import data.MakeObjectsUsingJackson;
import data.TeamStats;

public class Conference implements Cloneable
{
	Division North, East, South, West;
	public Conference(Division N, Division E, Division S, Division W) throws Exception
	{
		North = N;
		East = E;
		South = S;
		West = W;
		East.addCon(this);
		North.addCon(this);
		South.addCon(this);
		West.addCon(this);
		getStats();
	}
	/**
	 * 
	 * @param Team
	 * @param rival
	 * @return if both teams are in this conference
	 */
	public boolean rivalsC(Team Team, Team rival)
	{
		return(contains(Team) && contains(rival));
	}
	/**
	 * 
	 * @param Team
	 * @param rival
	 * @return if both teams are in the same division
	 */
	public boolean rivalsD(Team Team, Team rival)
	{
		if(rivalsC(Team, rival))
			if(North.rivals(Team, rival) || East.rivals(Team, rival) || West.rivals(Team, rival) ||South.rivals(Team, rival))
				return true;
			else
				return false;
		else
			return false;
	}
	/**
	 * 
	 * @param Team
	 * @return A boolean that represents if team is in this conference
	 */
	public boolean contains(Team Team)
	{
		return (East.contains(Team) || South.contains(Team) || North.contains(Team) || West.contains(Team));
	}
	/**
	 * 
	 * @return An Array of the teams that would make the playoffs with Arr[0] being first seed and Arr[5] being 6th seed
	 */
	public Team[] seeding()
	{
		ArrayList<Team> teams;
		teams = allTeams();
		teams.remove(North.first());
		teams.remove(South.first());
		teams.remove(East.first());
		teams.remove(West.first());
		Team[] seeds = new Team[6];
		seeds[4] = Team.compareToCon(teams);
		
		teams = allTeams();
		teams.remove(North.first());
		teams.remove(South.first());
		teams.remove(East.first());
		teams.remove(West.first());
		teams.remove(seeds[4]);
		seeds[5] = Team.compareToCon(teams);
		
		teams = new ArrayList<Team>();
		teams.add(North.first());
		teams.add(South.first());
		teams.add(East.first());
		teams.add(West.first());
		seeds[0] = Team.compareToCon(teams);
		
		teams = new ArrayList<Team>();
		teams.add(North.first());
		teams.add(South.first());
		teams.add(East.first());
		teams.add(West.first());
		teams.remove(seeds[0]);
		seeds[1] = Team.compareToCon(teams);
		
		teams = new ArrayList<Team>();
		teams.add(North.first());
		teams.add(South.first());
		teams.add(East.first());
		teams.add(West.first());
		teams.remove(seeds[0]);
		teams.remove(seeds[1]);
		seeds[2] = Team.compareToCon(teams);
		
		teams = new ArrayList<Team>();
		teams.add(North.first());
		teams.add(South.first());
		teams.add(East.first());
		teams.add(West.first());
		teams.remove(seeds[0]);
		teams.remove(seeds[1]);
		teams.remove(seeds[2]);
		seeds[3] = Team.compareToCon(teams);
		
		return seeds;
	}
	/**
	 * 
	 * @return An ArrayList of all teams in the conference
	 */
	private ArrayList<Team> allTeams()
	{
		ArrayList<Team> all = new ArrayList<Team>();
		all.add(West.getTeams()[0]);
		all.add(West.getTeams()[1]);
		all.add(West.getTeams()[2]);
		all.add(West.getTeams()[3]);
		all.add(East.getTeams()[0]);
		all.add(East.getTeams()[1]);
		all.add(East.getTeams()[2]);
		all.add(East.getTeams()[3]);
		all.add(South.getTeams()[0]);
		all.add(South.getTeams()[1]);
		all.add(South.getTeams()[2]);
		all.add(South.getTeams()[3]);
		all.add(North.getTeams()[0]);
		all.add(North.getTeams()[1]);
		all.add(North.getTeams()[2]);
		all.add(North.getTeams()[3]);
		return all;
	}
	/**
	 * 
	 * @return An Array of the entire conference sorted by their seedings with Arr[0] being the best team in the conference
	 */
	public Team[] places()
	{
		Team[] place = new Team[16];
		for(int i = 0; i < 6; i++)
			place[i] = seeding()[i];
		for(int i = 6; i < 16; i++)
		{
			ArrayList<Team> allTeams;
			allTeams = allTeams();
			for(int j = i-1; j >= 0; j--)
				allTeams.remove(place[j]);
			place[i] = Team.compareToCon(allTeams);
		}
		return place;
	}
	/**
	 * @return A clone of this instance of Conference
	 */
	public Conference clone()
	{
		try {
			return new Conference(this.North.clone(), this.East.clone(), this.South.clone(), this.West.clone());
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 
	 * @param team
	 * @return The value of the Team if it is in the conference and null if it is not
	 */
	public Team oppContains(Team team)
	{
		
		if(North.oppContains(team) != null)
			return North.oppContains(team);
		else if(East.oppContains(team) != null)
			return East.oppContains(team);
		else if(South.oppContains(team) != null)
			return South.oppContains(team);
		else if(West.oppContains(team) != null)
			return West.oppContains(team);
		else return null;
	}
	/**
	 * @throws Exception
	 * Sets FPIs for all Teams in this conference
	 */
	private void getStats()
	{
		List<TeamStats> tsList = MakeObjectsUsingJackson.run().overallteamstandings.teamstandingsentry;
		for(TeamStats ts : tsList)
		{
			ts.stats.combine();
			Team fakeTeam = new Team(ts.team.toString(), null, null);
			if(oppContains(fakeTeam) != null)
				oppContains(fakeTeam).makeFPI(ts);
		}
	}
	public String toString()
	{
		return North.toString() + "\n" + East.toString() + "\n" + South.toString() + "\n" + West.toString();
	}
}
