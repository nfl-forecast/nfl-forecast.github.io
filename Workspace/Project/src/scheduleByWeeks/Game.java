package scheduleByWeeks;

import java.io.Serializable;

import teamStructure.Team;

public class Game implements Serializable{
	private static final long serialVersionUID = 8248347989224830518L;
	Team awayTeam, homeTeam;
	double awayPCT, homePCT;
	boolean played;
	String location;
	String time;
	String date;

	public Game(Team away, Team home, boolean isPlayed, String l, String t, String d) {
		awayTeam = away;
		homeTeam = home;
		played = isPlayed;
		location = l;
		time = t;
		date = d;
		if(!played)
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
		homePCT = homeTeam.calculate(awayTeam);
		awayPCT = 1-homePCT;
		setRecords();
	}

	/**
	 * Changes the teams records to show who was predicted to win
	 */
	private void setRecords() {
		awayTeam.addResult(false, awayPCT);
		homeTeam.addResult(true, homePCT);

	}

	public String toString() {
		return awayTeam.toString() + " @ " + homeTeam.toString();
	}
}
