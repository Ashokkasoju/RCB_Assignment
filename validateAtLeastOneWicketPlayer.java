package rcbTeam;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class validateAtLeastOneWicketPlayer {
	@Test
	public void test() throws IOException, ParseException {
		int countofwiketkeeper = 0;
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(".\\RcbPlayers\\players.json");
		Object obj = jsonparser.parse(reader);
		JSONObject players = (JSONObject) obj;
		String pname = (String) players.get("name");
		System.out.println("Team name:" + pname);
		JSONArray array = (JSONArray) players.get("player");
		try {
			for (int i = 0; i < array.size(); i++) {
				JSONObject player = (JSONObject) array.get(i);
				String role = (String) player.get("role");
			if (role.equals("Wicket-keeper")) {
				countofwiketkeeper++;
			}
		}
		System.out.println("No of wicket_keepers: " + countofwiketkeeper);
		Assert.assertEquals(1, countofwiketkeeper);	
		}
			 catch (Exception e) {
		}
	}
}
		
