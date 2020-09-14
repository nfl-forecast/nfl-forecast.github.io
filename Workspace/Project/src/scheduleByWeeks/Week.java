package scheduleByWeeks;

import java.util.ArrayList;
import java.util.List;

import teamStructure.Conference;
import teamStructure.Team;

public class Week
{
	private List<Game> games;
	private List<Team> teamsOnBye;
	
	public Week()
	{
		games = new ArrayList<Game>();
		teamsOnBye = new ArrayList<Team>();
	}
	/**
	 * 
	 * @param NFC
	 * @param AFC
	 * Sets the teamsOnBye by removing all teams that are playing this week
	 */
	public void setUpTeamsOnBye(Conference NFC, Conference AFC)
	{
		ArrayList<Team> allTeams = Conference.getAllTeams(NFC, AFC);
		for(Game g : games)
		{
			allTeams.remove(g.homeTeam());
			allTeams.remove(g.awayTeam());
		}
		teamsOnBye.addAll(allTeams);
	}
	
	public String toString()
	{
		String str = "";
		for(Game g : games)
		{
			str += g.toString();
			str+= "\n";
		}
		return str;
	}
	public List<Team> getTeamsOnBye()
	{
		return teamsOnBye;
	}
	public List<Game> getGames() {
		return games;
	}
	public List<Game> completedGames() {
		ArrayList<Game> played = new ArrayList<Game>();
		for(Game g: games)
			if(g.getPlayed())
				played.add(g);
		return played;
	}
	public boolean equals(Week w) {
		if(this.games.size() != w.games.size())
			return false;
		for(int i = 0; i < games.size(); i++)
			if(!w.games.get(i).equals(games.get(i)))
				return false;
		return true;
	}

	public void setGames(List<Game> g) {
		games = g;
	}
	public void setTeamsOnBye(List<Team> t) {
		teamsOnBye = t;
	}
}
