package teamStructure;

import java.awt.Color;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import data.FullStats;
import data.Stat;
import data.TeamStats;
import topLevel.Driver;

@JsonIgnoreProperties(value = { "stat" })
public class Team{
	public String name;
	
	@JsonIgnore
	private TeamStats stat;
	public double FPI;

	private Color s, p;
	Division division;
	public double wins;

	public Team(String teamName, Color primary, Color secondary) {
		name = teamName;
		s = secondary;
		p = primary;
		FPI = 1;
	}

	/**
	 * @param div The division this team is in
	 */
	public void addDiv(Division div) {
		division = div;
	}

	/**
	 * 
	 * @param home    Whether this game was a home game
	 * @param against What team this game was against
	 */
	public void addResult(boolean home, double percentage) {
		wins += percentage;
	}

	/**
	 * @return the name of the team
	 */
	public String toString() {
		return wins + "\t" + name + " FPI: " + FPI + "   ";
	}

	/**
	 * 
	 * @param one
	 * @param two
	 * @return the Team that has the higher Win percentage or null if they are the
	 *         same
	 */
	private static Team winPercentage(Team one, Team two) {
		if (two.wins != one.wins)
			if (two.wins > one.wins)
				return two;
			else
				return one;
		else
			return null;
	}

	/*
	 * @param one
	 * 
	 * @param two
	 * 
	 * @return the Team that has the higher fpi or null if they are the same
	 */
	private static Team fpi(Team one, Team two) {
		if (two.FPI != one.FPI)
			if (two.FPI > one.FPI)
				return two;
			else
				return one;
		else
			return null;
	}

	/**
	 * 
	 * @param other A List of teams
	 * @return The team with the highest ranking in the division
	 */
	public static Team compareTo(Team one, Team two) {
		if (winPercentage(one, two) != null)
			return winPercentage(one, two);
		if (fpi(one, two) != null)
			return fpi(one, two);
		return one;
	}

	/**
	 * 
	 * @param other A List of teams
	 * @return The team with the highest ranking in the division
	 */
	public static Team compareTo(ArrayList<Team> other) {
		if (other.size() == 0)
			return null;
		if (other.size() == 1)
			return other.get(0);
		winPercentage(other);
		if (other.size() == 0)
			return null;
		if (other.size() == 1)
			return other.get(0);
		fpi(other);
		return other.get(0);
	}

	/**
	 * 
	 * @param other A List of teams Removes all teams that don't have the best win
	 *              Percentage
	 */
	private static void winPercentage(ArrayList<Team> other) {
		double highestWins = 0;
		for (int i = 0; i < other.size(); i++) {
			if (other.get(i).wins > highestWins) {
				highestWins = other.get(i).wins;
			}
		}
		ArrayList<Integer> remove = new ArrayList<Integer>();
		for (int i = 0; i < other.size(); i++)
			if (other.get(i).wins < highestWins)
				remove.add(i);
		for (int i = 0; i < remove.size(); i++) {
			other.remove((int) remove.get(i));
			for (int j = i; j < remove.size(); j++)
				remove.set(j, remove.get(j) - 1);
		}
	}

	/*
	 * @param other A List of teams Removes all teams that don't have the best win
	 * Percentage
	 */
	private static void fpi(ArrayList<Team> other) {
		double best = 0;
		for (int i = 0; i < other.size(); i++) {
			if (other.get(i).FPI > best) {
				best = other.get(i).FPI;
			}
		}
		ArrayList<Integer> remove = new ArrayList<Integer>();
		for (int i = 0; i < other.size(); i++)
			if (other.get(i).FPI < best)
				remove.add(i);
		for (int i = 0; i < remove.size(); i++) {
			other.remove((int) remove.get(i));
			for (int j = i; j < remove.size(); j++)
				remove.set(j, remove.get(j) - 1);
		}
	}

	/*
	 * @return A Team class with the same team name and colors
	 */
	public Team clone() {
		return (new Team(this.name, this.p, this.s));
	}

	/**
	 * 
	 * @param team
	 * @return A boolean value of whether the two teams have the same name
	 */
	public boolean equals(Team team) {
		return team.name.equals(this.name);
	}

	@JsonIgnore
	/**
	 * @return All of the stats deposited by the APIs
	 */
	public FullStats getStats() {
		if (stat == null)
			return null;
		else
			return stat.stats;
	}

	@JsonIgnore
	/**
	 * 
	 * @return The Football Power Index
	 */
	public double getFPI() {
		return FPI;
	}

	/**
	 * 
	 * @param stats The stats that are equivalent for this team Sets the FPI based
	 *              off of the stats
	 */
	public void makeFPI(TeamStats stats) {
		// temporary test
		//stat = stats;
		wins = Integer.parseInt(stats.stats.Wins.text);
		//FPI = wins;
		//return;

		stat = stats;
		FPI = 0;
		for (Stat s : stat.stats.ImportantStats) {
			FPI += logisticShell(s.getA(), s.getB(), s.getC(), Double.parseDouble(s.text));
		}
	}

	private double logisticShell(double a, double b, double c, double statValue) {
		if (c == 1)
			statValue = statValue/Integer.parseInt(getStats().GamesPlayed.text+"");
		return 1 / (1 + Math.pow((Math.E), (a + b * (statValue))));
	}

	public double calculate(Team away) {
		// TODO: include calculating method from games
//		if (FPI > away.FPI)
//			return 1;
//		else if (FPI < away.FPI)
//			return 0;
//		else
//			return 0.5;
//		System.out.println(FPI);
//		System.out.println(1/(Math.pow(10, -(Math.abs(FPI-away.FPI)+.15)/2.5)+1));
		return 1/(Math.pow(10, (-(FPI-away.FPI)+.15)/4.3)+1);
	}
	public double superBowl(Team away)
	{
		return 1/(Math.pow(10, -(Math.abs(FPI-away.FPI))/2.5)+1);
	}
	
	public int[] getPrimaryColor()
	{
		int[] arr = {p.getRed(), p.getGreen(), p.getBlue()};
		return arr;
	}
	
	public int[] getSecondaryColor()
	{
		int[] arr = {s.getRed(), s.getGreen(), s.getBlue()};
		return arr;
	}
	
	public int getTies()
	{
		if(Driver.allPlayed)
			return 0;
		else return Integer.parseInt(stat.stats.Ties.text);
	}
	
	public double getLosses()
	{
		return 16-getTies()-wins;
	}
}
