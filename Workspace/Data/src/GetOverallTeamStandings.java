import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;


public class GetOverallTeamStandings {

	public static String get()
	{
		 try {
	        	
	            Scanner scan =new Scanner(new File("APIKey")); 
	            String token = scan.next(); //reads in the api key
	            //String encoding = token;
	            String encoding = Base64.getEncoder().encodeToString( (token).getBytes());
	            URL url = new URL ("https://api.mysportsfeeds.com/v1.0/pull/nfl/latest/overall_team_standings.json");
	            
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");
	            connection.setDoOutput(true);
	            connection.setRequestProperty("Authorization", "Basic " + encoding);
	            InputStream content = (InputStream)connection.getInputStream();
	            BufferedReader in = 
	                new BufferedReader(new InputStreamReader(content));
	            String line;
	            while ((line = in.readLine()) != null) {
	            	return line;
	            }
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
		 return null;
	}
    public static void main(String[] args) {

        try {
        	
            Scanner scan =new Scanner(new File("APIKey")); 
            String token = scan.next(); //reads in the api key
            //String encoding = token;
            String encoding = Base64.getEncoder().encodeToString( (token).getBytes());
            URL url = new URL ("https://api.mysportsfeeds.com/v1.0/pull/nfl/latest/overall_team_standings.json");
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in = 
                new BufferedReader(new InputStreamReader(content));
            String line;
            while ((line = in.readLine()) != null) {
            	System.out.println(line);
                BufferedWriter f = new BufferedWriter(new FileWriter("OvrStandings.json"));
                f.write(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
  
}