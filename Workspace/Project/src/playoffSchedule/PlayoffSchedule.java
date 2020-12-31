package playoffSchedule;

import java.util.ArrayList;
import java.util.List;

import scheduleFromHTML.Games;
import scheduleFromHTML.MakeGameObjectsUsingJackson;
import scheduleFromHTML.TeamSchedule;
import teamStructure.Conference;
import teamStructure.Team;

public class PlayoffSchedule{
	private List<PlayoffWeek> weeks;
	public PlayoffSchedule()
	{
		weeks = new ArrayList<PlayoffWeek>();
		getFromAPI();
		runRest();
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
		List<Games> listGames = MakeGameObjectsUsingJackson.runPost().getSchedule().getList();
		String week = "Wild Card";
		for(Games g : listGames)
		{
			if(!g.getWeek().equals(week))
			{
				if(week != "Wild Card") 
					weeks.get(weeks.size()-1).setUpTeamsOnBye();
				weeks.add(new PlayoffWeek((ArrayList<Team>)weeks.get(weeks.size()-1).getWinners(),false));
				week = g.getWeek();
				
			}
			PlayoffGame game;
			if(week != "Superbowl")
				 game = new PlayoffGame(convert(g.getAwayTeam()), convert(g.getHomeTeam()), g.getPlayed(), g.getTime(), g.getDate(), g.getUrl() ,g.getAwayTeam().getScore(), g.getHomeTeam().getScore(), false);
			else
				game = new PlayoffGame(convert(g.getAwayTeam()), convert(g.getHomeTeam()), g.getPlayed(), g.getTime(), g.getDate(), g.getUrl() ,g.getAwayTeam().getScore(), g.getHomeTeam().getScore(), true);
			
			weeks.get(weeks.size() -1).getGames().add(game);
		}
		if(weeks.size() != 0)
			weeks.get(weeks.size()-1).setUpTeamsOnBye();
		
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
			str += "PlayoffWeek " + (i+1) + "\n" + weeks.get(i).toString() + "\n";
		}
		return str;	
	}
	public void makeNotPlayed()
	{
		for(PlayoffWeek w: weeks)
		{
			for(PlayoffGame g : w.getGames())
			{				
				g.calculate();
			}
		}
	}

	public List<PlayoffWeek> getPlayoffWeeks() {
		return weeks;
	}
	public List<PlayoffWeek> completedPlayoffWeeks() {
		ArrayList<PlayoffWeek> compPlayoffWeeks = new ArrayList<PlayoffWeek>();
		boolean flag = false;
		for(int i= 0; i < weeks.size() && !flag; i++) {
			compPlayoffWeeks.add(weeks.get(i));
			if(weeks.get(i).completedGames().size() - weeks.get(i).getGames().size() != 0) {	
				flag = true;
			}
		}
		return compPlayoffWeeks;
	}

	public void setPlayoffWeeks(List<PlayoffWeek> w) {
		weeks = w;
	}
	public void runRest() {
		for(int i = weeks.size()-1; i < 4; i++) {
			if(i > 0)
				weeks.add(new PlayoffWeek((ArrayList)weeks.get(i-1).getWinners(), true));
			else if(i == 0) {
				ArrayList<Team> playoffTeams = new ArrayList<Team>();
				Team[] a = Conference.AFC.seeding();
				Team[] n = Conference.NFC.seeding();
				for(int j = 0; j < a.length; j++)
					playoffTeams.add(a[j]);
				for(int j = 0; j < n.length; j++)
					playoffTeams.add(n[j]);
				weeks.add(new PlayoffWeek(playoffTeams, true));
			}
		}
	}
}
