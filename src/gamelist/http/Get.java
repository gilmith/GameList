package gamelist.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.ResponseHandler;


public class Get {
	
	private final static String URLGETGAMELIST = "http://thegamesdb.net/api/GetGamesList.php";
	private final static String URLGETGAMEs = "http://thegamesdb.net/api/GetGames.php";
	private CloseableHttpClient httpClient;
	private HttpGet httpGet;
	
	public Get(){
		httpClient = HttpClients.createDefault();
		httpGet = new HttpGet();
	}
	
	public String getGameList(String name, String platform){
		String respuesta = null;
		ResponseHandler<String> respuestaHandler = new BasicResponseHandler();
		return respuesta; 
	}
	

}
