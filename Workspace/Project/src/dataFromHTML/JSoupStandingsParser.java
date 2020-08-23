package dataFromHTML;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupStandingsParser {
	
	public static ArrayList<String>[] get(String season) throws IOException {
		ArrayList<String> usingStats = new ArrayList<String>();
		ArrayList<String>[] standingsStats = new ArrayList[32];
		usingStats.add("W");
		usingStats.add("L");
		usingStats.add("T");
		usingStats.add("PF");
		usingStats.add("PA");
		usingStats.add("Net Pts");
		Document htmlFile = Jsoup.connect("https://www.nfl.com/standings/league/" + season+ "/reg/").get();
		Element table = htmlFile.selectFirst("table");
		ArrayList<String> headerLabels = new ArrayList<String>();
		for (Element e : table.select("th")) {
			headerLabels.add(e.ownText());
		}
		Elements teamRows = table.selectFirst("tBody").select("tr");
		for (int i = 0; i < teamRows.size(); i++) {
			standingsStats[i] = new ArrayList<String>();
			Elements stats = teamRows.get(i).select("td");
			Element teamName = stats.get(0).selectFirst(".d3-o-club-fullname");
			standingsStats[i].add(teamName.ownText());
			Elements clinchChars = teamName.select("sup");
			if(clinchChars.size() != 0) {
				String clinchChar = (clinchChars.get(clinchChars.size()-1).ownText());
				standingsStats[i].add("\"clinchCharacter\": \"" + clinchChar + "\"");
			}
			else
			{
				standingsStats[i].add("\"clinchCharacter\": \" \"");
			}
			for (int j = 1; j < stats.size(); j++) {
				if (usingStats.contains(headerLabels.get(j)))
					standingsStats[i].add("\"" + headerLabels.get(j).replaceAll(" ", "") + "\": {\"abbreviation\": \"" + headerLabels.get(j) + "\", \"value\": \"" + stats.get(j).ownText() + "\"}");
			}
		}
		return standingsStats;
	}
}
