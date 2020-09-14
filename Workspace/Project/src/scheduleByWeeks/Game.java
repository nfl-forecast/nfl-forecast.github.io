package scheduleByWeeks;

import java.awt.Color;

import com.fasterxml.jackson.annotation.JsonSetter;

import teamStructure.Team;

public class Game{
	private Team awayTeam, homeTeam;
	private double awayPCT, homePCT;
	private int homeFPI, awayFPI;
	private String awayName, homeName;
	private boolean played;
	private String time;
	private String url;
	private String date;
	private int homeScore;
	private int awayScore;
	private Color as, ap, hs, hp;
	
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
	public Team homeTeam() {
		return homeTeam;
	}

	/**
	 * 
	 * @return The home team
	 */
	public Team awayTeam() {
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
		if(homeName == null || homeName.equals(""))
			homeName = homeTeam.getName();
		return homeName;
	}
	
	public String getAwayTeamName()
	{
		if(awayName == null || awayName.equals(""))
			awayName = awayTeam.getName();
		return awayName;
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
	
	public void setHomeTeamName(String s){
		homeName = s;
	}
	
	public void setAwayTeamName(String s){
		awayName = s;
	}
	
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
	
	public int getHomeFPI() {
		if(homeFPI == 0)
			homeFPI = homeTeam.getFPI();
		return homeFPI;
	}
	
	public int getAwayFPI() {
		if(awayFPI == 0)
			awayFPI = awayTeam.getFPI();
		return awayFPI;
	}
	
	public void setHomeFPI(String str) {
		homeFPI = Integer.parseInt(str);
	}
	
	public void setAwayFPI(String str) {
		awayFPI = Integer.parseInt(str);
	}
	
	public int[] getHomeSecondaryColor() {
		if(hs == null) {
			int[] c = homeTeam.getSecondaryColor();
			hs=new Color(c[0],c[1],c[2]);
		}
		int[] arr = {hs.getRed(), hs.getGreen(), hs.getBlue()};
		return arr;
	}
	
	public int[] getHomePrimaryColor() {
		if(hp == null) {
			int[] c = homeTeam.getPrimaryColor();
			hp=new Color(c[0],c[1],c[2]);
		}
		int[] arr = {hp.getRed(), hp.getGreen(), hp.getBlue()};
		return arr;
	}
	
	public int[] getAwaySecondaryColor() {
		if(as == null) {
			int[] c = awayTeam.getSecondaryColor();
			as=new Color(c[0],c[1],c[2]);
		}
		int[] arr = {as.getRed(), as.getGreen(), as.getBlue()};
		return arr;
	}
	
	public int[] getAwayPrimaryColor() {
		if(ap == null) {
			int[] c = awayTeam.getPrimaryColor();
			ap=new Color(c[0],c[1],c[2]);
		}
		int[] arr = {ap.getRed(), ap.getGreen(), ap.getBlue()};
		return arr;
	}
	
	public void setHomeSecondaryColor(int[] c) {
		hs = new Color(c[0], c[1], c[2]);
	}
	
	public void setHomePrimaryColor(int[] c) {
		hp = new Color(c[0], c[1], c[2]);
	}
	
	public void setAwaySecondaryColor(int[] c) {
		as = new Color(c[0], c[1], c[2]);
	}
	
	public void setAwayPrimaryColor(int[] c) {
		ap = new Color(c[0], c[1], c[2]);
	}
}
