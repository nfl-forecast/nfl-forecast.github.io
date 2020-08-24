package topLevel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import teamStructure.Team;

public class PlayoffCalc {
	private double[] natFinal, amerFinal, natConf, amerConf;
	private double[][] natWildCard, amerWildCard, natDivisional, amerDivisional;
	private double[][] percent;
	private Team[] teams;
	private DecimalFormat fmt;

	public PlayoffCalc(Team[] nat, Team[] amer) {
		teams = new Team[14];
		for (int i = 0; i < teams.length / 2; i++) {
			teams[i] = nat[i];
			teams[i + teams.length / 2] = amer[i];
		}

		fmt = new DecimalFormat("#.##");

		fillPercent();
	}

	public void calculate() {
		natConf = new double[teams.length / 2];
		amerConf = new double[teams.length / 2];

		// NATIONAL//

		// set up arrays for after wild card round
		natWildCard = new double[2][];
		natWildCard[0] = new double[teams.length / 2];
		natWildCard[1] = new double[teams.length / 2];
		for (int j = 0; j < teams.length / 2; j++) {
			natWildCard[0][j] = 0;
			natWildCard[1][j] = 0;
		}

		// first game of playoffs
		natWildCard[0][0] = 1;
		natWildCard[0][1] = 0;
		natWildCard[0][2] = 0;
		natWildCard[0][3] = percent[3][4] * percent[2][5] * percent[1][6];
		natWildCard[0][4] = percent[4][3] * percent[2][5] * percent[1][6];
		natWildCard[0][5] = percent[5][2] * percent[1][6];
		natWildCard[0][6] = percent[6][1];
		natWildCard[1][0] = 0;
		natWildCard[1][1] = percent[1][6];
		natWildCard[1][2] = percent[2][5];
		natWildCard[1][3] = percent[3][4] * (1 - (percent[2][5] * percent[1][6]));
		natWildCard[1][4] = percent[4][3] * (1 - (percent[2][5] * percent[1][6]));
		natWildCard[1][5] = percent[5][2] * percent[6][1];
		natWildCard[1][6] = 0;

		natDivisional = new double[2][];
		natDivisional[0] = new double[teams.length/2];
		natDivisional[1] = new double[teams.length/2];
		for (int i = 0; i < teams.length / 2; i++) {
			natDivisional[0][i] = 0;
			natDivisional[0][i] = 0;
		}
		for (int i = 1; i < teams.length / 2; i++) {
			natDivisional[0][0] += natWildCard[0][i] * percent[0][i];
			natDivisional[0][i] += natWildCard[0][i] * percent[i][0];
		}
		natDivisional[1][0] = 0;
		natDivisional[1][1] += (natWildCard[1][1])
				* ((natWildCard[1][2] * percent[1][2]) + (natWildCard[1][3] * percent[1][3])
						+ (natWildCard[1][4] * percent[1][4]) + (natWildCard[1][5] * percent[1][5]));
		natDivisional[1][2] += (natWildCard[1][2])
				* ((natWildCard[1][1] * percent[2][1]) + (natWildCard[1][3] * percent[2][3])
						+ (natWildCard[1][4] * percent[2][4]) + (natWildCard[1][6] * percent[2][6]));
		natDivisional[1][3] += (natWildCard[1][3])
				* ((natWildCard[1][1] * percent[3][1]) + (natWildCard[1][2] * percent[3][2])
						+ (natWildCard[1][5] * percent[3][5]) + (natWildCard[1][6] * percent[3][6]));
		natDivisional[1][4] += (natWildCard[1][4])
				* ((natWildCard[1][1] * percent[4][1]) + (natWildCard[1][2] * percent[4][2])
						+ (natWildCard[1][5] * percent[4][5]) + (natWildCard[1][6] * percent[4][6]));
		natDivisional[1][5] += (natWildCard[1][5])
				* ((natWildCard[1][1] * percent[5][1]) + (natWildCard[1][3] * percent[5][3])
						+ (natWildCard[1][4] * percent[5][4]) + (natWildCard[1][6] * percent[5][6]));
		natDivisional[1][6] += (natWildCard[1][6])
				* ((natWildCard[1][2] * percent[6][2]) + (natWildCard[1][3] * percent[6][3])
						+ (natWildCard[1][4] * percent[6][4]) + (natWildCard[1][5] * percent[6][5]));
		// third game
		natConf = new double[teams.length/2];
		natConf[0] = (percent[1][6] * (percent[2][5]
				* (percent[3][4] * percent[0][3] * (percent[1][2] * percent[0][1] + percent[2][1] * percent[0][2])
						+ percent[4][3] * percent[0][4]
								* (percent[1][2] * percent[0][1] + percent[2][1] * percent[0][2]))
				+ percent[5][2] * percent[0][5]
						* (percent[3][4] * (percent[1][3] * percent[0][1] + percent[3][1] * percent[0][3])
								+ percent[4][3] * (percent[1][4] * percent[0][1] + percent[4][1] * percent[0][4])))
				+ percent[6][1] * percent[0][6] * (percent[2][5]
						* (percent[3][4] * (percent[3][2] * percent[0][3] + percent[2][3] * percent[0][2])
								+ percent[4][3] * (percent[4][2] * percent[0][4] + percent[2][4] * percent[0][2]))
						+ percent[5][2] * (percent[3][4]
								* (percent[3][5] * percent[0][3] + percent[5][3] * percent[0][5])
								+ percent[4][3] * (percent[4][5] * percent[0][4] + percent[5][4] * percent[0][5]))));
		natConf[1] = percent[1][6] * (percent[2][5] * percent[1][2]
				* (percent[3][4] * (percent[0][3] * percent[1][0] + percent[3][0] * percent[1][3])
						+ percent[4][3] * (percent[0][4] * percent[1][0] + percent[4][0] * percent[1][4]))
				+ percent[5][2] * (percent[3][4] * percent[1][3]
						* (percent[0][5] * percent[1][0] + percent[5][0] * percent[1][5])
						+ percent[4][3] * percent[1][4]
								* (percent[0][5] * percent[1][0] + percent[5][0] * percent[1][5])));
		natConf[2] = percent[2][5] * (percent[1][6] * percent[2][1]
				* (percent[3][4] * (percent[0][3] * percent[2][0] + percent[3][0] * percent[2][3])
						+ percent[4][3] * (percent[0][4] * percent[2][0] + percent[4][0] * percent[2][4]))
				+ percent[6][1] * (percent[3][4] * percent[2][3]
						* (percent[0][6] * percent[2][0] + percent[6][0] * percent[2][6])
						+ percent[4][3] * percent[2][4]
								* (percent[0][6] * percent[2][0] + percent[6][0] * percent[2][6])));
		natConf[3] = percent[3][4] * (percent[1][6]
				* (percent[2][5] * percent[3][0] * (percent[1][2] * percent[3][1] + percent[2][1] * percent[3][2])
						+ percent[5][2] * percent[3][1]
								* (percent[0][5] * percent[3][0] + percent[5][0] * percent[3][5]))
				+ percent[6][1] * (percent[2][5] * percent[3][2]
						* (percent[0][6] * percent[3][0] + percent[6][0] * percent[3][6])
						+ percent[5][2] * percent[3][5]
								* (percent[0][6] * percent[3][0] + percent[6][0] * percent[3][6])));
		natConf[4] = percent[4][3] * (percent[1][6]
				* (percent[2][5] * percent[4][0] * (percent[1][2] * percent[4][1] + percent[2][1] * percent[4][2])
						+ percent[5][2] * percent[4][1]
								* (percent[0][5] * percent[4][0] + percent[5][0] * percent[4][5]))
				+ percent[6][1] * (percent[2][5] * percent[4][2]
						* (percent[0][6] * percent[4][0] + percent[6][0] * percent[4][6])
						+ percent[5][2] * percent[4][5]
								* (percent[0][6] * percent[4][0] + percent[6][0] * percent[4][6])));
		natConf[5] = percent[5][2] * (percent[1][6] * percent[5][0]
				* (percent[3][4] * (percent[1][3] * percent[5][1] + percent[3][1] * percent[5][3])
						+ percent[4][3] * (percent[1][4] * percent[5][1] + percent[4][1] * percent[5][4]))
				+ percent[6][1] * (percent[3][4] * percent[5][3]
						* (percent[0][6] * percent[5][0] + percent[6][0] * percent[5][6])
						+ percent[4][3] * percent[5][4]
								* (percent[0][6] * percent[5][0] + percent[6][0] * percent[5][6])));
		natConf[6] = percent[6][1] * percent[6][0] * (percent[2][5]
				* (percent[3][4] * (percent[2][3] * percent[6][2] + percent[3][2] * percent[6][3])
						+ percent[4][3] * (percent[2][4] * percent[6][2] + percent[4][2] * percent[6][4]))
				+ percent[5][2] * (percent[3][4] * (percent[3][5] * percent[6][3] + percent[5][3] * percent[6][5])
						+ percent[4][3] * (percent[4][5] * percent[6][4] + percent[5][4] * percent[6][5])));
		////////////////////////////////////////////////////////

		// AMERICAN//

		double[][] amerPerc = new double[teams.length/2][teams.length/2];
		for (int i = 0; i < 7; i++) {
			amerPerc[i] = new double[teams.length/2];
			for (int j = 0; j < 7; j++)
				amerPerc[i][j] = percent[i + 7][j + 7];
		}

		// set up arrays for after wild card round
		amerWildCard = new double[2][];
		amerWildCard[0] = new double[teams.length / 2];
		amerWildCard[1] = new double[teams.length / 2];
		for (int j = 0; j < teams.length / 2; j++) {
			amerWildCard[0][j] = 0;
			amerWildCard[1][j] = 0;
		}

		// first game of playoffs
		amerWildCard[0][0] = 1;
		amerWildCard[0][1] = 0;
		amerWildCard[0][2] = 0;
		amerWildCard[0][3] = amerPerc[3][4] * amerPerc[2][5] * amerPerc[1][6];
		amerWildCard[0][4] = amerPerc[4][3] * amerPerc[2][5] * amerPerc[1][6];
		amerWildCard[0][5] = amerPerc[5][2] * amerPerc[1][6];
		amerWildCard[0][6] = amerPerc[6][1];
		amerWildCard[1][0] = 0;
		amerWildCard[1][1] = amerPerc[1][6];
		amerWildCard[1][2] = amerPerc[2][5];
		amerWildCard[1][3] = amerPerc[3][4] * (1 - (amerPerc[2][5] * amerPerc[1][6]));
		amerWildCard[1][4] = amerPerc[4][3] * (1 - (amerPerc[2][5] * amerPerc[1][6]));
		amerWildCard[1][5] = amerPerc[5][2] * amerPerc[6][1];
		amerWildCard[1][6] = 0;

		amerDivisional = new double[2][];
		amerDivisional[0] = new double[teams.length/2];
		amerDivisional[1] = new double[teams.length/2];
		for (int i = 0; i < teams.length / 2; i++) {
			amerDivisional[0][i] = 0;
			amerDivisional[0][i] = 0;
		}
		for (int i = 1; i < teams.length / 2; i++) {
			amerDivisional[0][0] += amerWildCard[0][i] * amerPerc[0][i];
			amerDivisional[0][i] += amerWildCard[0][i] * amerPerc[i][0];
		}
		amerDivisional[1][0] = 0;
		amerDivisional[1][1] += (amerWildCard[1][1])
				* ((amerWildCard[1][2] * amerPerc[1][2]) + (amerWildCard[1][3] * amerPerc[1][3])
						+ (amerWildCard[1][4] * amerPerc[1][4]) + (amerWildCard[1][5] * amerPerc[1][5]));
		amerDivisional[1][2] += (amerWildCard[1][2])
				* ((amerWildCard[1][1] * amerPerc[2][1]) + (amerWildCard[1][3] * amerPerc[2][3])
						+ (amerWildCard[1][4] * amerPerc[2][4]) + (amerWildCard[1][6] * amerPerc[2][6]));
		amerDivisional[1][3] += (amerWildCard[1][3])
				* ((amerWildCard[1][1] * amerPerc[3][1]) + (amerWildCard[1][2] * amerPerc[3][2])
						+ (amerWildCard[1][5] * amerPerc[3][5]) + (amerWildCard[1][6] * amerPerc[3][6]));
		amerDivisional[1][4] += (amerWildCard[1][4])
				* ((amerWildCard[1][1] * amerPerc[4][1]) + (amerWildCard[1][2] * amerPerc[4][2])
						+ (amerWildCard[1][5] * amerPerc[4][5]) + (amerWildCard[1][6] * amerPerc[4][6]));
		amerDivisional[1][5] += (amerWildCard[1][5])
				* ((amerWildCard[1][1] * amerPerc[5][1]) + (amerWildCard[1][3] * amerPerc[5][3])
						+ (amerWildCard[1][4] * amerPerc[5][4]) + (amerWildCard[1][6] * amerPerc[5][6]));
		amerDivisional[1][6] += (amerWildCard[1][6])
				* ((amerWildCard[1][2] * amerPerc[6][2]) + (amerWildCard[1][3] * amerPerc[6][3])
						+ (amerWildCard[1][4] * amerPerc[6][4]) + (amerWildCard[1][5] * amerPerc[6][5]));
		// third game
		amerConf = new double[teams.length/2];
		amerConf[0] = (amerPerc[1][6] * (amerPerc[2][5]
				* (amerPerc[3][4] * amerPerc[0][3] * (amerPerc[1][2] * amerPerc[0][1] + amerPerc[2][1] * amerPerc[0][2])
						+ amerPerc[4][3] * amerPerc[0][4]
								* (amerPerc[1][2] * amerPerc[0][1] + amerPerc[2][1] * amerPerc[0][2]))
				+ amerPerc[5][2] * amerPerc[0][5]
						* (amerPerc[3][4] * (amerPerc[1][3] * amerPerc[0][1] + amerPerc[3][1] * amerPerc[0][3])
								+ amerPerc[4][3] * (amerPerc[1][4] * amerPerc[0][1] + amerPerc[4][1] * amerPerc[0][4])))
				+ amerPerc[6][1] * amerPerc[0][6] * (amerPerc[2][5]
						* (amerPerc[3][4] * (amerPerc[3][2] * amerPerc[0][3] + amerPerc[2][3] * amerPerc[0][2])
								+ amerPerc[4][3] * (amerPerc[4][2] * amerPerc[0][4] + amerPerc[2][4] * amerPerc[0][2]))
						+ amerPerc[5][2] * (amerPerc[3][4]
								* (amerPerc[3][5] * amerPerc[0][3] + amerPerc[5][3] * amerPerc[0][5])
								+ amerPerc[4][3] * (amerPerc[4][5] * amerPerc[0][4] + amerPerc[5][4] * amerPerc[0][5]))));
		amerConf[1] = amerPerc[1][6] * (amerPerc[2][5] * amerPerc[1][2]
				* (amerPerc[3][4] * (amerPerc[0][3] * amerPerc[1][0] + amerPerc[3][0] * amerPerc[1][3])
						+ amerPerc[4][3] * (amerPerc[0][4] * amerPerc[1][0] + amerPerc[4][0] * amerPerc[1][4]))
				+ amerPerc[5][2] * (amerPerc[3][4] * amerPerc[1][3]
						* (amerPerc[0][5] * amerPerc[1][0] + amerPerc[5][0] * amerPerc[1][5])
						+ amerPerc[4][3] * amerPerc[1][4]
								* (amerPerc[0][5] * amerPerc[1][0] + amerPerc[5][0] * amerPerc[1][5])));
		amerConf[2] = amerPerc[2][5] * (amerPerc[1][6] * amerPerc[2][1]
				* (amerPerc[3][4] * (amerPerc[0][3] * amerPerc[2][0] + amerPerc[3][0] * amerPerc[2][3])
						+ amerPerc[4][3] * (amerPerc[0][4] * amerPerc[2][0] + amerPerc[4][0] * amerPerc[2][4]))
				+ amerPerc[6][1] * (amerPerc[3][4] * amerPerc[2][3]
						* (amerPerc[0][6] * amerPerc[2][0] + amerPerc[6][0] * amerPerc[2][6])
						+ amerPerc[4][3] * amerPerc[2][4]
								* (amerPerc[0][6] * amerPerc[2][0] + amerPerc[6][0] * amerPerc[2][6])));
		amerConf[3] = amerPerc[3][4] * (amerPerc[1][6]
				* (amerPerc[2][5] * amerPerc[3][0] * (amerPerc[1][2] * amerPerc[3][1] + amerPerc[2][1] * amerPerc[3][2])
						+ amerPerc[5][2] * amerPerc[3][1]
								* (amerPerc[0][5] * amerPerc[3][0] + amerPerc[5][0] * amerPerc[3][5]))
				+ amerPerc[6][1] * (amerPerc[2][5] * amerPerc[3][2]
						* (amerPerc[0][6] * amerPerc[3][0] + amerPerc[6][0] * amerPerc[3][6])
						+ amerPerc[5][2] * amerPerc[3][5]
								* (amerPerc[0][6] * amerPerc[3][0] + amerPerc[6][0] * amerPerc[3][6])));
		amerConf[4] = amerPerc[4][3] * (amerPerc[1][6]
				* (amerPerc[2][5] * amerPerc[4][0] * (amerPerc[1][2] * amerPerc[4][1] + amerPerc[2][1] * amerPerc[4][2])
						+ amerPerc[5][2] * amerPerc[4][1]
								* (amerPerc[0][5] * amerPerc[4][0] + amerPerc[5][0] * amerPerc[4][5]))
				+ amerPerc[6][1] * (amerPerc[2][5] * amerPerc[4][2]
						* (amerPerc[0][6] * amerPerc[4][0] + amerPerc[6][0] * amerPerc[4][6])
						+ amerPerc[5][2] * amerPerc[4][5]
								* (amerPerc[0][6] * amerPerc[4][0] + amerPerc[6][0] * amerPerc[4][6])));
		amerConf[5] = amerPerc[5][2] * (amerPerc[1][6] * amerPerc[5][0]
				* (amerPerc[3][4] * (amerPerc[1][3] * amerPerc[5][1] + amerPerc[3][1] * amerPerc[5][3])
						+ amerPerc[4][3] * (amerPerc[1][4] * amerPerc[5][1] + amerPerc[4][1] * amerPerc[5][4]))
				+ amerPerc[6][1] * (amerPerc[3][4] * amerPerc[5][3]
						* (amerPerc[0][6] * amerPerc[5][0] + amerPerc[6][0] * amerPerc[5][6])
						+ amerPerc[4][3] * amerPerc[5][4]
								* (amerPerc[0][6] * amerPerc[5][0] + amerPerc[6][0] * amerPerc[5][6])));
		amerConf[6] = amerPerc[6][1] * amerPerc[6][0] * (amerPerc[2][5]
				* (amerPerc[3][4] * (amerPerc[2][3] * amerPerc[6][2] + amerPerc[3][2] * amerPerc[6][3])
						+ amerPerc[4][3] * (amerPerc[2][4] * amerPerc[6][2] + amerPerc[4][2] * amerPerc[6][4]))
				+ amerPerc[5][2] * (amerPerc[3][4] * (amerPerc[3][5] * amerPerc[6][3] + amerPerc[5][3] * amerPerc[6][5])
						+ amerPerc[4][3] * (amerPerc[4][5] * amerPerc[6][4] + amerPerc[5][4] * amerPerc[6][5])));
		////////////////////////////////////////////////////////

		// SUPERBOWL//
		natFinal = new double[teams.length / 2];
		amerFinal = new double[teams.length / 2];

		for (int i = 0; i < natFinal.length; i++) {
			double sumNat = 0, sumAmer = 0;
			// for nat comparing to amer
			for (int j = 0; j < natFinal.length; j++) {
				sumNat += amerConf[j] * percent[i][j + teams.length / 2];
			}
			natFinal[i] = sumNat * natConf[i];

			// for amer comparing to nat
			for (int j = 0; j < natFinal.length; j++) {
				sumAmer += natConf[j] * percent[i + teams.length / 2][j];
			}
			amerFinal[i] = sumAmer * amerConf[i];
		}
	}

	private void fillPercent() {
		// TODO: fix third game
		percent = new double[teams.length][teams.length];

		for (int i = 0; i < teams.length / 2; i++) {
			for (int j = i + 1; j < teams.length / 2; j++) {
				percent[i][j] = teams[i].calculate(teams[j]);
				percent[j][i] = 1 - percent[i][j];
			}
		}
		for (int i = teams.length / 2; i < teams.length; i++) {
			for (int j = i + 1; j < teams.length; j++) {
				percent[i][j] = teams[i].calculate(teams[j]);
				percent[j][i] = 1 - percent[i][j];
			}
		}
		for (int i = 0; i < teams.length / 2; i++) {
			for (int j = teams.length / 2; j < teams.length; j++) {
				percent[i][j] = teams[i].superBowl(teams[j]);
				percent[j][i] = 1 - percent[i][j];
			}
		}
		/*
		 * DecimalFormat fmt = new DecimalFormat("0.###"); for (double[] darray :
		 * percent) { for (double d : darray) { System.out.print(fmt.format(d) + "\t ");
		 * } System.out.println(); }
		 */
		/*
		 * double[][] p={{ 1,.80,.90,.70,.60,.50,.40,.30,.20,.10,.05,.90}, {.20,
		 * 1,.85,.75,.65,.55,.45,.35,.25,.15,.05,.02}, {.10,.15,
		 * 1,.60,.59,.49,.39,.29,.19,.09,.69,.79}, {.30,.25,.40,
		 * 1,.89,.99,.98,.88,.78,.68,.58,.48}, {.40,.35,.41,.11,
		 * 1,.38,.28,.18,.08,.97,.87,.77}, {.50,.45,.51,.01,.62,
		 * 1,.67,.57,.47,.37,.27,.17}, {.60,.55,.61,.02,.72,.33, 1,.07,.96,.76,.86,.66},
		 * {.70,.65,.71,.12,.82,.43,.93, 1,.56,.46,.36,.26},
		 * {.80,.75,.81,.22,.92,.53,.04,.44, 1,.16,.06,.94},
		 * {.90,.85,.91,.32,.03,.63,.24,.54,.84, 1,.95,.55},
		 * {.95,.95,.31,.42,.13,.73,.14,.64,.94,.05, 1,.50},
		 * {.10,.98,.21,.52,.23,.83,.34,.74,.06,.45,.50, 1}};
		 * 
		 * percent = p;
		 */
	}
	/*
	 * public static void main(String args[]) { Team[] nat = { new
	 * Team("New England Patriots", new Color(12, 35, 64), new Color(162, 170,
	 * 173)), new Team("New York Jets", new Color(12, 55, 29), new Color(255, 255,
	 * 255)), new Team("Buffalo Bills", new Color(12, 46, 130), new Color(255, 0,
	 * 0)), new Team("Miami Dolphins", new Color(0, 142, 151), new Color(255, 255,
	 * 255)), new Team("Houston Texans", new Color(9, 31, 44), new Color(255, 0,
	 * 0)), new Team("Indianapolis Colts", new Color(0, 20, 137), new Color(255,
	 * 255, 255)) };
	 * 
	 * Team[] amer = { new Team("Green Bay Packers", new Color(23, 94, 34), new
	 * Color(255, 184, 28)), new Team("Detroit Lions", new Color(0, 105, 177), new
	 * Color(162, 170, 173)), new Team("Chicago Bears", new Color(5, 28, 44), new
	 * Color(220, 68, 5)), new Team("Minnesota Vikings", new Color(84, 41, 109), new
	 * Color(255, 184, 28)), new Team("Washington Redskins", new Color(134, 38, 51),
	 * new Color(255, 205, 0)), new Team("Dallas Cowboys", new Color(4, 30, 66), new
	 * Color(134, 147, 151)) };
	 * 
	 * PlayoffCalc p = new PlayoffCalc(nat, amer); p.calculate();
	 * 
	 * System.out.println();
	 * 
	 * // for(int i = 0;i < 12;i++) // { // for(int j = 0;j < 12;j++) //
	 * System.out.print(p.percent[i][j] + " "); // System.out.println(); // } //
	 * System.out.println();
	 * 
	 * for (int i = 0; i < 6; i++) System.out.println(p.natFinal[i]); for (int i =
	 * 0; i < 6; i++) System.out.println(p.amerFinal[i]);
	 * 
	 * double sum = 0; for (int i = 0; i < 6; i++) sum += (p.natFinal[i] +
	 * p.amerFinal[i]); System.out.println(sum); }
	 */

	public List<Integer> getFPI() {
		List<Integer> FPIlist = new ArrayList<Integer>();
		for (int i = 0; i < teams.length / 2; i++)
			FPIlist.add((int) (Math.round(teams[i].getFPI())));
		for (int i = teams.length / 2; i < teams.length; i++)
			FPIlist.add((int) (Math.round(teams[i].getFPI())));
		return FPIlist;
	}

	public List<String> getAFCwildCard() {
		List<String> doubleList = new ArrayList<String>();
		for (int i = 0; i < teams.length / 2; i++)
			doubleList.add(fmt.format(100 * (amerWildCard[0][i] + amerWildCard[1][i])));
		return doubleList;
	}

	public List<String> getAFCdivisional() {
		List<String> doubleList = new ArrayList<String>();
		for (int i = 0; i < teams.length / 2; i++)
			doubleList.add(fmt.format(100 * (amerDivisional[0][i] + amerDivisional[1][i])));
		return doubleList;
	}

	public List<String> getAFCconference() {
		List<String> doubleList = new ArrayList<String>();
		for (int i = 0; i < teams.length / 2; i++)
			doubleList.add(fmt.format(100 * amerConf[i]));
		return doubleList;
	}

	public List<String> getNFCwildCard() {
		List<String> doubleList = new ArrayList<String>();
		for (int i = 0; i < teams.length / 2; i++)
			doubleList.add(fmt.format(100 * (natWildCard[0][i] + natWildCard[1][i])));
		return doubleList;
	}

	public List<String> getNFCdivisional() {
		List<String> doubleList = new ArrayList<String>();
		for (int i = 0; i < teams.length / 2; i++)
			doubleList.add(fmt.format(100 * (natDivisional[0][i] + natDivisional[1][i])));
		return doubleList;
	}

	public List<String> getNFCconference() {
		List<String> doubleList = new ArrayList<String>();
		for (int i = 0; i < teams.length / 2; i++)
			doubleList.add(fmt.format(natConf[i] * 100));
		return doubleList;
	}

	public List<String> getSuperBowl() {
		List<String> doubleList = new ArrayList<String>();
		for (int i = 0; i < teams.length / 2; i++) {
			doubleList.add(fmt.format(natFinal[i] * 100));
		}
		for (int i = 0; i < teams.length / 2; i++) {
			doubleList.add(fmt.format(amerFinal[i] * 100));
		}
		return doubleList;
	}

	public List<String> getNFCTeams() {
		List<String> teamName = new ArrayList<String>();
		for (int i = 0; i < teams.length / 2; i++) {
			teamName.add(teams[i].getName());
		}
		return teamName;
	}

	public List<String> getAFCTeams() {
		List<String> teamName = new ArrayList<String>();
		for (int i = teams.length / 2; i < teams.length; i++) {
			teamName.add(teams[i].getName());
		}
		return teamName;
	}

	public static double[][] makeFullPercents(Team[] teams) {
		double[][] percents = new double[32][32];
		for (int i = 0; i < 32; i++)
			for (int j = i + 1; j < 32; j++) {
				double percent = teams[i].superBowl(teams[j]);
				percents[i][j] = percent;
				percents[j][i] = 1 - percent;
			}
		return percents;
	}

}
