package scheduleFromHTML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupScheduleParser {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(runPost("2020"));
	}

	public static String run(String season) throws InterruptedException {
		Document htmlFile = null;
		try {
			Calendar now = Calendar.getInstance();
			int thisYear = now.get(Calendar.YEAR);
			int thisMonth = now.get(Calendar.MONTH) + 1;
			int today = now.get(Calendar.DATE);

			int thisHour = now.get(Calendar.HOUR_OF_DAY);
			int thisMinute = now.get(Calendar.MINUTE);
			int thisSecond = now.get(Calendar.SECOND);
			String schedule = "{\"fullgamesschedule\": {\"lastUpdatedOn\": \""
					+ (thisMonth + "/" + today + "/" + thisYear + " " + thisHour + ":" + thisMinute + ":" + thisSecond)
					+ "\", \"gameentry\":[";
			for (int i = 1; i <= 17; i++) {
				Thread.sleep(500);
				htmlFile = Jsoup.connect(
						"https://www.nfl.com/api/lazy/load?json=%7B%22Name%22%3A%22Schedules%22%2C%22Module%22%3A%7B%22seasonFromUrl%22%3A"
								+ season + "%2C%22SeasonType%22%3A%22REG" + i
								+ "%22%2C%22WeekFromUrl%22%3A1%2C%22PreSeasonPlacement%22%3A0%2C%22RegularSeasonPlacement%22%3A0%2C%22PostSeasonPlacement%22%3A0%2C%22TimeZoneID%22%3A%22America%2FNew_York%22%7D%7D")
						.get();
				Element top = htmlFile.selectFirst("div[data-json-module]");
				Elements sections = top.select("section");
				for (Element e : sections) {
					Element section = e.child(0).child(0);
					Element dateNode = section.child(0);
					String date = dateNode.ownText();
					List<Element> gameNodes = section.select("> div.nfl-c-matchup-strip");
					for (Element gameNode : gameNodes) {
						Element left = gameNode.selectFirst("> a");
						String url = left.attr("href");
						Elements timeNodes = left.select("span.nfl-c-matchup-strip__date-time");
						String time;
						if (timeNodes.size() != 0)
							time = timeNodes.get(0).ownText();
						else {
							Elements liveNodes = left.select("p.nfl-c-matchup-strip__period");
							if (liveNodes.size() > 0
									&& liveNodes.select("span.nfl-c-matchup-strip__quarter").size() > 0) {
								time = liveNodes.select("span.nfl-c-matchup-strip__quarter").get(0).ownText();

							} else
								time = "Final";
						}

						Elements teamNames = left.select(".nfl-c-matchup-strip__team-fullname");
						Element awayNameNode = teamNames.get(0);
						String awayName = awayNameNode.ownText();
						Element homeNameNode = teamNames.get(1);
						String homeName = homeNameNode.ownText();

						Elements teamAbrs = left.select(".nfl-c-matchup-strip__team-abbreviation");
						Element awayAbrNode = teamAbrs.get(0);
						String awayAbr = awayAbrNode.ownText();
						Element homeAbrNode = teamAbrs.get(1);
						String homeAbr = homeAbrNode.ownText();

						Elements score = left.select(".nfl-c-matchup-strip__team-score");
						String awayScore, homeScore;
						if (score.size() != 0) {
							Element awayScoreNode = score.get(0);
							awayScore = awayScoreNode.ownText();
							Element homeScoreNode = score.get(1);
							homeScore = homeScoreNode.ownText();
						} else {
							awayScore = "";
							homeScore = "";
						}
						String away = "{\"Name\": \"" + awayName + "\", \"Abreviation\": \"" + awayAbr + "\","
								+ "\"Score\": \"" + awayScore + "\"}";
						String home = "{\"Name\": \"" + homeName + "\", \"Abreviation\": \"" + homeAbr + "\","
								+ "\"Score\": \"" + homeScore + "\"}";
						String game = "{\"week\": \"" + i + "\", \"date\": \"" + date + "\", \"time\": \"" + time
								+ "\", \"url\": \"nfl.com" + url + "\", \"awayTeam\": " + away + ", \"homeTeam\": "
								+ home + "}";
						schedule += game + ", ";
					}

				}

			}
			/*for (int i = 1; i <= 4; i++) {
				Thread.sleep(500);
				htmlFile = Jsoup.connect(
						"https://www.nfl.com/api/lazy/load?json=%7B%22Name%22%3A%22Schedules%22%2C%22Module%22%3A%7B%22seasonFromUrl%22%3A"
								+ season + "%2C%22SeasonType%22%3A%22POST" + i
								+ "%22%2C%22WeekFromUrl%22%3A1%2C%22PreSeasonPlacement%22%3A0%2C%22RegularSeasonPlacement%22%3A0%2C%22PostSeasonPlacement%22%3A0%2C%22TimeZoneID%22%3A%22America%2FNew_York%22%7D%7D")
						.get();
				Element top = htmlFile.selectFirst("div[data-json-module]");
				Elements sections = top.select("section");
				for (Element e : sections) {
					Element section = e.child(0).child(0);
					Element dateNode = section.child(0);
					String date = dateNode.ownText();
					List<Element> gameNodes = section.select("> div.nfl-c-matchup-strip");
					for (Element gameNode : gameNodes) {
						Element left = gameNode.selectFirst("> a");
						String url = left.attr("href");
						Elements timeNodes = left.select("span.nfl-c-matchup-strip__date-time");
						String time;
						if (timeNodes.size() != 0)
							time = timeNodes.get(0).ownText();
						else {
							Elements liveNodes = left.select("p.nfl-c-matchup-strip__period");
							if (liveNodes.size() > 0
									&& liveNodes.select("span.nfl-c-matchup-strip__quarter").size() > 0) {
								time = liveNodes.select("span.nfl-c-matchup-strip__quarter").get(0).ownText();

							} else
								time = "Final";
						}

						Elements teamNames = left.select(".nfl-c-matchup-strip__team-fullname");
						Element awayNameNode = teamNames.get(0);
						String awayName = awayNameNode.ownText();
						Element homeNameNode = teamNames.get(1);
						String homeName = homeNameNode.ownText();

						Elements teamAbrs = left.select(".nfl-c-matchup-strip__team-abbreviation");
						Element awayAbrNode = teamAbrs.get(0);
						String awayAbr = awayAbrNode.ownText();
						Element homeAbrNode = teamAbrs.get(1);
						String homeAbr = homeAbrNode.ownText();

						Elements score = left.select(".nfl-c-matchup-strip__team-score");
						String awayScore, homeScore;
						if (score.size() != 0) {
							Element awayScoreNode = score.get(0);
							awayScore = awayScoreNode.ownText();
							Element homeScoreNode = score.get(1);
							homeScore = homeScoreNode.ownText();
						} else {
							awayScore = "";
							homeScore = "";
						}
						
						String away = "{\"Name\": \"" + awayName + "\", \"Abreviation\": \"" + awayAbr + "\","
								+ "\"Score\": \"" + awayScore + "\"}";
						String home = "{\"Name\": \"" + homeName + "\", \"Abreviation\": \"" + homeAbr + "\","
								+ "\"Score\": \"" + homeScore + "\"}";
						String game = "{\"week\": \"" + i + "\", \"date\": \"" + date + "\", \"time\": \"" + time
								+ "\", \"url\": \"nfl.com" + url + "\", \"awayTeam\": " + away + ", \"homeTeam\": "
								+ home + "}";
						schedule += game + ", ";
					}

				}

			}*/
			schedule = schedule.substring(0, schedule.length() - 2) + "]}}";

			FileWriter write = new FileWriter(new File("Schedule.json"));
			write.write(schedule);
			write.close();
			return schedule;
		} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace();
			e.printStackTrace();
			return "";
		}

	}
	public static String runPost(String season) throws InterruptedException {
		Document htmlFile = null;
		try {
			Calendar now = Calendar.getInstance();
			int thisYear = now.get(Calendar.YEAR);
			int thisMonth = now.get(Calendar.MONTH) + 1;
			int today = now.get(Calendar.DATE);

			int thisHour = now.get(Calendar.HOUR_OF_DAY);
			int thisMinute = now.get(Calendar.MINUTE);
			int thisSecond = now.get(Calendar.SECOND);
			String schedule = "{\"fullgamesschedule\": {\"lastUpdatedOn\": \""
					+ (thisMonth + "/" + today + "/" + thisYear + " " + thisHour + ":" + thisMinute + ":" + thisSecond)
					+ "\", \"gameentry\":[";
			for (int i = 1; i <= 4; i++) {
				Thread.sleep(500);
				htmlFile = Jsoup.connect(
						"https://www.nfl.com/api/lazy/load?json=%7B%22Name%22%3A%22Schedules%22%2C%22Module%22%3A%7B%22seasonFromUrl%22%3A"
								+ season + "%2C%22SeasonType%22%3A%22POST" + i
								+ "%22%2C%22WeekFromUrl%22%3A1%2C%22PreSeasonPlacement%22%3A0%2C%22RegularSeasonPlacement%22%3A0%2C%22PostSeasonPlacement%22%3A0%2C%22TimeZoneID%22%3A%22America%2FNew_York%22%7D%7D")
						.get();
				Element top = htmlFile.selectFirst("div[data-json-module]");
				Elements sections = top.select("section");
				for (Element e : sections) {
					Element section = e.child(0).child(0);
					Element dateNode = section.child(0);
					String date = dateNode.ownText();
					List<Element> gameNodes = section.select("> div.nfl-c-matchup-strip");
					for (Element gameNode : gameNodes) {
						Element left = gameNode.selectFirst("> a");
						String url = left.attr("href");
						Elements timeNodes = left.select("span.nfl-c-matchup-strip__date-time");
						String time;
						if (timeNodes.size() != 0)
							time = timeNodes.get(0).ownText();
						else {
							Elements liveNodes = left.select("p.nfl-c-matchup-strip__period");
							if (liveNodes.size() > 0
									&& liveNodes.select("span.nfl-c-matchup-strip__quarter").size() > 0) {
								time = liveNodes.select("span.nfl-c-matchup-strip__quarter").get(0).ownText();

							} else
								time = "Final";
						}

						Elements teamNames = left.select(".nfl-c-matchup-strip__team-fullname");
						Element awayNameNode = teamNames.get(0);
						String awayName = awayNameNode.ownText();
						Element homeNameNode = teamNames.get(1);
						String homeName = homeNameNode.ownText();

						Elements teamAbrs = left.select(".nfl-c-matchup-strip__team-abbreviation");
						Element awayAbrNode = teamAbrs.get(0);
						String awayAbr = awayAbrNode.ownText();
						Element homeAbrNode = teamAbrs.get(1);
						String homeAbr = homeAbrNode.ownText();

						Elements score = left.select(".nfl-c-matchup-strip__team-score");
						String awayScore, homeScore;
						if (score.size() != 0) {
							Element awayScoreNode = score.get(0);
							awayScore = awayScoreNode.ownText();
							Element homeScoreNode = score.get(1);
							homeScore = homeScoreNode.ownText();
						} else {
							awayScore = "";
							homeScore = "";
						}
						String week;
						if(i == 0)
							week = "Wildcard";
						else if(i == 1)
							week = "Divisional";
						else if(i == 2)
							week = "Conference Championship";
						else if(i == 3)
							week = "Superbowl";
						else
							week = "Playoff Week";
						String away = "{\"Name\": \"" + awayName + "\", \"Abreviation\": \"" + awayAbr + "\","
								+ "\"Score\": \"" + awayScore + "\"}";
						String home = "{\"Name\": \"" + homeName + "\", \"Abreviation\": \"" + homeAbr + "\","
								+ "\"Score\": \"" + homeScore + "\"}";
						String game = "{\"week\": \"" + i + "\", \"date\": \"" + date + "\", \"time\": \"" + time
								+ "\", \"url\": \"nfl.com" + url + "\", \"awayTeam\": " + away + ", \"homeTeam\": "
								+ home + "}";
						schedule += game + ", ";
					}

				}

			}
			if(schedule.substring(0, schedule.length() - 2) == ", ")
				schedule = schedule.substring(0, schedule.length() - 2) + "]}}";
			else
				schedule = schedule.substring(0,schedule.length() - 2) + ": []}}";
			FileWriter write = new FileWriter(new File("Schedule.json"));
			write.write(schedule);
			write.close();
			return schedule;
		} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace();
			e.printStackTrace();
			return "";
		}

	}

}
