package gamelist.exe;

import java.net.URISyntaxException;

import gamelist.http.Get;

public class MainExecutor {

	public static void main(String[] args) {
		Get get = new Get();
		try {
			System.out.println(get.getGameList("Parasite%20Eve", "Sony Playstation"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
