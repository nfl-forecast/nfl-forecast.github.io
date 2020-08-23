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
	
	public Schedule(Conference NFC, Conference AFC)
	{
		weeks = new ArrayList<Week>();
		getFromAPI(NFC, AFC);
	}
	/**
	 * 
	 * @param NFC
	 * @param AFC
	 * @throws Exception
	 * Sets the weeks using the API
	 */
	private void getFromAPI(Conference NFC, Conference AFC)
	{
		try {
		List<Games> listGames = MakeGameObjectsUsingJackson.run().getSchedule().getList();
		int week = 0;
		for(Games g : listGames)
		{
			if(Integer.parseInt(g.getWeek()) != week)
			{
				if(week != 0)
					weeks.get(week-1).setUpTeamsOnBye(NFC, AFC);
				week++;
				weeks.add(new Week());
			}
			Game game = new Game(convert(g.getAwayTeam(),NFC,AFC), convert(g.getHomeTeam(), NFC, AFC), g.getPlayed(), g.getTime(), g.getDate(), g.getAwayTeam().getScore(), g.getHomeTeam().getScore());
			weeks.get(week-1).getGames().add(game);
		}
		weeks.get(16).setUpTeamsOnBye(NFC, AFC);
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
	public Team convert(TeamSchedule team, Conference NFC, Conference AFC)
	{
		Team t = new Team(team.toString(), null, null);
		if(NFC.oppContains(t) != null)
		{
			return NFC.oppContains(t);
		}
		else
		{
			if(AFC.oppContains(t) == null)
				System.out.println(team.toString());
			return AFC.oppContains(t);
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
}
