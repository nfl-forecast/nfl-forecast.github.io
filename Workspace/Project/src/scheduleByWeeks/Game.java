package scheduleByWeeks;

import teamStructure.Team;

public class Game
{
	Team awayTeam, homeTeam;
	double awayPCT, homePCT;
	
	public Game(Team away, Team home)
	{
		awayTeam = away;
		homeTeam = home;
	}
	/**
	 * @return The home team
	 */
	public Team getHomeTeam()
	{
		return homeTeam;
	}
	/**
	 * 
	 * @return The home team
	 */
	public Team getAwayTeam()
	{
		return awayTeam;
	}
	/**
	 * Makes percentages to represent each teams chances to win the game
	 */
	public void calulate()
	{
		//TODO: Set the formula to calculate percent chance to win
		setRecords();
	}
	/**
	 * Changes the teams records to show who was predicted to win
	 */
	private void setRecords()
	{
		if(awayTeam.getFPI() > homeTeam.getFPI())
		{
			awayTeam.addWin(false, homeTeam);
			homeTeam.addLoss(true, awayTeam);
		}
		else if(awayTeam.getFPI() < homeTeam.getFPI())
		{
			awayTeam.addLoss(false, homeTeam);
			homeTeam.addWin(true, awayTeam);
		}
		else
		{
			awayTeam.addtie(false, homeTeam);
			homeTeam.addtie(true, awayTeam);
		}
	}
	public String toString()
	{
		return awayTeam.toString() + " @ " + homeTeam.toString();
	}
}
