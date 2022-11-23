package rcbTeam;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class validateForeginPlayers {
	@Test
	public void test() throws IOException, ParseException {
		int countofforeignplayer = 0;
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
				String country = (String) player.get("country");
				if (!country.equals("India")) {
					countofforeignplayer = countofforeignplayer + 1;
				}
			}
			System.out.println("No of foreign players: " + countofforeignplayer);
			Assert.assertEquals(4, countofforeignplayer);
		} catch (Exception e) {
		}
	}


}
