package scheduleByWeeks;

import teamStructure.Team;

public class Game {
	Team awayTeam, homeTeam;
	double awayPCT, homePCT;

	public Game(Team away, Team home) {
		awayTeam = away;
		homeTeam = home;
		calculate();
	}

	/**
	 * @return The home team
	 */
	public Team getHomeTeam() {
		return homeTeam;
	}

	/**
	 * 
	 * @return The home team
	 */
	public Team getAwayTeam() {
		return awayTeam;
	}

	/**
	 * Makes percentages to represent each teams chances to win the game
	 */
	public void calculate() {
		// TODO: Set the formula to calculate percent chance to win
		awayPCT = 1-homePCT;
		setRecords();
	}

	/**
	 * Changes the teams records to show who was predicted to win
	 */
	private void setRecords() {
		awayTeam.addResult(false, homeTeam, awayPCT);
		homeTeam.addResult(true, awayTeam, homePCT);

	}

	public String toString() {
		return awayTeam.toString() + " @ " + homeTeam.toString();
	}
}
