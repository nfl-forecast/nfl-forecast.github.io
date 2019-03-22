package topLevel;

import teamStructure.Team;

public class PlayoffCalc 
{
	double[] natFinal, amerFinal;
	double[][] percent;
	Team[] teams;

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
		left[3] = percent[3][4] * percent[5][2];
		left[4] = percent[4][3] * percent[5][2];
		left[5] = percent[5][2];
		right[3] = percent[3][4] * percent[5][2];
		right[4] = percent[4][3] * percent[5][2];
		right[2] = percent[2][5];
		
		//second game
		int sum1 = 0, sum2 = 0;
		for(int j = 0;j < 6;j++)
		{
			sum1 += percent[0][j] * left[j];
			sum2 += percent[1][j] * right[j];
		}
		left[0] = sum1;
		left[3] = percent[3][0] * left[3];
		left[4] = percent[4][0] * left[4];
		left[5] = percent[5][0] * left[5];
		right[1] = sum2;
		left[2] = percent[2][1] * left[2];
		left[3] = percent[3][1] * left[3];
		left[4] = percent[4][1] * left[4];
		
		//third game
		for(int j = 0;j < 6;j++)
		{
			int sumLeft = 0;
			int sumRight = 0;
			
			for(int k = 0;k < 6;k++)
				if(j * k != 20)
					sumLeft += percent[j][k] * right[k];
			sumLeft *= left[j];
			
			for(int k = 0;k < 6;k++)
				if(j * k != 20)
					sumRight += percent[j][k] * left[k];
			sumLeft *= right[j];
			
			natPerc[j] = sumLeft + sumRight;
		}
		////////////////////////////////////////////////////////
		
		//AMERICAN
		
		//set up arrays for either side
		left = new double[6]; 
		right = new double[6];
		for(int j = 0;j < 6;j++)
		{
			left[j] = 0;
			right[j] = 0;
		}
		
		//first game of playoffs
		left[3] = percent[9][10] * percent[11][8];
		left[4] = percent[10][9] * percent[11][8];
		left[5] = percent[11][8];
		right[3] = percent[9][10] * percent[11][8];
		right[4] = percent[10][9] * percent[11][8];
		right[2] = percent[8][11];
		
		//second game
		sum1 = 0; 
		sum2 = 0;
		for(int j = 0;j < 6;j++)
		{
			sum1 += percent[6][j + 6] * left[j];
			sum2 += percent[7][j + 6] * right[j];
		}
		left[0] = sum1;
		left[3] = percent[9][6] * left[9];
		left[4] = percent[10][6] * left[10];
		left[5] = percent[11][6] * left[11];
		right[1] = sum2;
		right[2] = percent[8][7] * right[8];
		right[3] = percent[9][7] * right[9];
		right[4] = percent[10][7] * right[10];
		
		//third game
		for(int j = 0;j < 6;j++)
		{
			int sumLeft = 0;
			int sumRight = 0;
			
			for(int k = 0;k < 6;k++)
				if(j * k != 20)
					sumLeft += percent[j + 6][k + 6] * right[k];
			sumLeft *= left[j];
			
			for(int k = 0;k < 6;k++)
				if(j * k != 20)
					sumRight += percent[j + 6][k + 6] * left[k];
			sumLeft *= right[j];
			
			amerPerc[j] = sumLeft + sumRight;
		}
		///////////////////////////////////////////////////////////
		
		//SUPERBOWL//
		for(int i = 0;i < natFinal.length;i++)
		{
			int sumNat = 0, sumAmer = 0;
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
		/*
		percent = new double[12][12];
		
		for(int i = 0;i < 12;i++)
		{
			for(int j = 0;j < 12;j++)
			{
				percent[i][j] = teams[i].calculate(teams[j]);
			}
		}*/
		/*
		percent = {{1,.8,.9,.7,.6,.5,.4,.3,.2,.1,.5,.9},
				{.2,1,.85,.75,.65,.55,.45,.35,.25,.15,.5,.02},
				{.1,.15,1,.6,.59,.49,.39,.29,.19,.09,.69,.79},
				{.3,.25,.4,1,.81,.99,.98,.88,.78,.68,.58,.48},
				{.4,.35,.41,.11,1,.38,.28,.18,.08,.97,.87,.77},
				{.5,.45,.51,.01,.62,1,.67,.
		}*/
	}
}
