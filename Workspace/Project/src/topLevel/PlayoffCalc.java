package topLevel;

import java.awt.Color;

import teamStructure.Team;

public class PlayoffCalc 
{
	private double[] natFinal, amerFinal;
	private double[][] percent;
	private Team[] teams;

	public PlayoffCalc(Team[] nat, Team[] amer) 
	{
		teams = new Team[12];
		for(int i = 0;i < 6;i++)
		{
			teams[i] = nat[i];
			teams[i + 6] = amer[i];
		}
		
		fillPercent();
	}

	public void calculate()
	{
		double[] natPerc = new double[6];
		double[] amerPerc = new double[6];

		//NATIONAL//
		
		//set up arrays for either side
		double[] left = new double[6], right = new double[6];
		for(int j = 0;j < 6;j++)
		{
			left[j] = 0;
			right[j] = 0;
		}
		
		//first game of playoffs
		left[0] = 1;
		right[1] = 1;
		left[3] = percent[3][4] * percent[2][5];
		left[4] = percent[4][3] * percent[2][5];
		left[5] = percent[5][2];
		right[3] = percent[3][4] * percent[5][2];
		right[4] = percent[4][3] * percent[5][2];
		right[2] = percent[2][5];
		
//		for(int i = 0;i < left.length;i++)
//		{
//			System.out.println(left[i] + " " + right[i]);
//		}
//		System.out.println(); 
		
		//second game
		double sum1 = 0, sum2 = 0;
		for(int j = 2;j < 6;j++)
		{
			//System.out.println(percent[0][j] * left[j]);
			sum1 += percent[0][j] * left[j];
			sum2 += percent[1][j] * right[j];
		}
		System.out.println();
		left[0] = sum1;
		left[3] = percent[3][0] * left[3];
		left[4] = percent[4][0] * left[4];
		left[5] = percent[5][0] * left[5];
		right[1] = sum2;
		right[2] = percent[2][1] * right[2];
		right[3] = percent[3][1] * right[3];
		right[4] = percent[4][1] * right[4];
		
		for(int i = 0;i < left.length;i++)
		{
			System.out.println(left[i] + " " + right[i]);
		}
		System.out.println();
		
		//third game
		for(int j = 0;j < 6;j++)
		{
			double sumLeft = 0;
			double sumRight = 0;
			
			for(int k = 0;k < 6;k++)
				if(j * k != 20 && j * k != 18 && j * k != 6)
					sumLeft += percent[j][k] * right[k];
			sumLeft *= left[j];
			
			for(int k = 0;k < 6;k++)
				if(j * k != 20 && j * k != 18 && j * k != 6)
					sumRight += percent[j][k] * left[k];
			sumLeft *= right[j];
			
			natPerc[j] = sumLeft + sumRight;
		}
		////////////////////////////////////////////////////////
		
		for(int i = 0;i < amerPerc.length;i++)
		{
			System.out.println(natPerc[i] + " " + amerPerc[i]);
		}
		System.out.println();
		
		//AMERICAN//
		
		//set up arrays for either side
		left = new double[6]; 
		right = new double[6];
		for(int j = 0;j < 6;j++)
		{
			left[j] = 0;
			right[j] = 0;
		}
		
		//first game of playoffs
		left[0] = 1;
		right[1] = 1;
		left[3] = percent[9][10] * percent[8][11];
		left[4] = percent[10][9] * percent[8][11];
		left[5] = percent[11][8];
		right[3] = percent[9][10] * percent[11][8];
		right[4] = percent[10][9] * percent[11][8];
		right[2] = percent[8][11];
		
		//second game
		sum1 = 0; 
		sum2 = 0;
		for(int j = 2;j < 6;j++)
		{
			sum1 += percent[6][j + 6] * left[j];
			sum2 += percent[7][j + 6] * right[j];
		}
		left[0] = sum1;
		left[3] = percent[9][6] * left[3];
		left[4] = percent[10][6] * left[4];
		left[5] = percent[11][6] * left[5];
		right[1] = sum2;
		right[2] = percent[8][7] * right[2];
		right[3] = percent[9][7] * right[3];
		right[4] = percent[10][7] * right[4];
		
		//third game
		for(int j = 0;j < 6;j++)
		{
			double sumLeft = 0;
			double sumRight = 0;
			
			for(int k = 0;k < 6;k++)
				if(j * k != 20 && j * k != 18)
					sumLeft += percent[j + 6][k + 6] * right[k];
			sumLeft *= left[j];
			
			for(int k = 0;k < 6;k++)
				if(j * k != 20 && j * k != 18)
					sumRight += percent[j + 6][k + 6] * left[k];
			sumLeft *= right[j];
			
			amerPerc[j] = sumLeft + sumRight;
		}
		///////////////////////////////////////////////////////////
		
		for(int i = 0;i < amerPerc.length;i++)
		{
			System.out.println(natPerc[i] + " " + amerPerc[i]);
		}
		System.out.println();
		
		//SUPERBOWL//
		natFinal = new double[6];
		amerFinal = new double[6];
		for(int i = 0;i < natFinal.length;i++)
		{
			double sumNat = 0, sumAmer = 0;
			//for nat comparing to amer
			for(int j = 0;j < natFinal.length;j++)
			{
				sumNat += amerPerc[j] * percent[i][j + 6];
			}
			natFinal[i] = sumNat * natPerc[i];
			
			//for amer comparing to nat
			for(int j = 0;j < natFinal.length;j++)
			{
				sumAmer += natPerc[j] * percent[i + 6][j];
			}
			amerFinal[i] = sumAmer * amerPerc[i];
		}
	}
	
	private void fillPercent()
	{
		
		//percent = new double[12][12];
		/*
		for(int i = 0;i < 12;i++)
		{
			for(int j = 0;j < 12;j++)
			{
				percent[i][j] = teams[i].calculate(teams[j]);
			}
		}*/
		
		double[][] p={{ 1,.80,.90,.70,.60,.50,.40,.30,.20,.10,.05,.90},
				{.20,  1,.85,.75,.65,.55,.45,.35,.25,.15,.05,.02},
				{.10,.15,  1,.60,.59,.49,.39,.29,.19,.09,.69,.79},
				{.30,.25,.40,  1,.89,.99,.98,.88,.78,.68,.58,.48},
				{.40,.35,.41,.11,  1,.38,.28,.18,.08,.97,.87,.77},
				{.50,.45,.51,.01,.62,  1,.67,.57,.47,.37,.27,.17},
				{.60,.55,.61,.02,.72,.33,  1,.07,.96,.76,.86,.66},
				{.70,.65,.71,.12,.82,.43,.93,  1,.56,.46,.36,.26},
				{.80,.75,.81,.22,.92,.53,.04,.44,  1,.16,.06,.94},
				{.90,.85,.91,.32,.03,.63,.24,.54,.84,  1,.95,.55},
				{.95,.95,.31,.42,.13,.73,.14,.64,.94,.05,  1,.50},
				{.10,.98,.21,.52,.23,.83,.34,.74,.06,.45,.50,  1}};
		
		percent = p;
		
	}
	
	public static void main(String args[])
	{
		Team[] nat = {new Team("New England Patriots", new Color(12, 35, 64), new Color(162, 170, 173)),
				new Team("New York Jets", new Color(12, 55, 29), new Color(255, 255, 255)),
				new Team("Buffalo Bills", new Color(12, 46, 130), new Color(255, 0, 0)),
				new Team("Miami Dolphins", new Color(0, 142, 151), new Color(255, 255, 255)),
				new Team("Houston Texans", new Color(9, 31, 44), new Color(255, 0, 0)),
				new Team("Indianapolis Colts", new Color(0, 20, 137), new Color(255, 255, 255))};
		
		Team[] amer = {new Team("Green Bay Packers", new Color(23, 94, 34), new Color(255, 184, 28)),
				new Team("Detroit Lions", new Color(0, 105, 177), new Color(162, 170, 173)),
				new Team("Chicago Bears", new Color(5, 28, 44), new Color(220, 68, 5)),
				new Team("Minnesota Vikings", new Color(84, 41, 109), new Color(255, 184, 28)),
				new Team("Washington Redskins", new Color(134, 38, 51), new Color(255, 205, 0)),
				new Team("Dallas Cowboys", new Color(4, 30, 66), new Color(134, 147, 151))};
		
		PlayoffCalc p = new PlayoffCalc(nat, amer);
		p.calculate();
		
		System.out.println();
		
//		for(int i = 0;i < 12;i++)
//		{
//			for(int j = 0;j < 12;j++)
//				System.out.print(p.percent[i][j] + " ");
//			System.out.println();
//		}
//		System.out.println();
		
		for(int i = 0;i < 6;i++)
			System.out.println(p.natFinal[i]);
		for(int i = 0;i < 6;i++)
			System.out.println(p.amerFinal[i]);
	}
}
