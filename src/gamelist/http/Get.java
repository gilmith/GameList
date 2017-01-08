package gamelist.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class Get {
	
	private final static String URLGETGAMELIST = "http://thegamesdb.net/api/GetGamesList.php?name=#1";
	private final static String URLGETGAMEs = "http://thegamesdb.net/api/GetGames.php?id=#1";
	private CloseableHttpClient httpClient;
	private HttpGet httpGet;
	private Properties properties;
	
	public Get(){
		httpClient = HttpClients.createDefault();
		httpGet = new HttpGet();
		properties = new Properties();
	}
	
	public String getGameList(String name, String platform) throws URISyntaxException{
		String respuesta = null;
		setProperties(properties);
		ResponseHandler<String> respuestaHandler = new BasicResponseHandler();
		URI uri = new URI(getURI(name, platform, URLGETGAMELIST));
		httpGet.setURI(uri);
		try {
			respuesta = httpClient.execute(httpGet, respuestaHandler);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuesta; 
	}
	
	
	private String getURI(String name, String platform, String uri){
		String initURI = uri;
		StringBuilder sb = new StringBuilder();
		sb.append(initURI.replaceFirst("#1", name));
		return sb.toString();
	}
	
	
	private void setProperties(Properties properties){
		File file = new File("properties//translate.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			properties.load(fis);
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
