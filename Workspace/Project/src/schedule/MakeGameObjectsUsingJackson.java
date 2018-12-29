package schedule;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MakeGameObjectsUsingJackson {

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
	private static void run() throws Exception {
		String str = ScheduleFromAPI.getRegOnly();
		ObjectMapper mapper = new ObjectMapper();

		try {

			FullSchedule full = mapper.readValue(str, FullSchedule.class);
			System.out.println(full);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
