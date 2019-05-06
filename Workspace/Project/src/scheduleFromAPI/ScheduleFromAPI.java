package scheduleFromAPI;

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

public class ScheduleFromAPI {

	public static String get() {
		try {
			return get("latest");
		} catch (IOException e) {
			return null;
		}
	}

	public static String getRegOnly() {
		try {
			String str = get("current");
			int year = LocalDate.now().getYear();
			String strPlayoff = get(year + "-playoff");
			if (!str.equals(strPlayoff))
				return str;
			else {
				//TODO: set up what happens if currently playoffs
				return null;
			}

		} catch (Exception e) {
			try {
				String str = get("upcoming");
				return str;
			} catch (Exception f) {
				int year = LocalDate.now().getYear();
				try {
					if( LocalDate.now().getMonthValue() != 12)
						return get((year - 1) + "-" + year + "-regular");
					else
					{
						return get(year + "-regular");
					}
				} catch (IOException e1) {
					return null;
				}
			}

		}
	}

	public static void main(String[] args) {
		System.out.println(get());
	}

	public static String get(String year) throws IOException {

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
		return null;
	}
}
