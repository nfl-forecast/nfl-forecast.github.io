package scheduleByWeeks;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import teamStructure.Team;

public class Game{
	private Team awayTeam, homeTeam;
	@JsonIgnore
	private double awayPCT, homePCT;
	private boolean played;
	private String location;
	private String time;
	private String date;

	public Game(Team away, Team home, boolean isPlayed, String l, String t, String d) {
		awayTeam = away;
		homeTeam = home;
		played = isPlayed;
		location = l;
		time = t;
		date = d;
		checkPlayed();
		if(!played)
			calculate();
	}

	@JsonIgnore
	/**
	 * @return The home team
	 */
	public Team getHomeTeam() {
		return homeTeam;
	}

	@JsonIgnore
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

	public String getHomeTeamName()
	{
		return homeTeam.getName();
	}
	
	public String getAwayTeamName()
	{
		return awayTeam.getName();
	}

	public String getHomePercent()
	{
		return Math.round(100*homePCT)+"%";
	}
	
	public String getAwayPercent()
	{
		return Math.round(100*awayPCT)+"%";
	}
	
	public void setDate(String str)
	{
		date = str;
	}
	
	public void setTime(String str)
	{
		time = str;
	}
	
	public void checkPlayed()
	{
		LocalDate today = LocalDate.now();
		LocalDate played = LocalDate.parse(date);
		if(today.compareTo(played) < 0)
			this.played = false;
		else if(today.compareTo(played) > 0)
		{
			this.played = true;
		}
		else
		{
			this.played = false;
		}
	}
}
