package topLevel;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import scheduleByWeeks.Game;
import scheduleByWeeks.Schedule;
import scheduleByWeeks.Week;
import teamStructure.Conference;
import teamStructure.Division;
import teamStructure.Team;



public class Driver{
	public Conference AFC, NFC;
	public Schedule season;
	public PlayoffCalc playoffs;
	public static boolean allPlayed;
	public String lastUpdated;
	public double[][] full3232Array;
	public String[] names3232Array;
	public static SchedType type;
	public static int seasonSchedule;
	public static int seasonStats;
	public List<Week> comp;
	public Driver() {
		type = SchedType.regularSeasonNext;
		seasonSchedule = 2020;
		if(type == SchedType.regularSeasonNext)
			seasonStats = seasonSchedule-1;
		else
			seasonStats = seasonSchedule;
		allPlayed = false;
		
		Team NE = new Team("Patriots", new Color(12, 35, 64), new Color(162, 170, 173)),
				NYJ = new Team("Jets", new Color(12, 55, 29), new Color(255, 255, 255)),
				BUF = new Team("Bills", new Color(12, 46, 130), new Color(255, 0, 0)),
				MIA = new Team("Dolphins", new Color(0, 142, 151), new Color(255, 255, 255)),
				HOU = new Team("Texans", new Color(9, 31, 44), new Color(255, 0, 0)),
				IND = new Team("Colts", new Color(0, 20, 137), new Color(255, 255, 255)),
				JAX = new Team("Jaguars", new Color(0, 96, 115), new Color(255, 255, 255)),
				TEN = new Team("Titans", new Color(65, 143, 222), new Color(255, 255, 255)),
				PIT = new Team("Steelers", new Color(0, 0, 0), new Color(255, 184, 28)),
				CLE = new Team("Browns", new Color(56, 47, 45), new Color(235, 51, 0)),
				BAL = new Team("Ravens", new Color(26, 25, 95), new Color(255, 255, 255)),
				CIN = new Team("Bengals", new Color(252, 76, 2), new Color(0, 0, 0)),
				LAC = new Team("Chargers", new Color(0,128,198), new Color(255, 184, 28)),
				DEN = new Team("Broncos", new Color(252, 76, 2), new Color(12, 35, 64)),
				LV = new Team("Raiders", new Color(0, 0, 0), new Color(191, 192, 191)),
				KC = new Team("Chiefs", new Color(200, 16, 46), new Color(255, 255, 255));

		Team GB = new Team("Packers", new Color(23, 94, 34), new Color(255, 184, 28)),
				DET = new Team("Lions", new Color(0, 105, 177), new Color(162, 170, 173)),
				CHI = new Team("Bears", new Color(5, 28, 44), new Color(220, 68, 5)),
				MIN = new Team("Vikings", new Color(84, 41, 109), new Color(255, 184, 28)),
				WAS = new Team("Football Team", new Color(134, 38, 51), new Color(255, 205, 0)),
				DAL = new Team("Cowboys", new Color(0,34,68), new Color(176, 183, 188)),
				NYG = new Team("Giants", new Color(0, 30, 98), new Color(255, 0, 0)),
				PHI = new Team("Eagles", new Color(0, 72, 81), new Color(134, 147, 151)),
				NO = new Team("Saints", new Color(162, 141, 91), new Color(0, 0, 0)),
				CAR = new Team("Panthers", new Color(0, 133, 202), new Color(255, 255, 255)),
				ATL = new Team("Falcons", new Color(166, 25, 46), new Color(255, 255, 255)),
				TB = new Team("Buccaneers", new Color(200, 16, 46), new Color(61, 57, 53)),
				SEA = new Team("Seahawks", new Color(0, 21, 51), new Color(77, 255, 0)),
				SF = new Team("49ers", new Color(170, 0, 0), new Color(179, 153, 93)),
				ARI = new Team("Cardinals", new Color(155, 35, 63), new Color(255, 255, 255)),
				LAR = new Team("Rams", new Color(4, 30, 66), new Color(255, 163, 0));

		Division AEast = new Division(NE, NYJ, BUF, MIA), AWest = new Division(LAC, DEN, LV, KC),
				ASouth = new Division(HOU, IND, JAX, TEN), ANorth = new Division(PIT, CLE, BAL, CIN);

		Division NNorth = new Division(GB, DET, CHI, MIN), NEast = new Division(WAS, DAL, NYG, PHI),
				NSouth = new Division(NO, CAR, ATL, TB), NWest = new Division(SEA, SF, ARI, LAR);
		AFC = null;
		NFC = null;
		season = null;
		try {
			AFC = new Conference(ANorth, AEast, ASouth, AWest);
			NFC = new Conference(NNorth, NEast, NSouth, NWest);
			season = new Schedule(NFC, AFC);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Team[] AFCTeams = AFC.places();
		Team[] NFCTeams = NFC.places();

		playoffs = new PlayoffCalc(NFC.seeding(), AFC.seeding());
		playoffs.calculate();
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		lastUpdated = dateFormat.format(date); //2016/11/16 12:08:43
		
		Team[] allTeams = new Team[32];
		names3232Array = new String[32];
		
		for(int i = 0; i < 16; i++)
		{
			allTeams[i] = AFCTeams[i];
			allTeams[i+16] = NFCTeams[i];
			names3232Array[i+16] = NFCTeams[i].getName();
			names3232Array[i] = AFCTeams[i].getName();
		}
		
		full3232Array = PlayoffCalc.makeFullPercents(allTeams);
	}

	public void toJSON() {
		ObjectMapper Obj = new ObjectMapper();
		Obj.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {

			// get Oraganisation object as a json string
			String str = "var forecastData =" + Obj.writeValueAsString(this);
			
			
			BufferedWriter write = new BufferedWriter(new FileWriter(new File("data.js")));
			write.write(str);
			write.close();
			System.out.println(str);
		}

		catch (IOException e) {
			System.out.println("PROBLEMS HERE");
			e.printStackTrace();
		}
	}

	public void JSONPast() throws Exception {
		List<Week> weeks = weekPast();
		if(weeks == null)
			weeks = new ArrayList<Week>();
		List<Week> weekShouldInclude = season.completedWeeks();
		List<Week> newWeeks = new ArrayList<Week>();
		int i;
		for(i = 0; i < weeks.size(); i++)
			if(weekShouldInclude.size() > i)
				if(weekShouldInclude.get(i).equals(weeks.get(i)))
					newWeeks.add(i, weeks.get(i));
		for(int j =i; j < weekShouldInclude.size(); j++)
				newWeeks.add(weekShouldInclude.get(j));
		comp = newWeeks;
		setCalculationsPast();
	}
	
	public List<Week> weekPast() throws Exception {
		Scanner scan = new Scanner(new File("data.js"));
		String str = scan.nextLine();
		str = str.replace("var forecastData =", "");
		//System.out.println(str);
		ObjectMapper mapper = new ObjectMapper();
		Driver prev = mapper.readValue(str, Driver.class);
		scan.close();
		return prev.comp;
	}
	
	private void setCalculationsPast() {
		int weeks = comp.size();
		for(int i = 0; i < weeks; i++) {
			Week w = season.getWeeks().get(i);
			Week percentFromWeek = comp.get(i);
			int games = w.getGames().size();
			for(int j = 0; j < games; j++) {
				Game g = w.getGames().get(j);
				Game percentFromGame = percentFromWeek.getGames().get(j);
				g.setAwayPCT(percentFromGame.getAwayPCT());
				g.setHomePCT(percentFromGame.getHomePCT());
			}
		}
	}
	public static void main(String[] args) throws Exception {
		Driver prog = new Driver();
		prog.JSONPast();
		if(prog.comp == null)
			prog.comp = new ArrayList<Week>();
		prog.toJSON();
		/*int count = 0;
		Team[] AFCTeams = prog.AFC.places();
		Team[] NFCTeams = prog.NFC.places();

//		for (int i = 0; i < 16; i++)
//		{
//			System.out.println(AFCTeams[i].wins);
//			System.out.println(NFCTeams[i].wins);
//		}

		System.out.println();
		AFCTeams = prog.AFC.places();
		NFCTeams = prog.NFC.places();
		System.out.println("AFC");
		for (int i = 0; i < 16; i++) {
			System.out.println(AFCTeams[i]);
		}
		System.out.println();
		System.out.println("NFC");
		for (int i = 0; i < 16; i++) {
			System.out.println(NFCTeams[i]);
		}

		System.out.println("STANDINGS");
		System.out.println();
		System.out.println("AFC East");
		System.out.println(prog.AFC.East);

		System.out.println();
		System.out.println("AFC North");
		System.out.println(prog.AFC.North);

		System.out.println();
		System.out.println("AFC South");
		System.out.println(prog.AFC.South);

		System.out.println();
		System.out.println("AFC West");
		System.out.println(prog.AFC.West);

		System.out.println();
		System.out.println("NFC East");
		System.out.println(prog.NFC.East);

		System.out.println();
		System.out.println("NFC North");
		System.out.println(prog.NFC.North);

		System.out.println();
		System.out.println("NFC South");
		System.out.println(prog.NFC.South);

		System.out.println();
		System.out.println("NFC West");
		System.out.println(NWest);

		double sumWins = 0;
		for (int i = 0; i < 16; i++) {
			sumWins += AFCTeams[i].wins;
			sumWins += NFCTeams[i].wins;
		}

		System.out.println();
		System.out.print(sumWins);
		
		
		System.out.println(prog.NFC.West);*/

	}

}
