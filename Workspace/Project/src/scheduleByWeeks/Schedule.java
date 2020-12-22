package scheduleByWeeks;

import java.util.ArrayList;
import java.util.List;

import scheduleFromHTML.Games;
import scheduleFromHTML.MakeGameObjectsUsingJackson;
import scheduleFromHTML.TeamSchedule;
import teamStructure.Conference;
import teamStructure.Team;

public class Schedule{
	private List<Week> weeks;
	public Schedule()
	{
		weeks = new ArrayList<Week>();
		getFromAPI();
		createTeamScheds();
	}
	/**
	 * 
	 * @param NFC
	 * @param AFC
	 * @throws Exception
	 * Sets the weeks using the API
	 */
	private void getFromAPI()
	{
		try {
		List<Games> listGames = MakeGameObjectsUsingJackson.run().getSchedule().getList();
		int week = 0;
		for(Games g : listGames)
		{
			if(Integer.parseInt(g.getWeek()) != week)
			{
				if(week != 0)
					weeks.get(week-1).setUpTeamsOnBye();
				week++;
				weeks.add(new Week());
			}
			Game game = new Game(convert(g.getAwayTeam()), convert(g.getHomeTeam()), g.getPlayed(), g.getTime(), g.getDate(), g.getUrl() ,g.getAwayTeam().getScore(), g.getHomeTeam().getScore());
			weeks.get(week-1).getGames().add(game);
		}
		weeks.get(16).setUpTeamsOnBye();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param team A team in the TeamSchedule format
	 * @param NFC
	 * @param AFC
	 * @return The same team in the Team format
	 */
	public Team convert(TeamSchedule team)
	{
		Team t = new Team(team.toString(), null, null);
		if(Conference.NFC.oppContains(t) != null)
		{
			return Conference.NFC.oppContains(t);
		}
		else
		{
			if(Conference.AFC.oppContains(t) == null)
				System.out.println(team.toString());
			return Conference.AFC.oppContains(t);
		}
	}
	public String toString()
	{
		String str = "";
		for(int i = 0; i < 17; i++)
		{
			str += "Week " + (i+1) + "\n" + weeks.get(i).toString() + "\n";
		}
		return str;	
	}
	public void makeNotPlayed()
	{
		for(Week w: weeks)
		{
			for(Game g : w.getGames())
			{				
				g.calculate();
			}
		}
	}

	public List<Week> getWeeks() {
		return weeks;
	}
	public List<Week> completedWeeks() {
		ArrayList<Week> compWeeks = new ArrayList<Week>();
		boolean flag = false;
		for(int i= 0; i < weeks.size() && !flag; i++) {
			compWeeks.add(weeks.get(i));
			if(weeks.get(i).completedGames().size() - weeks.get(i).getGames().size() != 0) {	
				flag = true;
			}
		}
		return compWeeks;
	}

	public void setWeeks(List<Week> w) {
		weeks = w;
	}
	
	private void createTeamScheds() {
		Game[][] teamScheds = new Game[32][17];
		for(int i = 0; i < weeks.size(); i++) {
			List<Game> games = weeks.get(i).getGames();
			for(int j = 0; j <games.size(); j++) {
				Game g = games.get(j);
				Team away = g.awayTeam();
				Team home = g.homeTeam();
				int awayIndex = Conference.getLeagueIndex(away);
				int homeIndex = Conference.getLeagueIndex(home);
				teamScheds[awayIndex][i] = g;
				teamScheds[homeIndex][i] = g;
			}
			List<Team> byes = weeks.get(i).getTeamsOnBye();
			for(int j = 0; j < byes.size(); j++) {
				teamScheds[Conference.getLeagueIndex(byes.get(j))][i] = null;
			}
		}
		Object[] teams = Conference.getAllLeagueTeams().toArray();
		for(int i = 0; i < teams.length; i++)
			((Team)teams[i]).addTeamSchedule(teamScheds[i]);
	}
}
