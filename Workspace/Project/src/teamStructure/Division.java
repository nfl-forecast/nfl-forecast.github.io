package teamStructure;

import java.util.ArrayList;

public class Division
{
	private Team[] teamsInDivision;
	Conference conference;
	public Division(Team Team1, Team Team2, Team Team3, Team Team4)
	{
		teamsInDivision = new Team[4];
		teamsInDivision[0] = Team1;
		teamsInDivision[1] = Team2;
		teamsInDivision[2] = Team3;
		teamsInDivision[3] = Team4;
		for(Team t : teamsInDivision)
			t.addDiv(this);
	}
	/**
	 * 
	 * @param con The conference this division is in
	 */
	public void addCon(Conference con)
	{
		conference = con;
	}
	/**
	 * 
	 * @return An Array of teams that are in this division
	 */
	public Team[] getTeams()
	{
		return teamsInDivision;
	}
	/**
	 * 
	 * @param Team
	 * @param rival
	 * @return if both parameters are in the division
	 */
	public boolean rivals(Team Team, Team rival)
	{
		return (contains(Team) && contains(rival));
	}
	/**
	 * 
	 * @param Team
	 * @return if the parameter is in this division
	 */
	public boolean contains(Team Team)
	{
		if(Team == teamsInDivision[0] || Team == teamsInDivision[1] || Team == teamsInDivision[2]|| Team == teamsInDivision[3])
			return true;
		return false;
	}
	/**
	 * 
	 * @return The team that is in first place of this division
	 */
	public Team first()
	{
		ArrayList<Team> division = new ArrayList<Team>();
		division.add(teamsInDivision[0]);
		division.add(teamsInDivision[1]);
		division.add(teamsInDivision[2]);
		division.add(teamsInDivision[3]);
		return Team.compareToDiv(division);		
	}
	/**
	 * 
	 * @return An array of all teams in the division sorted into their ranks in the division with Arr[0] being first place
	 */
	public Team[] places()
	{ 
		Team[] place = new Team[4];
		place[0] = first();
		
		ArrayList<Team> division = new ArrayList<Team>();
		division.add(teamsInDivision[0]);
		division.add(teamsInDivision[1]);
		division.add(teamsInDivision[2]);
		division.add(teamsInDivision[3]);
		division.remove(place[0]);
		place[1]  = Team.compareToDiv(division);
		
		division = new ArrayList<Team>();
		division.add(teamsInDivision[0]);
		division.add(teamsInDivision[1]);
		division.add(teamsInDivision[2]);
		division.add(teamsInDivision[3]);
		division.remove(place[0]);
		division.remove(place[1]);
		place[2]  = Team.compareToDiv(division);
		
		division = new ArrayList<Team>();
		division.add(teamsInDivision[0]);
		division.add(teamsInDivision[1]);
		division.add(teamsInDivision[2]);
		division.add(teamsInDivision[3]);
		division.remove(place[0]);
		division.remove(place[1]);
		division.remove(place[2]);
		place[3]  = Team.compareToDiv(division);
		return place;
	}
	/**
	 * @return A clone of this Division
	 */
	public Division clone()
	{
		return(new Division(this.teamsInDivision[0].clone(), this.teamsInDivision[1].clone(), this.teamsInDivision[2].clone(), this.teamsInDivision[3].clone()));
	}
	/**
	 * 
	 * @param team
	 * @return The Team if it is equal to the parameter or null if it is not
	 */
	public Team oppContains(Team team)
	{
		if(teamsInDivision[0].equals(team))
			return teamsInDivision[0];
		else if(teamsInDivision[1].equals(team))
			return teamsInDivision[1];
		else if(teamsInDivision[2].equals(team))
			return teamsInDivision[2];
		else if(teamsInDivision[3].equals(team))
			return teamsInDivision[3];
		else return null;
	}
}
