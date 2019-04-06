package scheduleByWeeks;

import java.util.List;

import scheduleFromAPI.Games;
import scheduleFromAPI.MakeGameObjectsUsingJackson;
import scheduleFromAPI.TeamSchedule;
import teamStructure.Conference;
import teamStructure.Team;

public class Schedule {
	Week[] weeks;
	
	public Schedule(Conference NFC, Conference AFC)
	{
		weeks = new Week[17];
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
				weeks[week-1] = new Week();
			}
			Game game = new Game(convert(g.awayTeam,NFC,AFC), convert(g.homeTeam, NFC, AFC), g.played);
			weeks[week-1].games.add(game);
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
			str += "Week " + (i+1) + "\n" + weeks[i].toString() + "\n";
		}
		return str;	
	}
}
