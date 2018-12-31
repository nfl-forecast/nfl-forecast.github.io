package data;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MakeObjectsUsingJackson {

	public static void main(String[] args) {
		try
		{run();
		
		}
		catch(Exception e)
		{
			System.out.println("Aw Shucks!");
			System.out.println("Something went wrong!");
			e.printStackTrace();
		}

	}
	public static TopData run() throws Exception {
		String str = GetOverallTeamStandings.getRegOnly();
		ObjectMapper mapper = new ObjectMapper();

		try {

			TopData allStats = mapper.readValue(str, TopData.class);
			return allStats;
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
