package teamStructure;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import dataFromHTML.FullStats;
import dataFromHTML.MakeObjectsUsingJackson;
import topLevel.Driver;

public class Conference implements Cloneable
{
	public static Conference AFC, NFC;
	private Division North, East, South, West;
	public Conference() {}
	public Conference(Division N, Division E, Division S, Division W) throws Exception
	{
		North = N;
		East = E;
		South = S;
		West = W;
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
	 * @return An Array of the teams that would make the playoffs with Arr[0] being first seed and Arr[6] being 7th seed
	 */
	public Team[] seeding()
	{
		ArrayList<Team> teams;
		teams = allTeams();
		teams.remove(North.first());
		teams.remove(South.first());
		teams.remove(East.first());
		teams.remove(West.first());
		Team[] seeds = new Team[7];
		seeds[4] = Team.compareTo(teams);
		
		teams = allTeams();
		teams.remove(North.first());
		teams.remove(South.first());
		teams.remove(East.first());
		teams.remove(West.first());
		teams.remove(seeds[4]);
		seeds[5] = Team.compareTo(teams);
		
		teams = allTeams();
		teams.remove(North.first());
		teams.remove(South.first());
		teams.remove(East.first());
		teams.remove(West.first());
		teams.remove(seeds[4]);
		teams.remove(seeds[5]);
		seeds[6] = Team.compareTo(teams);
		
		teams = new ArrayList<Team>();
		teams.add(North.first());
		teams.add(South.first());
		teams.add(East.first());
		teams.add(West.first());
		seeds[0] = Team.compareTo(teams);
		
		teams = new ArrayList<Team>();
		teams.add(North.first());
		teams.add(South.first());
		teams.add(East.first());
		teams.add(West.first());
		teams.remove(seeds[0]);
		seeds[1] = Team.compareTo(teams);
		
		teams = new ArrayList<Team>();
		teams.add(North.first());
		teams.add(South.first());
		teams.add(East.first());
		teams.add(West.first());
		teams.remove(seeds[0]);
		teams.remove(seeds[1]);
		seeds[2] = Team.compareTo(teams);
		
		teams = new ArrayList<Team>();
		teams.add(North.first());
		teams.add(South.first());
		teams.add(East.first());
		teams.add(West.first());
		teams.remove(seeds[0]);
		teams.remove(seeds[1]);
		teams.remove(seeds[2]);
		seeds[3] = Team.compareTo(teams);
		
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
			place[i] = Team.compareTo(allTeams);
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
		
		List<FullStats> tsList = MakeObjectsUsingJackson.run(Driver.seasonSchedule + "").Allstats.getStatEntry();
		List<Team> nostats = new ArrayList<Team>();
		for(Team t: getAllTeams())
			nostats.add(t);
		for(FullStats ts : tsList)
		{
			ts.combine();
			Team fakeTeam = new Team(ts.getTeamName(), null, null);
			if(oppContains(fakeTeam) != null) {
				oppContains(fakeTeam).makeFPI(ts);
				nostats.remove(oppContains(fakeTeam));
			}
		}
		if(nostats.size() > 0) {
			List<FullStats> newList = MakeObjectsUsingJackson.run(Driver.seasonStats + "").Allstats.getStatEntry();
			for(FullStats ts : newList)
			{
				ts.combine();
				Team fakeTeam = new Team(ts.getTeamName(), null, null);
				if(oppContains(fakeTeam) != null && nostats.contains(oppContains(fakeTeam))) {
					oppContains(fakeTeam).makeFPI(ts);
					nostats.remove(oppContains(fakeTeam));
				}
			}
		}
	}
	
	public String toString()
	{
		return North.toString() + "\n" + East.toString() + "\n" + South.toString() + "\n" + West.toString();
	}
	
	@JsonIgnore
	public Team[] getAllTeams() {
		Team[] all = new Team[16];
		Team[] east = East.getTeams();
		Team[] west = West.getTeams();
		Team[] north = North.getTeams();
		Team[] south = South.getTeams();
		for(int i = 0; i < 4; i++)
			all[i] = east[i];
		for(int i = 0; i < 4; i++)
			all[4+i] = west[i];
		for(int i = 0; i < 4; i++)
			all[8+i] = north[i];
		for(int i = 0; i < 4; i++)
			all[12+i] = south[i];
		return all;
	}
	
	public Division getNorth() {
		return North;
	}
	public Division getSouth() {
		return South;
	}
	public Division getEast() {
		return East;
	}
	public Division getWest() {
		return West;
	}

	public static ArrayList<Team> getAllLeagueTeams() {
		ArrayList<Team> allTeams = new ArrayList<Team>();
		Team[] afc = AFC.getAllTeams();
		Team[] nfc = NFC.getAllTeams();
		for(int i = 0; i < 16; i++) {
			allTeams.add(afc[i]);
			allTeams.add(nfc[i]);
		}
		return allTeams;
	}
	
	public static int getLeagueIndex(Team t) {
		return getAllLeagueTeams().indexOf(t);
	}
	
	@JsonSetter("North")
	public void setNorth(Division d) {
		North = d;
	}
	@JsonSetter("South")
	public void setSouth(Division d) {
		South = d;
	}
	@JsonSetter("East")
	public void setEast(Division d) {
		East = d;
	}
	@JsonSetter("West")
	public void setWest(Division d) {
		West = d;
	}
	
	
}
