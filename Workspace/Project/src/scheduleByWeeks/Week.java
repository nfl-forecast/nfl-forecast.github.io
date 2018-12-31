package scheduleByWeeks;

import java.util.ArrayList;

import scheduleFromAPI.TeamSchedule;
import teamStructure.Conference;
import teamStructure.Team;

public class Week
{
	ArrayList<Game> games;
	ArrayList<Team> teamsOnBye;
	
	public Week()
	{
		games = new ArrayList<Game>();
		teamsOnBye = new ArrayList<Team>();
	}
	/**
	 * 
	 * @param NFC
	 * @param AFC
	 * @return An array List of Teams in both Conferences
	 */
	private ArrayList<Team> getAllTeams(Conference NFC, Conference AFC)
	{
		ArrayList<Team> allteams = new ArrayList<Team>();
		Team[] NFCTeams = NFC.places();
		for(Team t : NFCTeams)
		{
			allteams.add(t);
		}
		Team[] AFCTeams = AFC.places();
		for(Team t : AFCTeams)
		{
			allteams.add(t);
		}
		return allteams;
	}
	/**
	 * 
	 * @param NFC
	 * @param AFC
	 * Sets the teamsOnBye by removing all teams that are playing this week
	 */
	public void setUpTeamsOnBye(Conference NFC, Conference AFC)
	{
		ArrayList<Team> allTeams = getAllTeams(NFC, AFC);
		for(Game g : games)
		{
			allTeams.remove(g.getHomeTeam());
			allTeams.remove(g.getAwayTeam());
		}
		teamsOnBye.addAll(allTeams);
	}
	public String toString()
	{
		return games.toString();
	}
}
