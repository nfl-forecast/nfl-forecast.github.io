package topLevel;

import java.util.ArrayList;
import java.util.List;

import teamStructure.Team;

public class PlayoffCalc{
	private double[] natFinal, amerFinal, natConf, amerConf;
	private double[][] natWildCard, natDivisional, amerWildCard, amerDivisional;
	private double[][] percent;
	private Team[] teams;

	public PlayoffCalc(Team[] nat, Team[] amer) {
		teams = new Team[12];
		for (int i = 0; i < 6; i++) {
			teams[i] = nat[i];
			teams[i + 6] = amer[i];
		}

		fillPercent();
	}

	public void calculate() {
		natConf = new double[6];
		amerConf = new double[6];

		// NATIONAL//

		// set up arrays for after wild card round
		natWildCard = new double[2][];
		natWildCard[0] = new double[6];
		natWildCard[1] = new double[6];
		for (int j = 0; j < 6; j++) {
			natWildCard[0][j] = 0;
			natWildCard[1][j] = 0;
		}

		// first game of playoffs
		natWildCard[0][0] = 1;
		natWildCard[1][1] = 1;
		natWildCard[0][3] = percent[3][4] * percent[2][5];
		natWildCard[0][4] = percent[4][3] * percent[2][5];
		natWildCard[0][5] = percent[5][2];
		natWildCard[1][3] = percent[3][4] * percent[5][2];
		natWildCard[1][4] = percent[4][3] * percent[5][2];
		natWildCard[1][2] = percent[2][5];

		// set up arrays for after wild card round
		natDivisional = new double[2][];
		natDivisional[0] = new double[6];
		natDivisional[1] = new double[6];
		for (int j = 0; j < 6; j++) {
			natDivisional[0][j] = 0;
			natDivisional[1][j] = 0;
		}

		// second game
		double sum1 = 0, sum2 = 0;
		for (int j = 2; j < 6; j++) {
			// System.out.println(percent[0][j] * left[j]);
			sum1 += percent[0][j] * natWildCard[0][j];
			sum2 += percent[1][j] * natWildCard[1][j];
		}
		
		natDivisional[0][0] = sum1;//team 1
		natDivisional[0][3] = percent[3][0] * natWildCard[0][3];//team 4
		natDivisional[0][4] = percent[4][0] * natWildCard[0][4];//team 5
		natDivisional[0][5] = percent[5][0] * natWildCard[0][5];//team 6
		natDivisional[1][1] = sum2;//team 2
		natDivisional[1][2] = percent[2][1] * natWildCard[1][2];//team 3
		natDivisional[1][3] = percent[3][1] * natWildCard[1][3];//team 4
		natDivisional[1][4] = percent[4][1] * natWildCard[1][4];//team 5

		
		// third game
		//prob with 1st or 2nd seed(0 or 1)
		natConf[0] = (natWildCard[1][3] * percent[0][5] * ((percent[1][3] * percent[0][1]) + (percent[3][1] * percent[0][3])))
				+ (natWildCard[1][4] * percent[0][5] * ((percent[1][4] * percent[0][1]) + (percent[4][1] * percent[0][4])))
				+ (natWildCard[0][3] * percent[0][3] * ((percent[1][2] * percent[0][1]) + (percent[2][1] * percent[0][2])))
				+ (natWildCard[0][4] * percent[0][4] * ((percent[1][2] * percent[0][1]) + (percent[2][1] * percent[0][2])));
		natConf[1] = (percent[1][2] * (natWildCard[0][3] * ((percent[0][3] * percent[1][0]) + (percent[3][0] * percent[1][3]))+ (natWildCard[0][4]) * ((percent[0][4]) * percent[1][0]) + (percent[4][0] * percent[0][4])))
				+ ((percent[0][5] * percent[1][0] + percent[5][0] * percent[1][5])* (natWildCard[1][3] * percent[1][3] + natWildCard[1][4] * percent[1][4]));
		natConf[2] = natDivisional[1][2]
				* (percent[3][4] * (percent[0][3] * percent[2][0] + percent[3][0] * percent[2][3])
						+ percent[4][3] * (percent[0][4] * percent[2][0] + percent[4][0] * percent[2][4]));
		natConf[3] = natDivisional[1][3] * (percent[0][5] * percent[3][0] + percent[5][0] * percent[3][5])
				+ natDivisional[0][3] * (percent[1][2] * percent[3][1] + percent[2][1] * percent[3][2]);
		natConf[4] = natDivisional[1][4] * ((percent[0][5] * percent[4][0]) + (percent[5][0] * percent[4][5]))
				+ (natDivisional[0][4] * ((percent[1][2] * percent[4][1]) + (percent[2][1] * percent[4][2])));
		natConf[5] = natDivisional[0][5]
				* ((percent[3][4] * (percent[1][3] * percent[5][1] + percent[3][1] * percent[5][3]))
						+ (percent[4][3] * (percent[1][4] * percent[5][1] + percent[4][1] * percent[5][4])));
		////////////////////////////////////////////////////////

		
		// AMERICAN//

		
		// set up arrays for after wild card round
		double[][] amerPerc = new double[6][6];
		amerWildCard = new double[2][];
		amerWildCard[0] = new double[6];
		amerWildCard[1] = new double[6];
		for (int j = 0; j < 6; j++) {
			amerWildCard[0][j] = 0;
			amerWildCard[1][j] = 0;
		}
		
		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 6; j++)
				amerPerc[i][j] = percent[i+6][j+6];

		// first game of playoffs
		amerWildCard[0][0] = 1;
		amerWildCard[1][1] = 1;
		amerWildCard[0][3] = amerPerc[3][4] * amerPerc[2][5];
		amerWildCard[0][4] = amerPerc[4][3] * amerPerc[2][5];
		amerWildCard[0][5] = amerPerc[5][2];
		amerWildCard[1][3] = amerPerc[3][4] * amerPerc[5][2];
		amerWildCard[1][4] = amerPerc[4][3] * amerPerc[5][2];
		amerWildCard[1][2] = amerPerc[2][5];


		// set up arrays for after divisional round
		amerDivisional = new double[2][];
		amerDivisional[0] = new double[6];
		amerDivisional[1] = new double[6];
		for (int j = 0; j < 6; j++) {
			amerDivisional[0][j] = 0;
			amerDivisional[1][j] = 0;
		}

		// second game
		sum1 = 0;
		sum2 = 0;
		for (int j = 2; j < 6; j++) {
			sum1 += amerPerc[0][j] * amerWildCard[0][j];
			sum2 += amerPerc[1][j] * amerWildCard[1][j];
		}
		
		amerDivisional[0][0] = sum1;
		amerDivisional[0][3] = amerPerc[3][0] * amerWildCard[0][3];
		amerDivisional[0][4] = amerPerc[4][0] * amerWildCard[0][4];
		amerDivisional[0][5] = amerPerc[5][0] * amerWildCard[0][5];
		amerDivisional[1][1] = sum2;
		amerDivisional[1][2] = amerPerc[2][1] * amerWildCard[1][2];
		amerDivisional[1][3] = amerPerc[3][1] * amerWildCard[1][3];
		amerDivisional[1][4] = amerPerc[4][1] * amerWildCard[1][4];
		

		// third game
		amerConf[0] = amerWildCard[1][3] * (amerPerc[0][5])
				* ((amerPerc[1][3] * amerPerc[0][1]) + amerPerc[3][1] * amerPerc[0][3])
				+ amerWildCard[1][4] * (amerPerc[0][5])
						* ((amerPerc[1][4] * amerPerc[0][1]) + (amerPerc[4][1] * amerPerc[0][4]))
				+ amerWildCard[0][3] * amerPerc[0][3] * (amerPerc[1][2] * amerPerc[0][1] + amerPerc[2][1] * amerPerc[0][2])
				+ amerWildCard[0][4] * amerPerc[0][4] * (amerPerc[1][2] * amerPerc[0][1] + amerPerc[2][1] * amerPerc[0][2]);
		amerConf[1] = amerPerc[1][2]
				* (amerWildCard[0][3] * ((amerPerc[0][3] * amerPerc[1][0]) + (amerPerc[3][0] * amerPerc[1][3]))
						+ (amerWildCard[0][4]) * ((amerPerc[0][4]) * amerPerc[1][0]) + (amerPerc[4][0] * amerPerc[0][4]))
				+ (amerPerc[0][5] * amerPerc[1][0] + amerPerc[5][0] * amerPerc[1][5])
						* (amerWildCard[1][3] * amerPerc[1][3] + amerWildCard[1][4] * amerPerc[1][4]);
		amerConf[2] = amerDivisional[1][2]
				* (amerPerc[3][4] * (amerPerc[0][3] * amerPerc[2][0] + amerPerc[3][0] * amerPerc[2][3])
						+ amerPerc[4][3] * (amerPerc[0][4] * amerPerc[2][0] + amerPerc[4][0] * amerPerc[2][4]));
		amerConf[3] = amerDivisional[1][3] * (amerPerc[0][5] * amerPerc[3][0] + amerPerc[5][0] * amerPerc[3][5])
				+ amerDivisional[0][3] * (amerPerc[1][2] * amerPerc[3][1] + amerPerc[2][1] * amerPerc[3][2]);
		amerConf[4] = amerDivisional[1][4] * (amerPerc[0][5] * amerPerc[4][0] + amerPerc[5][0] * amerPerc[4][5])
				+ amerDivisional[0][4] * (amerPerc[1][2] * amerPerc[4][1] + amerPerc[2][1] * amerPerc[4][2]);
		amerConf[5] = amerDivisional[0][5]
				* (amerPerc[3][4] * (amerPerc[1][3] * amerPerc[5][1] + amerPerc[3][1] * amerPerc[5][3])
						+ amerPerc[4][3] * (amerPerc[1][4] * amerPerc[5][1] + amerPerc[4][1] * amerPerc[5][4]));
		////////////////////////////////////////////////////////


		// SUPERBOWL//
		natFinal = new double[6];
		amerFinal = new double[6];

		
		for (int i = 0; i < natFinal.length; i++) {
			double sumNat = 0, sumAmer = 0;
			// for nat comparing to amer
			for (int j = 0; j < natFinal.length; j++) {
				sumNat += amerConf[j] * percent[i][j + 6];
			}
			natFinal[i] = sumNat * natConf[i];

			// for amer comparing to nat
			for (int j = 0; j < natFinal.length; j++) {
				sumAmer += natConf[j] * percent[i + 6][j];
			}
			amerFinal[i] = sumAmer * amerConf[i];
		}
		double sum = 0;
		for (int i = 0; i < 6; i++)
			sum += (natFinal[i] + amerFinal[i]);
		for(int i = 0; i < 6; i++)
		{
			natFinal[i] /= sum;
			amerFinal[i] /= sum;
		}
		sum = 0;
		for (int i = 0; i < 6; i++)
			sum += (natFinal[i] + amerFinal[i]);
	}

	private void fillPercent() {
		// TODO: fix third game
		percent = new double[12][12];

		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				percent[i][j] = teams[i].calculate(teams[j]);
				percent[j][i] = 1 - percent[i][j];
			}
		}
		for (int i = 6; i < 12; i++) {
			for (int j = i + 1; j < 12; j++) {
				percent[i][j] = teams[i].calculate(teams[j]);
				percent[j][i] = 1 - percent[i][j];
			}
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 6; j < 12; j++) {
				percent[i][j] = teams[i].superBowl(teams[j]);
				percent[j][i] = 1 - percent[i][j];
			}
		}
		/*DecimalFormat fmt = new DecimalFormat("0.###");
		for (double[] darray : percent) {
			for (double d : darray) {
				System.out.print(fmt.format(d) + "\t ");
			}
			System.out.println();
		}*/
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
	public static void main(String args[]) {
		Team[] nat = { new Team("New England Patriots", new Color(12, 35, 64), new Color(162, 170, 173)),
				new Team("New York Jets", new Color(12, 55, 29), new Color(255, 255, 255)),
				new Team("Buffalo Bills", new Color(12, 46, 130), new Color(255, 0, 0)),
				new Team("Miami Dolphins", new Color(0, 142, 151), new Color(255, 255, 255)),
				new Team("Houston Texans", new Color(9, 31, 44), new Color(255, 0, 0)),
				new Team("Indianapolis Colts", new Color(0, 20, 137), new Color(255, 255, 255)) };

		Team[] amer = { new Team("Green Bay Packers", new Color(23, 94, 34), new Color(255, 184, 28)),
				new Team("Detroit Lions", new Color(0, 105, 177), new Color(162, 170, 173)),
				new Team("Chicago Bears", new Color(5, 28, 44), new Color(220, 68, 5)),
				new Team("Minnesota Vikings", new Color(84, 41, 109), new Color(255, 184, 28)),
				new Team("Washington Redskins", new Color(134, 38, 51), new Color(255, 205, 0)),
				new Team("Dallas Cowboys", new Color(4, 30, 66), new Color(134, 147, 151)) };

		PlayoffCalc p = new PlayoffCalc(nat, amer);
		p.calculate();

		System.out.println();

		// for(int i = 0;i < 12;i++)
		// {
		// for(int j = 0;j < 12;j++)
		// System.out.print(p.percent[i][j] + " ");
		// System.out.println();
		// }
		// System.out.println();

		for (int i = 0; i < 6; i++)
			System.out.println(p.natFinal[i]);
		for (int i = 0; i < 6; i++)
			System.out.println(p.amerFinal[i]);

		double sum = 0;
		for (int i = 0; i < 6; i++)
			sum += (p.natFinal[i] + p.amerFinal[i]);
		System.out.println(sum);
	}*/
	
	public List<Double> getAFCwildCard()
	{
		List<Double> doubleList = new ArrayList<Double>();
		for(int i = 0; i < 6; i++)
			doubleList.add(amerWildCard[0][i]+amerWildCard[1][i]);
		return doubleList;
	}
	public List<Double> getAFCdivisional()
	{
		List<Double> doubleList = new ArrayList<Double>();
		for(int i = 0; i < 6; i++)
			doubleList.add(amerDivisional[0][i]+amerDivisional[1][i]);
		return doubleList;
	}
	public List<Double> getAFCconference()
	{
		List<Double> doubleList = new ArrayList<Double>();
		for(int i = 0; i < 6; i++)
			doubleList.add(amerConf[i]);
		return doubleList;
	}
	public List<Double> getNFCwildCard()
	{
		List<Double> doubleList = new ArrayList<Double>();
		for(int i = 0; i < 6; i++)
			doubleList.add(natWildCard[0][i]+natWildCard[1][i]);
		return doubleList;
	}
	public List<Double> getNFCdivisional()
	{
		List<Double> doubleList = new ArrayList<Double>();
		for(int i = 0; i < 6; i++)
			doubleList.add(natDivisional[0][i]+natDivisional[1][i]);
		return doubleList;
	}
	public List<Double> getNFCconference()
	{
		List<Double> doubleList = new ArrayList<Double>();
		for(int i = 0; i < 6; i++)
			doubleList.add(natConf[i]);
		return doubleList;
	}
	public List<Double> getSuperBowl()
	{
		List<Double> doubleList = new ArrayList<Double>();
		for(int i = 0; i < 6; i++)
		{
			doubleList.add(amerFinal[i]);
		}
		for(int i = 0; i < 6; i++)
		{
			doubleList.add(natFinal[i]);
		}
		return doubleList;
	}
	
	public List<String> getNFCTeams()
	{
		List<String> teamName = new ArrayList<String>();
		for(int i = 0; i < 6; i++)
		{
			teamName.add(teams[i].name);
		}
		return teamName;
	}
	public List<String> getAFCTeams()
	{
		List<String> teamName = new ArrayList<String>();
		for(int i = 6; i < 12; i++)
		{
			teamName.add(teams[i].name);
		}
		return teamName;
	}
}
