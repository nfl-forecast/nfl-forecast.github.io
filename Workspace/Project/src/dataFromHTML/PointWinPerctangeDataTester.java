package dataFromHTML;

import java.util.ArrayList;
import java.util.List;

public class PointWinPerctangeDataTester {

	public static void main(String[] args) {
		ArrayList<double[]>[] statPoints = new ArrayList[21];
		for(int i = 0; i < statPoints.length; i++)
			statPoints[i] = new ArrayList<double[]>();
		int currentSeason = 2020;
		for(int i = 1; i <= 5; i++) {
			int year = currentSeason-i;
			TopData data = MakeObjectsUsingJackson.run(year+"");
			List<FullStats> stats = data.Allstats.getStatEntry();
			for(FullStats teamStat: stats) {
				teamStat.combine();
				Stat[] importants = teamStat.ImportantStats;
				double gamesPlayed = teamStat.getGamesPlayed();
				double winPCT = (Integer.parseInt(teamStat.W.getValue()))/(gamesPlayed);
				for(int j = 0; j< importants.length; j++) {
					double[] dataPoint = new double[2];
					dataPoint[0] = Double.parseDouble(importants[j].getValue());
					if(importants[j].getC() != 0)
						dataPoint[0] /= gamesPlayed;
					dataPoint[1] =	winPCT;
					statPoints[j].add(dataPoint);
				}
					
			}
		}
		for(int i =0; i < statPoints.length; i++) {
			ArrayList<Double> x = new ArrayList<Double>();
			ArrayList<Double> y = new ArrayList<Double>();
			for(int j=0; j < statPoints[i].size(); j++)
			{
				x.add(statPoints[i].get(j)[0]);
				y.add(statPoints[i].get(j)[1]);
			}
			System.out.println(i);
			System.out.println("x1 = " + x);
			System.out.println("y1 = " + y);
			System.out.println();
		}
		
		
	}

}
