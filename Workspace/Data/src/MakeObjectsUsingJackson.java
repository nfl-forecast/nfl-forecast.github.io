import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import data.TopData;

public class MakeObjectsUsingJackson {

	public static void main(String[] args) {
		run();

	}
	private static void run() {
		String str = GetOverallTeamStandings.get();
		ObjectMapper mapper = new ObjectMapper();

		try {

			TopData allStats = mapper.readValue(str, TopData.class);
			System.out.println(allStats);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
