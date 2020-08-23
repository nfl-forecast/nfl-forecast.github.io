package dataFromHTML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import topLevel.TeamNameHelper;

public class JSoupStatParser {
	public static void main(String[] args) {
		System.out.print(get("2019"));
	}

	public static String get(String season) {
		try {
			Calendar now = Calendar.getInstance();
			int thisYear = now.get(Calendar.YEAR);
			int thisMonth = now.get(Calendar.MONTH) + 1;
			int today = now.get(Calendar.DATE);

			int thisHour = now.get(Calendar.HOUR_OF_DAY);
			int thisMinute = now.get(Calendar.MINUTE);
			int thisSecond = now.get(Calendar.SECOND);
			String[] docNames = {
					"https://www.nfl.com/stats/team-stats/defense/interceptions/2019/reg/all"};
			String[] wantedStats = {"https://www.nfl.com/stats/team-stats/defense/interceptions/2019/reg/all/INT",
					"https://www.nfl.com/stats/team-stats/defense/interceptions/2019/reg/all/INT Yds"};
			ArrayList<String> usingStats = new ArrayList<String>();
			for (int i = 0; i < wantedStats.length; i++)
				usingStats.add(wantedStats[i]);
			String lastUpdated = "\"lastUpdatedOn\": \""
					+ (thisMonth + "/" + today + "/" + thisYear + " " + thisHour + ":" + thisMinute + ":" + thisSecond)
					+ "\"";
			String allStats = "{\"Allstats\": {" + lastUpdated + ", \"statEntry\": [";
			ArrayList<String>[] sortedTeams = new ArrayList[32];
			for (int i = 0; i < sortedTeams.length; i++) {
				sortedTeams[i] = new ArrayList<String>();
			}
			Thread.sleep(500);
			ArrayList<String>[] standingsResponse = JSoupStandingsParser.get(season);
			for(ArrayList<String> teamStandings: standingsResponse) {
				String teamInfo = teamStandings.remove(0);
				combine(sortedTeams, teamInfo, teamStandings);
				
			}
			Thread.sleep(500);
			ArrayList<String>[] passResponse = JSoupPassStatParser.get(season);
			for(ArrayList<String> teamPassStats: passResponse) {
				String teamInfo = teamPassStats.remove(0);
				combine(sortedTeams, teamInfo, teamPassStats);
			}
			Thread.sleep(500);
			ArrayList<String>[] rushResponse = JSoupRushStatParser.get(season);
			for(ArrayList<String> teamRushStats: rushResponse) {
				String teamInfo = teamRushStats.remove(0);
				combine(sortedTeams, teamInfo, teamRushStats);
			}
			Thread.sleep(500);
			ArrayList<String>[] downsResponse = JSoupDownsStatParser.get(season);
			for(ArrayList<String> teamDownsStats: downsResponse) {
				String teamInfo = teamDownsStats.remove(0);
				combine(sortedTeams, teamInfo, teamDownsStats);
			}
			Thread.sleep(500);
			ArrayList<String>[] tackleResponse = JSoupTackleStatParser.get(season);
			for(ArrayList<String> teamTackleStats: tackleResponse) {
				String teamInfo = teamTackleStats.remove(0);
				combine(sortedTeams, teamInfo, teamTackleStats);
			}
			Thread.sleep(500);
			ArrayList<String>[] defRecResponse = JSoupDefRecStatParser.get(season);
			for(ArrayList<String> teamDefRecStats: defRecResponse) {
				String teamInfo = teamDefRecStats.remove(0);
				combine(sortedTeams, teamInfo, teamDefRecStats);
			}
			Thread.sleep(500);
			ArrayList<String>[] intResponse = JSoupIntStatParser.get(season);
			for(ArrayList<String> teamIntStats: intResponse) {
				String teamInfo = teamIntStats.remove(0);
				combine(sortedTeams, teamInfo, teamIntStats);
			}
			for (int i = 0; i < sortedTeams.length; i++) {
				String teamJSON = "{";
				for (int j = 0; j < sortedTeams[i].size(); j++) {
					teamJSON += sortedTeams[i].get(j) + ", ";
				}
				teamJSON = teamJSON.substring(0, teamJSON.length() - 2) + "}";
				allStats += teamJSON + ", ";
			}
			allStats = allStats.substring(0, allStats.length() - 2) + "]}}";
			allStats = allStats.replaceAll("%", "PCT");
			allStats = allStats.replaceAll("/", "Per");
			allStats = allStats.replaceAll("3rd", "Third");
			FileWriter write = new FileWriter(new File("Stats.json"));
			write.write(allStats);
			write.close();
			return allStats;
		} catch (IOException e) { 
			System.out.print(e);
			return "";
		} catch (InterruptedException e) {
			System.out.print(e);
			return "";
		}
	}

	private static void combine(ArrayList<String>[] sortedTeams, String teamInfo, ArrayList<String> newStats) {
		for (ArrayList<String> team : sortedTeams)
			if (team.size() != 0
					&& TeamNameHelper.getTeamName(stripToName(team.get(0))) == TeamNameHelper.getTeamName(teamInfo)) {
				team.addAll(newStats);
				return;
			}
		for (ArrayList<String> team : sortedTeams)
			if (team.size() == 0) {
				team.add("\"name\": \"" + TeamNameHelper.getTeamName(teamInfo) + "\"");
				team.addAll(newStats);
				return;
			}
		System.out.println(teamInfo);
	}

	private static String stripToName(String str) {
		str = str.substring(0, str.length() - 1);
		str = str.substring(9);
		return str;
	}
}
