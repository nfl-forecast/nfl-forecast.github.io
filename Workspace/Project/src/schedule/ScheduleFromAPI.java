package schedule;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Scanner;

public class ScheduleFromAPI {

	public static String get() {
		return get("latest");
	}

	public static String getRegOnly() throws Exception {
		try {
			String str = get("current");
			int year = LocalDate.now().getYear();
			String strPlayoff = get(year + "-playoff");
			if (!str.equals(strPlayoff))
				return str;
			else {
				try {
					str = get("upcomming");
					return str;
				} catch (Exception f) {
					return get((year - 1) + "-" + year + "-regular");
				}
			}

		} catch (Exception e) {
			try {
				String str = get("upcomming");
				return str;
			} catch (Exception f) {
				int year = LocalDate.now().getYear();
				return get((year - 1) + "-" + year + "-regular");
			}

		}
	}

	public static void main(String[] args) {
		System.out.println(get());
	}

	public static String get(String year) {
		try {

			Scanner scan = new Scanner(new File("APIKey"));
			String token = scan.next(); // reads in the api key
			scan.close();
			// String encoding = token;
			String encoding = Base64.getEncoder().encodeToString((token).getBytes());
			URL url = new URL("https://api.mysportsfeeds.com/v1.2/pull/nfl/" + year + "/full_game_schedule.json");

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
	public static String getRegOnly(int week) throws Exception {
		try {
			String str = get("current", week);
			int year = LocalDate.now().getYear();
			String strPlayoff = get(year + "-playoff", week);
			if (!str.equals(strPlayoff))
				return str;
			else {
				try {
					str = get("upcomming", week);
					return str;
				} catch (Exception f) {
					return get((year - 1) + "-" + year + "-regular", week);
				}
			}

		} catch (Exception e) {
			try {
				String str = get("upcomming", week);
				return str;
			} catch (Exception f) {
				int year = LocalDate.now().getYear();
				return get((year - 1) + "-" + year + "-regular", week);
			}

		}
	}

	public static String get(String year, int week)
	{
		try {

			Scanner scan = new Scanner(new File("APIKey"));
			String token = scan.next(); // reads in the api key
			scan.close();
			// String encoding = token;
			String encoding = Base64.getEncoder().encodeToString((token).getBytes());
			URL url = new URL("https://api.mysportsfeeds.com/v1.2/pull/nfl/" + year + "/full_game_schedule.json?week=" + week);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "Basic " + encoding);
			InputStream content = (InputStream) connection.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(content));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
				return line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
