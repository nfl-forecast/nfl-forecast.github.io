package scheduleByWeeks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import teamStructure.Team;

public class Game{
	private Team awayTeam, homeTeam;
	private double awayPCT, homePCT;
	private boolean played;
	private String time;
	private String url;
	private String date;
	private int homeScore;
	private int awayScore;
	
	public Game() {}

	public Game(Team away, Team home, boolean isPlayed, String t, String d, String u, int awayScore, int homeScore) {
		awayTeam = away;
		homeTeam = home;
		played = isPlayed;
		time = t;
		date = d;
		this.awayScore = awayScore;
		this.homeScore = homeScore;
		url = u;
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

	public String getHomeTeamName()
	{
		return homeTeam.getName();
	}
	
	public String getAwayTeamName()
	{
		return awayTeam.getName();
	}

	public String getHomePCT()
	{
		return Math.round(100*homePCT)+"%";
	}
	
	public String getAwayPCT()
	{
		return Math.round(100*awayPCT)+"%";
	}
	
	public void setHomePCT(double h)
	{
		homePCT = h;
	}
	public void setAwayPCT(double a)
	{
		awayPCT = a;
	}
	
	public void setDate(String str)
	{
		date = str;
	}
	
	public void setTime(String str)
	{
		time = str;
	}
	
	public int getAwayScore() {
		return awayScore;
	}
	
	public int getHomeScore() {
		return homeScore;
	}
	
	public String getTime() {
		return time;
	}
	public String getDate() {
		return date;
	}
	
	public String getUrl() {
		return url;
	}
	
	public boolean getPlayed() {
		return played;
	}

	public boolean equals(Game g) {
		return(url.equals(g.url));
	}


	public void setHomeTeam(Team t) {
		homeTeam = t;
	}

	public void setAwayTeam(Team t) {
		awayTeam = t;
	}
	
	public void setHomeTeamName(String s){}
	
	public void setAwayTeamName(String s){}
	
	public void setAwayScore(int s) {
		awayScore = s;
	}
	
	public void setHomeScore(int s) {
		homeScore = s;
	}
	
	public void setUrl(String str) {
		url = str;
	}
	
	public void setPlayed(boolean b) {
		played = b;
	}
	
	
	@JsonSetter("homePCT")
	public void setHomePCT(String s)
	{
		double d = Double.parseDouble(s.replace("%", ""));
		homePCT = d/100;
	}
	@JsonSetter("awayPCT")
	public void setAwayPCT(String s)
	{
		double d = Double.parseDouble(s.replace("%", ""));
		awayPCT = d/100;
	}
	
}
