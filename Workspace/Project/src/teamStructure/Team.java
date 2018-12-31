package teamStructure;

import java.awt.Color;
import java.util.ArrayList;

import data.FullStats;
import data.TeamStats;

public class Team {
	public String name;
	private TeamStats stat;
	private double FPI;

	Color s, p;
	Division division;
	public int conferenceW, divisionalW, wins, AwayWins, AwayLoss, AwayTies, HomeTies, HomeLoss, HomeWins, ties, losses,
			conferenceT, divisionalT, conferenceL, divisionalL;
	public ArrayList<Team> winTeams, lossTeams, tieTeams, played;

	public Team(String teamName, Color primary, Color secondary) {
		name = teamName;
		s = secondary;
		p = primary;
		winTeams = new ArrayList<Team>();
		lossTeams = new ArrayList<Team>();
		tieTeams = new ArrayList<Team>();
		played = new ArrayList<Team>();
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
	 * @param against What team the game was played against
	 */
	public void addLoss(boolean home, Team against) {
		losses++;
		if (division.conference == against.division.conference)
			addConL();
		if (division == against.division)
			addDivL();
		if (home)
			HomeLoss++;
		else
			AwayLoss++;
		lossTeams.add(against);
		played.add(against);
	}

	/**
	 * Adds one to the Division Win variable
	 */
	private void addDivW() {
		divisionalW++;
	}

	/**
	 * Adds one to the conference win variable
	 */
	private void addConW() {
		conferenceW++;
	}

	/**
	 * Adds one to the Division Ties variable
	 */
	private void addDivT() {
		divisionalT++;
	}

	/**
	 * Adds one to the Conference Ties variable
	 */
	private void addConT() {
		conferenceT++;
	}

	/**
	 * Adds one to the Division loss Variable
	 */
	private void addDivL() {
		divisionalL++;
	}

	/**
	 * Adds one to the COnference Loss Variable
	 */
	private void addConL() {
		conferenceL++;
	}

	/**
	 * 
	 * @param home    Whether this game was a home game
	 * @param against What team this game was against
	 */
	public void addWin(boolean home, Team against) {
		wins++;
		if (division.conference == against.division.conference)
			addConW();
		if (division == against.division)
			addDivW();
		if (home) {
			HomeWins++;
		} else {
			AwayWins++;
		}
		winTeams.add(against);
		played.add(against);
	}

	/**
	 * 
	 * @param home    Whether this game was a home game
	 * @param against What team this game was agianst
	 */
	public void addtie(boolean home, Team against) {
		ties++;
		if (division.conference == against.division.conference)
			addConT();
		if (division == against.division)
			addDivT();
		if (home) {
			HomeTies++;
		} else {
			AwayTies++;
		}
		tieTeams.add(against);
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
		else if (two.ties != one.ties)
			if (two.ties > one.ties)
				return two;
			else
				return one;
		else if (two.losses != one.losses)
			if (two.losses > one.losses)
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
	 * @return the team that has done better head to head or null if they are tied
	 *         head to head
	 */
	private static Team headTohead(Team one, Team two) {
		if (one.winTeams.contains(two) && !one.lossTeams.contains(two))
			return one;
		else if (one.lossTeams.contains(two) && !one.winTeams.contains(two))
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
		else if (one.divisionalT != two.divisionalT)
			if (one.divisionalT > two.divisionalT)
				return one;
			else
				return two;
		else if (one.divisionalL != two.divisionalL)
			if (one.divisionalL > two.divisionalL)
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
	 * @return The team that has a better record against common opponents or NUll if
	 *         they are the same
	 */
	private static Team commongamesDiv(Team one, Team two) {
		int myWins = 0, myTies = 0, myLoss = 0, twosWins = 0, twosTies = 0, twosLoss = 0;
		for (int i = 0; i < one.played.size(); i++)
			for (int j = 0; j < two.played.size(); j++)
				if (one.played.get(i).equals(two.played.get(j))) {
					for (int w = 0; w < one.winTeams.size(); w++)
						if (one.played.get(i).equals(one.winTeams.get(w)))
							myWins++;
					for (int l = 0; l < one.lossTeams.size(); l++)
						if (one.played.get(i).equals(one.lossTeams.get(l)))
							myLoss++;
					for (int t = 0; t < one.tieTeams.size(); t++)
						if (one.played.get(i).equals(one.tieTeams.get(t)))
							myTies++;
					for (int w = 0; w < two.winTeams.size(); w++)
						if (one.played.get(i).equals(two.winTeams.get(w)))
							twosWins++;
					for (int l = 0; l < two.lossTeams.size(); l++)
						if (one.played.get(i).equals(two.lossTeams.get(l)))
							twosLoss++;
					for (int t = 0; t < two.tieTeams.size(); t++)
						if (one.played.get(i).equals(two.tieTeams.get(t)))
							twosTies++;
				}
		if (myWins > twosWins)
			return one;
		else if (twosWins > myWins)
			return two;
		else if (myTies > twosTies)
			return one;
		else if (twosTies > myTies)
			return two;
		else if (myLoss > twosLoss)
			return two;
		else if (twosLoss > myLoss)
			return one;
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
		else if (one.conferenceT != two.conferenceT)
			if (one.conferenceT > two.conferenceT)
				return one;
			else
				return two;
		else if (one.conferenceL != two.conferenceL)
			if (one.conferenceL > two.conferenceL)
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
	 * @return The Team that is ranked higher in the division
	 */
	private static Team compareToDiv(Team one, Team two) {
		if (winPercentage(one, two) != null)
			return winPercentage(one, two);
		else if (headTohead(one, two) != null)
			return headTohead(one, two);
		else if (divisionalPercentage(one, two) != null)
			return divisionalPercentage(one, two);
		else if (commongamesDiv(one, two) != null)
			return commongamesDiv(one, two);
		else if (conferencePercentage(one, two) != null)
			return conferencePercentage(one, two);
		else if (strengthOfVictory(one, two) != null)
			return strengthOfVictory(one, two);
		else if (strengthOfSchedule(one, two) != null)
			return strengthOfSchedule(one, two);
		else
			return strengthOfSchedule(one, two);
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
			else if (commongamesCon(one, two) != null)
				return commongamesCon(one, two);
			else if (strengthOfVictory(one, two) != null)
				return strengthOfVictory(one, two);
			else if (strengthOfSchedule(one, two) != null)
				return strengthOfSchedule(one, two);
			return one;
		}
	}

	/**
	 * 
	 * @param one
	 * @param two
	 * @return The team that has a better record in common games or null if they are
	 *         the same
	 */
	private static Team commongamesCon(Team one, Team two) {
		int myWins = 0, myTies = 0, myLoss = 0, othersWins = 0, othersTies = 0, othersLoss = 0;
		for (int i = 0; i < one.played.size(); i++)
			for (int j = 0; j < two.played.size(); j++)
				if (one.played.get(i).equals(two.played.get(j))) {
					for (int w = 0; w < one.winTeams.size(); w++)
						if (one.played.get(i).equals(one.winTeams.get(w)))
							myWins++;
					for (int l = 0; l < one.lossTeams.size(); l++)
						if (one.played.get(i).equals(one.lossTeams.get(l)))
							myLoss++;
					for (int t = 0; t < one.tieTeams.size(); t++)
						if (one.played.get(i).equals(one.tieTeams.get(t)))
							myTies++;
					for (int w = 0; w < two.winTeams.size(); w++)
						if (one.played.get(i).equals(two.winTeams.get(w)))
							othersWins++;
					for (int l = 0; l < two.lossTeams.size(); l++)
						if (one.played.get(i).equals(two.lossTeams.get(l)))
							othersLoss++;
					for (int t = 0; t < two.tieTeams.size(); t++)
						if (one.played.get(i).equals(two.tieTeams.get(t)))
							othersTies++;
				}
		if (myWins + myTies + myLoss > 4)
			return null;
		if (myWins > othersWins)
			return one;
		else if (othersWins > myWins)
			return two;
		else if (myTies > othersTies)
			return one;
		else if (othersTies > myTies)
			return two;
		else if (myLoss > othersLoss)
			return two;
		else if (othersLoss > myLoss)
			return one;
		else
			return null;
	}
	/**
	 * 
	 * @param other A List of teams that are tied If one team lost to all of the
	 *              others they will be removed from the list
	 */
	private static void headToHeadMultiple(ArrayList<Team> other) {
		int[] wins = new int[other.size()], ties = new int[other.size()], loss = new int[other.size()];
		for (int i = 0; i < other.size(); i++) {
			if (other.get(i).tieTeams == null) {
				other.get(i).tieTeams = new ArrayList<Team>();
				other.get(i).played = new ArrayList<Team>();
			}
			for (int j = 0; j < other.get(i).played.size(); j++) {
				if (other.contains(other.get(i).played.get(j))) {
					for (int w = 0; w < other.get(i).winTeams.size(); w++)
						if (other.contains(other.get(i).winTeams.get(w)))
							wins[i]++;
					for (int t = 0; t < other.get(i).tieTeams.size(); t++)
						if (other.contains(other.get(i).tieTeams.get(t)))
							ties[i]++;
					for (int l = 0; l < other.get(i).lossTeams.size(); l++)
						if (other.contains(other.get(i).lossTeams.get(l)))
							loss[i]++;
				}
			}
		}
		int highWins = 0, highTies = 0, lowLoss = 16;
		for (int i = 0; i < wins.length; i++) {
			if (wins[i] > highWins) {
				highWins = wins[i];
				highTies = ties[i];
				lowLoss = loss[i];
			} else if (wins[i] == highWins) {
				if (ties[i] > highTies) {
					highTies = ties[i];
					lowLoss = loss[i];
				} else if (ties[i] == highTies && loss[i] < lowLoss)
					lowLoss = loss[i];
			}
		}
		ArrayList<Integer> remove = new ArrayList<Integer>();
		for (int i = 0; i < other.size(); i++) {
			if (highWins > wins[i] || (highWins == wins[i] && highTies > ties[i])
					|| (highWins == wins[i] && highTies == ties[i] && lowLoss < loss[i])) {
				remove.add(i);
			}
		}
		for (int i = 0; i < remove.size(); i++) {
			other.remove((int) remove.get(i));
			for (int j = i; j < remove.size(); j++)
				remove.set(j, remove.get(j) - 1);
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
		headToHeadMultiple(other);
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
		commonGamesMultiple(other);
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
		strengthOfVictory(other);
		if (other.size() == 1)
			return other.get(0);
		if (other.size() == 2)
			if (compareToDiv(other.get(0), other.get(1)) == other.get(0))
				return other.get(0);
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
		int highestDivisionalW = 0, highestDivisionalT = 0, lowestDivisionalL = 16;
		for (int i = 0; i < other.size(); i++) {
			if (other.get(i).divisionalW > highestDivisionalW) {
				highestDivisionalW = other.get(i).divisionalW;
				highestDivisionalT = other.get(i).divisionalT;
				lowestDivisionalL = other.get(i).divisionalL;
			} else if (other.get(i).divisionalW == highestDivisionalW) {
				if (other.get(i).divisionalT > highestDivisionalT) {
					highestDivisionalT = other.get(i).divisionalT;
					lowestDivisionalL = other.get(i).divisionalL;
				} else if (other.get(i).divisionalT == highestDivisionalT
						&& other.get(i).divisionalL < lowestDivisionalL)
					lowestDivisionalL = other.get(i).divisionalL;
			}
		}
		ArrayList<Integer> remove = new ArrayList<Integer>();
		for (int i = 0; i < other.size(); i++) {
			if (other.get(i).divisionalW < highestDivisionalW
					|| other.get(i).divisionalW == highestDivisionalW && other.get(i).divisionalT < highestDivisionalT
					|| other.get(i).divisionalT == highestDivisionalT && other.get(i).divisionalL > lowestDivisionalL) {
				remove.add(i);
			}
		}
		for (int i = 0; i < remove.size(); i++) {
			other.remove((int) remove.get(i));
			for (int j = i; j < remove.size(); j++)
				remove.set(j, remove.get(j) - 1);
		}
	}
	/**
	 * 
	 * @param other A list of teams that are tied Removes all of the teams that
	 *              haven't done the best against common opponenets
	 */
	private static void commonGamesMultiple(ArrayList<Team> other) {
		ArrayList<Team> commonGames = new ArrayList<Team>();
		for (int i = 0; i < other.size(); i++) {
			for (int j = 0; j < other.get(i).played.size(); j++)
				for (int k = 0; k < other.size(); k++) {
					if (!other.get(k).played.contains(other.get(i).played.get(j)))
						k = 500;
					if (k == other.size() - 1)
						commonGames.add(other.get(i).played.get(j));
				}
		}
		int[] wins = new int[other.size()], losses = new int[other.size()], ties = new int[other.size()];
		int highW = 0, highT = 0, lowL = 16;
		for (int i = 0; i < commonGames.size(); i++)
			for (int j = 0; j < other.size(); j++) {
				if (other.get(j).winTeams.contains(commonGames.get(i)))
					wins[j]++;
				if (other.get(j).tieTeams.contains(commonGames.get(i)))
					ties[j]++;
				if (other.get(j).lossTeams.contains(commonGames.get(i)))
					losses[j]++;
			}
		for (int i = 0; i < wins.length; i++) {
			if (wins[i] > highW || (wins[i] == highW && ties[i] > highT)
					|| (wins[i] == highW && ties[i] == highT && losses[i] < lowL)) {
				highW = wins[i];
				highT = ties[i];
				lowL = losses[i];
			}
		}
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (int i = 0; i < other.size(); i++)
			if (wins[i] < highW || (wins[i] == highW && ties[i] < highT)
					|| (wins[i] == highW && ties[i] == highT && losses[i] > lowL))
				ints.add(i);
		for (int i = 0; i < ints.size(); i++) {
			other.remove((int) ints.get(i));
			for (int j = i; j < ints.size(); j++)
				ints.set(j, ints.get(j) - 1);
		}
	}

	/**
	 * 
	 * @param other A list of teams that are tied in the conference
	 * Removes all of the teams that dont have the best conference record
	 */
	private static void conPercentageMultiple(ArrayList<Team> other) {
		int highestWins = 0, highestTies = 0, lowestLosses = 16;
		for (int i = 0; i < other.size(); i++) {
			if (other.get(i).conferenceW > highestWins) {
				highestWins = other.get(i).conferenceW;
				highestTies = other.get(i).conferenceT;
				lowestLosses = other.get(i).conferenceL;
			} else if (other.get(i).conferenceW == highestWins) {
				if (other.get(i).conferenceT > highestTies) {
					highestTies = other.get(i).conferenceT;
					lowestLosses = other.get(i).conferenceL;
				} else if (other.get(i).conferenceT == highestTies && other.get(i).conferenceL < lowestLosses)
					lowestLosses = other.get(i).conferenceL;
			}
		}
		ArrayList<Integer> remove = new ArrayList<Integer>();
		for (int i = 0; i < other.size(); i++) {
			if (other.get(i).conferenceW < highestWins
					|| other.get(i).conferenceW == highestWins && other.get(i).ties < highestTies
					|| other.get(i).conferenceT == highestTies && other.get(i).conferenceL > lowestLosses)
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
	 * @param other A list of teams that are in the same conference but not the same division
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
		headToHeadMultiple(other);
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
		commonGamesMultipleCon(other);
		if (other.size() == 2) {
			return compareToCon(other.get(0), other.get(1));
		}
		strengthOfVictory(other);
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
	 * @param other A List of teams
	 * Removes all teams that don't have the best win Percentage
	 */
	private static void winPercentageMultiple(ArrayList<Team> other) {
		int highestWins = 0, highestTies = 0, lowestLosses = 16;
		for (int i = 0; i < other.size(); i++) {
			if (other.get(i).wins > highestWins) {
				highestWins = other.get(i).wins;
				highestTies = other.get(i).ties;
				lowestLosses = other.get(i).losses;
			} else if (other.get(i).wins == highestWins) {
				if (other.get(i).ties > highestTies) {
					highestTies = other.get(i).ties;
					lowestLosses = other.get(i).losses;
				} else if (other.get(i).ties == highestTies && other.get(i).losses < lowestLosses)
					lowestLosses = other.get(i).losses;
			}
		}
		ArrayList<Integer> remove = new ArrayList<Integer>();
		for (int i = 0; i < other.size(); i++)
			if (other.get(i).wins < highestWins || other.get(i).wins == highestWins && other.get(i).ties < highestTies
					|| other.get(i).ties == highestTies && other.get(i).losses > lowestLosses)
				remove.add(i);
		for (int i = 0; i < remove.size(); i++) {
			other.remove((int) remove.get(i));
			for (int j = i; j < remove.size(); j++)
				remove.set(j, remove.get(j) - 1);
		}
	}
	/**
	 * 
	 * @param other A list of teams that are tied
	 * Removes all teams that aren't the best against common opponents
	 */
	private static void commonGamesMultipleCon(ArrayList<Team> other) {
		ArrayList<Team> commonGames = new ArrayList<Team>();
		for (int i = 0; i < other.size(); i++) {
			for (int j = 0; j < other.get(i).played.size(); j++)
				for (int k = 0; k < other.size(); k++) {
					if (!other.get(k).played.contains(other.get(i).played.get(j)))
						k = 500;
					if (k == other.size() - 1)
						commonGames.add(other.get(i).played.get(j));
				}
		}
		int[] wins = new int[other.size()], losses = new int[other.size()], ties = new int[other.size()];
		int highW = 0, highT = 0, lowL = 16;
		if (commonGames.size() < 4)
			return;
		for (int i = 0; i < commonGames.size(); i++)
			for (int j = 0; j < other.size(); j++) {
				if (other.get(j).winTeams.contains(commonGames.get(i)))
					wins[j]++;
				if (other.get(j).tieTeams.contains(commonGames.get(i)))
					ties[j]++;
				if (other.get(j).lossTeams.contains(commonGames.get(i)))
					losses[j]++;
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
	 * @param other A list of teams that are tied
	 * Removes all teams that don't have the highest strength of victory
	 */
	private static void strengthOfVictory(ArrayList<Team> other) {
		int[] wins = new int[other.size()], ties = new int[other.size()], losses = new int[other.size()];
		int highW = 0, highT = 0, lowL = 16;
		for (int i = 0; i < wins.length; i++) {
			for (int j = 0; j < other.get(i).winTeams.size(); j++) {
				wins[i] += other.get(i).winTeams.get(j).wins;
				ties[i] += other.get(i).winTeams.get(j).ties;
				losses[i] += other.get(i).winTeams.get(j).ties;
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
	 * @param other A list of teams that are tied
	 * Removes the teams that haven't had the hardest season
	 */
	private static void strengthOfSchedule(ArrayList<Team> other) {
		int[] wins = new int[other.size()], ties = new int[other.size()], losses = new int[other.size()];
		int highW = 0, highT = 0, lowL = 16;
		for (int i = 0; i < wins.length; i++) {
			for (int j = 0; j < other.get(i).played.size(); j++) {
				wins[i] += other.get(i).played.get(j).wins;
				ties[i] += other.get(i).played.get(j).ties;
				losses[i] += other.get(i).played.get(j).ties;
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
	 * @return The team that has beaten teams with better records
	 */
	private static Team strengthOfVictory(Team one, Team two) {
		int wins1 = 0, ties1 = 0, losses1 = 0, wins2 = 0, ties2 = 0, losses2 = 0;
		for (int j = 0; j < one.winTeams.size(); j++) {
			wins1 += one.winTeams.get(j).wins;
			ties1 += one.winTeams.get(j).ties;
			losses1 += one.winTeams.get(j).ties;
		}
		for (int j = 0; j < two.winTeams.size(); j++) {
			wins2 += two.winTeams.get(j).wins;
			ties2 += two.winTeams.get(j).ties;
			losses2 += two.winTeams.get(j).ties;
		}
		if (wins1 > wins2 || wins1 == wins2 && ties1 > ties2 || wins1 == wins2 && ties1 == ties2 && losses1 < losses2) {
			return one;
		}
		if (wins2 > wins1 || wins2 == wins1 && ties2 > ties1 || wins2 == wins1 && ties2 == ties1 && losses2 < losses1) {
			return two;
		}
		return null;
	}
	/**
	 * 
	 * @param one
	 * @param two
	 * @return The team that has had a harder schedule
	 */
	private static Team strengthOfSchedule(Team one, Team two) {
		int wins1 = 0, ties1 = 0, losses1 = 0, wins2 = 0, ties2 = 0, losses2 = 0;
		for (int j = 0; j < one.played.size(); j++) {
			wins1 += one.played.get(j).wins;
			ties1 += one.played.get(j).ties;
			losses1 += one.played.get(j).ties;
		}
		for (int j = 0; j < two.played.size(); j++) {
			wins2 += two.played.get(j).wins;
			ties2 += two.played.get(j).ties;
			losses2 += two.played.get(j).ties;
		}
		if (wins1 > wins2 || wins1 == wins2 && ties1 > ties2 || wins1 == wins2 && ties1 == ties2 && losses1 < losses2) {
			return one;
		}
		if (wins2 > wins1 || wins2 == wins1 && ties2 > ties1 || wins2 == wins1 && ties2 == ties1 && losses2 < losses1) {
			return two;
		}
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
	 * @param stats The stats that are equivalent for this team
	 * Sets the FPI based off of the stats
	 */
	public void makeFPI(TeamStats stats) {
		stat = stats;
		// TODO: Make a FPI
	}

}
