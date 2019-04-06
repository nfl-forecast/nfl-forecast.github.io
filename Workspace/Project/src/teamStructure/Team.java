package teamStructure;

import java.awt.Color;
import java.util.ArrayList;

import data.FullStats;
import data.Stat;
import data.TeamStats;

public class Team {
	public String name;
	private TeamStats stat;
	private double FPI;

	Color s, p;
	Division division;
	public int conferenceW, divisionalW, wins, AwayWins, HomeWins;
	public ArrayList<Team> played;

	public Team(String teamName, Color primary, Color secondary) {
		name = teamName;
		s = secondary;
		p = primary;
		played = new ArrayList<Team>();
		FPI = 1;
	}

	/**
	 * @param div The division this team is in
	 */
	public void addDiv(Division div) {
		division = div;
	}

	/**
	 * Adds one to the Division Win variable
	 */
	private void addDivW(double percentage) {
		divisionalW += percentage;
	}

	/**
	 * Adds one to the conference win variable
	 */
	private void addConW(double percentage) {
		conferenceW += percentage;
	}

	/**
	 * 
	 * @param home    Whether this game was a home game
	 * @param against What team this game was against
	 */
	public void addResult(boolean home, Team against, double percentage) {
		wins += percentage;
		if (division.conference == against.division.conference)
			addConW(percentage);
		if (division == against.division)
			addDivW(percentage);
		if (home) {
			HomeWins += percentage;
		} else {
			AwayWins += percentage;
		}
		played.add(against);
	}

	/**
	 * @return the name of the team
	 */
	public String toString() {
		return name;
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

	/**
	 * 
	 * @param one
	 * @param two
	 * @return the team that has done better head to head or null if they are tied
	 *         head to head
	 */
	private static Team headTohead(Team one, Team two) {
		if (one.getFPI() > two.getFPI())
			return one;
		else if (one.getFPI() < two.getFPI())
			return two;
		else
			return null;

	}

	/**
	 * 
	 * @param one
	 * @param two
	 * @return The team who has a higher win percentage on Division games or null if
	 *         they are the same
	 */
	private static Team divisionalPercentage(Team one, Team two) {
		if (one.divisionalW != two.divisionalW)
			if (one.divisionalW > two.divisionalW)
				return one;
			else
				return two;
		else
			return null;
	}

	/**
	 * 
	 * @param one
	 * @param two
	 * @return The team with the higher win percentage in conference games or null
	 *         if they are the same
	 */
	private static Team conferencePercentage(Team one, Team two) {
		if (one.conferenceW != two.conferenceW)
			if (one.conferenceW > two.conferenceW)
				return one;
			else
				return two;
		else
			return null;
	}

	/**
	 * 
	 * @param one
	 * @param two
	 * @return The Team that is ranked higher in the division
	 */
	private static Team compareToDiv(Team one, Team two) {
		if (winPercentage(one, two) != null)
			return winPercentage(one, two);
		else if (headTohead(one, two) != null)
			return headTohead(one, two);
		else if (divisionalPercentage(one, two) != null)
			return divisionalPercentage(one, two);
		else if (conferencePercentage(one, two) != null)
			return conferencePercentage(one, two);
		else if (strengthOfSchedule(one, two) != null)
			return strengthOfSchedule(one, two);
		else
			return one;
	}

	/**
	 * 
	 * @param one
	 * @param two
	 * @return The team that is ranked higher in the Conference
	 */
	private static Team compareToCon(Team one, Team two) {
		if (one.division.contains(two)) {
			return compareToDiv(one, two);
		} else {
			if (winPercentage(one, two) != null)
				return winPercentage(one, two);
			else if (headTohead(one, two) != null)
				return headTohead(one, two);
			else if (conferencePercentage(one, two) != null)
				return conferencePercentage(one, two);
			else if (strengthOfSchedule(one, two) != null)
				return strengthOfSchedule(one, two);
			return one;
		}
	}

	/**
	 * 
	 * @param other A List of teams
	 * @return The team with the highest ranking in the division
	 */
	public static Team compareToDiv(ArrayList<Team> other) {
		if (other.size() == 0)
			return null;
		if (other.size() == 1)
			return other.get(0);
		if (other.size() == 2)
			if (compareToDiv(other.get(0), other.get(1)) == other.get(0))
				return other.get(0);
			else
				return other.get(1);
		winPercentageMultiple(other);
		if (other.size() == 1)
			return other.get(0);
		if (other.size() == 2)
			if (compareToDiv(other.get(0), other.get(1)) == other.get(0))
				return other.get(0);
			else
				return other.get(1);
		divPercentageMultiple(other);
		if (other.size() == 1)
			return other.get(0);
		if (other.size() == 2)
			if (compareToDiv(other.get(0), other.get(1)) == other.get(0))
				return other.get(0);
			else
				return other.get(1);
		conPercentageMultiple(other);
		if (other.size() == 1)
			return other.get(0);
		if (other.size() == 2)
			if (compareToDiv(other.get(0), other.get(1)) == other.get(0))
				return other.get(0);
			else
				return other.get(1);
		strengthOfSchedule(other);
		if (other.size() == 1)
			return other.get(0);
		if (other.size() == 2)
			if (compareToDiv(other.get(0), other.get(1)) == other.get(0))
				return other.get(0);
			else
				return other.get(1);
		return other.get(0);
	}

	/**
	 * 
	 * @param other A list of teams that are tied in the same division Removes all
	 *              the teams that do not have the highest record in the division
	 */
	private static void divPercentageMultiple(ArrayList<Team> other) {
		int highestDivisionalW = 0;
		for (int i = 0; i < other.size(); i++) {
			if (other.get(i).divisionalW > highestDivisionalW) {
				highestDivisionalW = other.get(i).divisionalW;
			}
		}
		ArrayList<Integer> remove = new ArrayList<Integer>();
		for (int i = 0; i < other.size(); i++) {
			if (other.get(i).divisionalW < highestDivisionalW)
				remove.add(i);
		}
		for (int i = 0; i < remove.size(); i++) {
			other.remove((int) remove.get(i));
			for (int j = i; j < remove.size(); j++)
				remove.set(j, remove.get(j) - 1);
		}
	}

	/**
	 * 
	 * @param other A list of teams that are tied in the conference Removes all of
	 *              the teams that dont have the best conference record
	 */
	private static void conPercentageMultiple(ArrayList<Team> other) {
		int highestWins = 0;
		for (int i = 0; i < other.size(); i++) {
			if (other.get(i).conferenceW > highestWins)
				highestWins = other.get(i).conferenceW;

		}
		ArrayList<Integer> remove = new ArrayList<Integer>();
		for (int i = 0; i < other.size(); i++) {
			if (other.get(i).conferenceW < highestWins)
				remove.add(i);
		}
		for (int i = 0; i < remove.size(); i++) {
			other.remove((int) remove.get(i));
			for (int j = i; j < remove.size(); j++)
				remove.set(j, remove.get(j) - 1);
		}
	}

	/**
	 * 
	 * @param other A list of teams in the conference
	 * @return The team that is ranked the highest
	 */
	public static Team compareToCon(ArrayList<Team> other) {
		Conference con = other.get(0).division.conference;
		if (other.size() == 0)
			return null;
		if (other.size() == 1)
			return other.get(0);
		if (other.size() == 2) {
			return compareToCon(other.get(0), other.get(1));
		}
		ArrayList<Team> n = new ArrayList<Team>(), s = new ArrayList<Team>(), e = new ArrayList<Team>(),
				w = new ArrayList<Team>();
		for (int i = 0; i < other.size(); i++) {
			if (other.get(i).division == con.North) {
				n.add(other.get(i));
			}
			if (other.get(i).division == con.South) {
				s.add(other.get(i));
			}
			if (other.get(i).division == con.East) {
				e.add(other.get(i));
			}
			if (other.get(i).division == con.West) {
				w.add(other.get(i));
			}
		}
		other = new ArrayList<Team>();
		if (compareToDiv(n) != null)
			other.add(compareToDiv(n));
		if (compareToDiv(s) != null)
			other.add(compareToDiv(s));
		if (compareToDiv(e) != null)
			other.add(compareToDiv(e));
		if (compareToDiv(w) != null)
			other.add(compareToDiv(w));
		return compareToConP2(other);
	}

	/**
	 * 
	 * @param other A list of teams that are in the same conference but not the same
	 *              division
	 * @return The team that is ranked the highest
	 */
	private static Team compareToConP2(ArrayList<Team> other) {
		if (other.size() == 0)
			return null;
		if (other.size() == 1)
			return other.get(0);
		if (other.size() == 2) {
			return compareToCon(other.get(0), other.get(1));
		}
		winPercentageMultiple(other);
		if (other.size() == 1)
			return other.get(0);
		if (other.size() == 2) {
			return compareToCon(other.get(0), other.get(1));
		}
		conPercentageMultiple(other);
		if (other.size() == 1)
			return other.get(0);
		if (other.size() == 2) {
			return compareToCon(other.get(0), other.get(1));
		}
		strengthOfSchedule(other);
		if (other.size() == 2) {
			return compareToCon(other.get(0), other.get(1));
		}
		return other.get(0);
	}

	/**
	 * 
	 * @param other A List of teams Removes all teams that don't have the best win
	 *              Percentage
	 */
	private static void winPercentageMultiple(ArrayList<Team> other) {
		int highestWins = 0;
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

	/**
	 * 
	 * @param other A list of teams that are tied Removes the teams that haven't had
	 *              the hardest season
	 */
	private static void strengthOfSchedule(ArrayList<Team> other) {
		int[] wins = new int[other.size()], ties = new int[other.size()], losses = new int[other.size()];
		int highW = 0, highT = 0, lowL = 16;
		for (int i = 0; i < wins.length; i++) {
			for (int j = 0; j < other.get(i).played.size(); j++) {
				wins[i] += other.get(i).played.get(j).wins;
			}
		}
		for (int i = 0; i < wins.length; i++) {
			if (wins[i] > highW || (wins[i] == highW && ties[i] > highT)
					|| (wins[i] == highW && ties[i] == highT && losses[i] < lowL)) {
				highW = wins[i];
				highT = ties[i];
				lowL = losses[i];
			}
		}
		ArrayList<Integer> remove = new ArrayList<Integer>();
		for (int i = 0; i < other.size(); i++)
			if (wins[i] < highW || (wins[i] == highW && ties[i] < highT)
					|| (wins[i] == highW && ties[i] == highT && (losses[i] > lowL)))
				remove.add(i);
		for (int i = 0; i < remove.size(); i++) {
			other.remove((int) remove.get(i));
			for (int j = i; j < remove.size(); j++)
				remove.set(j, remove.get(j) - 1);
		}
	}

	/**
	 * 
	 * @param one
	 * @param two
	 * @return The team that has had a harder schedule
	 */
	private static Team strengthOfSchedule(Team one, Team two) {
		int wins1 = 0, wins2 = 0;
		for (int j = 0; j < one.played.size(); j++) {
			wins1 += one.played.get(j).wins;
		}
		for (int j = 0; j < two.played.size(); j++) {
			wins2 += two.played.get(j).wins;
		}
		if (wins1 > wins2)
			return one;
		else if (wins2 > wins1)
			return two;
		else
			return null;
	}

	/**
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

	/**
	 * @return All of the stats deposited by the APIs
	 */
	public FullStats getStats() {
		if (stat == null)
			return null;
		else
			return stat.stats;
	}

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
		//temporary test
		stat = stats;
		return;
		
		//stat = stats;
		//FPI = 0;
		//for (Stat s : stat.stats.ImportantStats) {
		//	FPI += logisticShell(s.getA(), s.getB(), Double.parseDouble(s.text));
		//}
		// TODO: Make a FPI
	}

	private double logisticShell(double a, double b, double statValue) {
		return 1 / (1 + Math.pow((Math.E), (a + b * (statValue))));
	}

	public double calculate(Team away) {
		// TODO: include calculating method from games
		return 0;
	}
}
