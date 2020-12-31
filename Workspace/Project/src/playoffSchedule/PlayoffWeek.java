package playoffSchedule;

import java.util.ArrayList;
import java.util.List;

import teamStructure.Conference;
import teamStructure.Team;

public class PlayoffWeek
{
	private boolean predicted;
	private List<PlayoffGame> games;
	private List<Team> teamsOnBye;
	private List<Team> teamsAlive;
	
	public PlayoffWeek(ArrayList<Team> stillAlive, boolean pred)
	{
		super();
		predicted = pred;
		games = new ArrayList<PlayoffGame>();
		teamsOnBye = new ArrayList<Team>();
		teamsAlive = stillAlive;
		if(pred == true) {
			createGames();
		}
	}
	
	/**
	 * 
	 * @param NFC
	 * @param AFC
	 * Sets the teamsOnBye by removing all teams that are playing this week
	 */
	public void setUpTeamsOnBye()
	{
		ArrayList<Team> allTeams = new ArrayList<Team>();
		allTeams.addAll(teamsAlive);
		for(PlayoffGame g : getGames())
		{
			allTeams.remove(g.homeTeam());
			allTeams.remove(g.awayTeam());
		}
		setTeamsOnBye(allTeams);
	}
	
	
	public String toString()
	{
		String str = "";
		for(PlayoffGame g : games)
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
	public List<PlayoffGame> getGames() {
		return games;
	}
	public List<PlayoffGame> completedGames() {
		ArrayList<PlayoffGame> played = new ArrayList<PlayoffGame>();
		for(PlayoffGame g: games)
			if(g.getPlayed())
				played.add(g);
		return played;
	}
	public boolean equals(PlayoffWeek w) {
		if(this.games.size() != w.games.size())
			return false;
		for(int i = 0; i < games.size(); i++)
			if(!w.games.get(i).equals(games.get(i)))
				return false;
		return true;
	}

	public void setGames(List<PlayoffGame> g) {
		games = g;
	}
	public void setTeamsOnBye(List<Team> t) {
		teamsOnBye = t;
	}
	
	public List<Team> getWinners() {
		ArrayList<Team> alive = new ArrayList<Team>();
		boolean flag = false;
		if(teamsOnBye.size() == 2)
			alive.add(teamsOnBye.get(0));
		for(PlayoffGame g: games) {
			if(!flag && teamsOnBye.size() == 2 && Conference.AFC.contains(g.homeTeam())) {
				flag = true;
				alive.add(teamsOnBye.get(1));
			}
			alive.add(g.getWinner());
		}
		return alive;
	}
	
	private void createGames() {
		if(teamsAlive.size() == 2)
			games.add(new PlayoffGame(teamsAlive.get(0), teamsAlive.get(1), false, "", weekName(), "", -1, -1, true));
		else {
			Team[] NFCSeeds = new Team[teamsAlive.size()/2];
			Team[] AFCSeeds = new Team[teamsAlive.size()/2];
			Team[] AFCALL = Conference.AFC.places();
			Team[] NFCALL = Conference.NFC.places();
			int AFC=0, NFC=0;
			for(int i = 0; i < teamsAlive.size(); i++) {
				Team t = teamsAlive.get(i);
				for(int j =0; j < AFCALL.length; j++) {
					if(AFCALL[j].equals(t)) {
						AFCSeeds[AFC] = t;
						AFC++;
					}
					if(NFCALL[j].equals(t)) {
						NFCSeeds[NFC] = t;
						NFC++;
					}
				}
			}
			if(weekName() != "Wildcard") {
				for(int i = 0; i < NFCSeeds.length/2; i++)
				{
					games.add(new PlayoffGame(NFCSeeds[i+NFCSeeds.length/2], NFCSeeds[i], false, "", weekName(), "", -1, -1, false));
				}
				for(int i = 0; i < AFCSeeds.length/2; i++)
				{
					games.add(new PlayoffGame(AFCSeeds[i+AFCSeeds.length/2], AFCSeeds[i], false, "", weekName(), "", -1, -1, false));
				}
			}
			else {
				for(int i = 1; i < (NFCSeeds.length+1)/2; i++)
				{
					games.add(new PlayoffGame(NFCSeeds[i+NFCSeeds.length/2], NFCSeeds[i], false, "", weekName(), "", -1, -1, false));
				}
				for(int i = 1; i < (AFCSeeds.length+1)/2; i++)
				{
					games.add(new PlayoffGame(AFCSeeds[i+AFCSeeds.length/2], AFCSeeds[i], false, "", weekName(), "", -1, -1, false));
				}
				teamsOnBye.add(NFCSeeds[0]);
				teamsOnBye.add(AFCSeeds[0]);
			}
		}
	}
	public String weekName() {
		switch(teamsAlive.size()) {
		case 2: return "Superbowl";
		case 4: return "Conference Championship";
		case 8: return "Divisional";
		case 14: return "Wildcard";
		default: return "Playoffs";
		}
	}
}
