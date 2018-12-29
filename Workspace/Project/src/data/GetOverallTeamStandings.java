package data;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Scanner;

public class GetOverallTeamStandings {

	public static String get() {
		return get("latest");
	}
	public static String getRegOnly() throws Exception
	{
		try
		{
			String str = get("current");
			return str;
		}
		catch(Exception e)
		{
			int year = LocalDate.now().getYear();
			return get((year - 1) + "-" + year + "-regular");
		}
	}
	public static void main(String[] args) {
		get();
	}
	public static String get(String year) {
		try {

			Scanner scan = new Scanner(new File("APIKey"));
			String token = scan.next(); // reads in the api key
			scan.close();
			// String encoding = token;
			String encoding = Base64.getEncoder().encodeToString((token).getBytes());
			URL url = new URL("https://api.mysportsfeeds.com/v1.0/pull/nfl/" + year + "/overall_team_standings.json");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "Basic " + encoding);
			InputStream content = (InputStream) connection.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(content));
			String line;
			while ((line = in.readLine()) != null) {
				return line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}