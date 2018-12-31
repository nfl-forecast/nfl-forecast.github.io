package data;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Scanner;

public class GetOverallTeamStandings {

	public static String get() {
		try {
			return get("latest");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String getRegOnly()
	{
		try
		{
			String str = get("current");
			int year = LocalDate.now().getYear();
			String strPlayoff = get(year + "-playoff");
			if(!str.equals(strPlayoff))
				return str;
			else
			{
				try
				{
					str = get("upcomming");
					return str;
				}
				catch(Exception f)
				{
					return get((year - 1) + "-" + year + "-regular");
				}
			}

		}
		catch(Exception e)
		{
			try
			{
				String str = get("upcomming");
				return str;
			}
			catch(Exception f)
			{
				int year = LocalDate.now().getYear();
				try {
					return get((year - 1) + "-" + year + "-regular");
				} catch (IOException e1) {
					return null;
				}
			}

		}
	}
	public static void main(String[] args) {
		get();
	}
	public static String get(String year) throws IOException {
			Scanner scan = new Scanner(new File("APIKey"));
			String token = scan.next(); // reads in the api key
			scan.close();
			// String encoding = token;
			String encoding = Base64.getEncoder().encodeToString((token).getBytes());
			URL url = new URL("https://api.mysportsfeeds.com/v1.2/pull/nfl/" + year + "/overall_team_standings.json");

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
			return null;
	}

}