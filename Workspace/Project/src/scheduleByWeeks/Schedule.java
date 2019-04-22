package scheduleByWeeks;

import java.util.ArrayList;
import java.util.List;

import scheduleFromAPI.Games;
import scheduleFromAPI.MakeGameObjectsUsingJackson;
import scheduleFromAPI.TeamSchedule;
import teamStructure.Conference;
import teamStructure.Team;

public class Schedule{
	public List<Week> weeks;
	
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
			if(Integer.parseInt(g.week) != week)
			{
				week++;
				weeks.add(new Week());
			}
			Game game = new Game(convert(g.awayTeam,NFC,AFC), convert(g.homeTeam, NFC, AFC), g.played, g.location, g.time, g.date);
			weeks.get(week-1).games.add(game);
		}
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
			for(Game g : w.games)
			{
				g.played = false;
				g.calculate();
			}
		}
	}
}
