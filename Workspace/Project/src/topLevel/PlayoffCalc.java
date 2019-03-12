package topLevel;

import teamStructure.Team;

public class PlayoffCalc 
{
	Team[] national, american;
	int[] natFinal, amerFinal;
	int[][] percent;
	
	public PlayoffCalc(Team[] nat, Team[] amer)
	{
		national = nat;
		american = amer;
		//fillpercent(west, east)
	}
	
	public void calculate()
	{
		int[] natPerc = new int[6];
		int[] amerPerc = new int[6];
		Team[] current = national;
		for(int i = 0;i < 1;i++)
		{
			//set up arrays for either side
			int[] left = new int[6], right = new int[6];
			for(int j = 0;j < 6;j++)
			{
				left[i] = 0;
				right[i] = 0;
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
				sum1 += percent[0][i] * left[i];
				sum2 += percent[1][i] * right[i];
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
					sumLeft += percent[j][k] * right[k];
				sumLeft *= left[j];
				
				for(int k = 0;k < 6;k++)
					sumRight += percent[j][k] * left[k];
				sumLeft *= right[j];
				
				//current[i] = sumLeft + sumRight;
			}
		}
	}

}
