package dataFromHTML;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupRushStatParser {
	public static ArrayList<String>[] get(String season) throws IOException {
		ArrayList<String> usingStats = new ArrayList<String>();
		ArrayList<String>[] passStats = new ArrayList[32];
		usingStats.add("Att");
		usingStats.add("TD");
		usingStats.add("YPC");
		Document htmlFile = Jsoup.connect("https://www.nfl.com/stats/team-stats/offense/rushing/" + season+ "/reg/all").get();
		Element table = htmlFile.selectFirst("table");
		ArrayList<String> headerLabels = new ArrayList<String>();
		for (Element e : table.select("th")) {
			headerLabels.add(e.ownText());
		}
		Elements teamRows = table.selectFirst("tBody").select("tr");
		for (int i = 0; i < teamRows.size(); i++) {
			passStats[i] = new ArrayList<String>();
			Elements stats = teamRows.get(i).select("td");
			passStats[i].add(stats.get(0).selectFirst(".d3-o-club-fullname").ownText());
			for (int j = 1; j < stats.size(); j++) {
				if (usingStats.contains(headerLabels.get(j)))
					passStats[i].add("\"Rush" + headerLabels.get(j).replaceAll(" ", "") + "\": {\"abbreviation\": \"" + headerLabels.get(j) + "\", \"value\": \"" + stats.get(j).ownText() + "\"}");
			}
		}
		return passStats;
	}
}
