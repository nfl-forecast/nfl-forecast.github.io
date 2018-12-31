package scheduleByWeeks;

import java.util.List;

import scheduleFromAPI.Games;
import scheduleFromAPI.MakeGameObjectsUsingJackson;
import scheduleFromAPI.TeamSchedule;
import teamStructure.Conference;
import teamStructure.Team;

public class Schedule {
	Week[] weeks;
	
	public Schedule(Conference NFC, Conference AFC) throws Exception
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
	private void getFromAPI(Conference NFC, Conference AFC) throws Exception
	{
		List<Games> listGames = MakeGameObjectsUsingJackson.run().getSchedule().getList();
		int week = 1;
		for(Games g : listGames)
		{
			if(Integer.parseInt(g.week) != week)
			{
				week++;
				weeks[week] = new Week();
			}
			weeks[week].games.add(new Game(convert(g.awayTeam,NFC,AFC), convert(g.homeTeam, NFC, AFC)));
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
			return AFC.oppContains(t);
		}
	}
	public String toString()
	{
		return weeks.toString();
	}
}
