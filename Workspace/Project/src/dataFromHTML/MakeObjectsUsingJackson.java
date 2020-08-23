package dataFromHTML;
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
			e.printStackTrace();
		}

	}
	public static TopData run(){
		String str = "";
		try {
			str = JSoupStatParser.get("2019");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
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
