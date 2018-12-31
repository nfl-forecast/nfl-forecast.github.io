package topLevel;

import java.awt.Color;

import scheduleByWeeks.Schedule;
import teamStructure.Conference;
import teamStructure.Division;
import teamStructure.Team;

public class Driver {

	public static void main(String[] args) {
		Team NE = new Team("PATRIOTS", new Color(12, 35, 64), new Color(162, 170, 173)),
				NYJ = new Team("JETS", new Color(12, 55, 29), new Color(255, 255, 255)),
				BUF = new Team("BILLS", new Color(12, 46, 130), new Color(255, 0, 0)),
				MIA = new Team("DOLPHINS", new Color(0, 142, 151), new Color(255, 255, 255)),
				HOU = new Team("TEXANS", new Color(9, 31, 44), new Color(255, 0, 0)),
				IND = new Team("COLTS", new Color(0, 20, 137), new Color(255, 255, 255)),
				JAX = new Team("JAGAURS", new Color(0, 96, 115), new Color(255, 255, 255)),
				TEN = new Team("TITANS", new Color(65, 143, 222), new Color(255, 255, 255)),
				PIT = new Team("STEELERS", new Color(0, 0, 0), new Color(255, 184, 28)),
				CLE = new Team("BROWNS", new Color(56, 47, 45), new Color(235, 51, 0)),
				BAL = new Team("RAVENS", new Color(26, 25, 95), new Color(255, 255, 255)),
				CIN = new Team("BENGALS", new Color(252, 76, 2), new Color(0, 0, 0)),
				LAC = new Team("CHARGERS", new Color(12, 35, 64), new Color(255, 184, 28)),
				DEN = new Team("BRONCOS", new Color(252, 76, 2), new Color(12, 35, 64)),
				OAK = new Team("RAIDERS", new Color(0, 0, 0), new Color(191, 192, 191)),
				KC = new Team("CHIEFS", new Color(200, 16, 46), new Color(255, 255, 255));

		Team GB = new Team("PACKERS", new Color(23, 94, 34), new Color(255, 184, 28)),
				DET = new Team("LIONS", new Color(0, 105, 177), new Color(162, 170, 173)),
				CHI = new Team("BEARS", new Color(5, 28, 44), new Color(220, 68, 5)),
				MIN = new Team("VIKINGS", new Color(84, 41, 109), new Color(255, 184, 28)),
				WSH = new Team("REDSKINS", new Color(134, 38, 51), new Color(255, 205, 0)),
				DAL = new Team("COWBOYS", new Color(4, 30, 66), new Color(134, 147, 151)),
				NYG = new Team("GIANTS", new Color(0, 30, 98), new Color(255, 0, 0)),
				PHI = new Team("EAGLES", new Color(0, 72, 81), new Color(134, 147, 151)),
				NO = new Team("SAINTS", new Color(162, 141, 91), new Color(0, 0, 0)),
				CAR = new Team("PANTHERS", new Color(0, 133, 202), new Color(255, 255, 255)),
				ATL = new Team("FALCONS", new Color(166, 25, 46), new Color(255, 255, 255)),
				TB = new Team("BUCCANEERS", new Color(200, 16, 46), new Color(61, 57, 53)),
				SEA = new Team("SEAHAWKS", new Color(0, 21, 51), new Color(77, 255, 0)),
				SF = new Team("49ERS", new Color(157, 42, 70), new Color(255, 255, 255)),
				ARI = new Team("CARDINALS", new Color(155, 39, 67), new Color(255, 255, 255)),
				LAR = new Team("RAMS", new Color(4, 30, 66), new Color(255, 255, 255));

		Division AEast = new Division(NE, NYJ, BUF, MIA), AWest = new Division(LAC, DEN, OAK, KC),
				ASouth = new Division(HOU, IND, JAX, TEN), ANorth = new Division(PIT, CLE, BAL, CIN);

		Division NNorth = new Division(GB, DET, CHI, MIN), NEast = new Division(WSH, DAL, NYG, PHI),
				NSouth = new Division(NO, CAR, ATL, TB), NWest = new Division(SEA, SF, ARI, LAR);

		try {
			Conference AFC = new Conference(ANorth, AEast, ASouth, AWest),
					NFC = new Conference(NNorth, NEast, NSouth, NWest);
			Schedule season = new Schedule(NFC, AFC);
			
			System.out.println("Passed create Seasons");
			
		} catch (Exception e) {

		}
	}

}
