package gamelist.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class Get {
	
	private final static String URLGETGAMELIST = "http://thegamesdb.net/api/GetGamesList.php?name=#1";
	private final static String URLGETGAMES = "http://thegamesdb.net/api/GetGame.php?name=#1&platform=#2";
	private CloseableHttpClient httpClient;
	private HttpGet httpGet;
	private Properties properties;
	
	public Get(){
		httpClient = HttpClients.createDefault();
		httpGet = new HttpGet();
		properties = new Properties();
	}
	
	public void downloadImagen(String portada, String portdaSplitted) throws MalformedURLException, IOException{
		URL url = new URL("http://thegamesdb.net/banners/" + portada);
		URLConnection uc = url.openConnection();
		uc.addRequestProperty("User-Agent", 
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		InputStream in = uc.getInputStream();
		try {
			Files.copy(in, Paths.get("/mnt/seagate/raspberry/roms/psx/downloaded_images/" + 
					portdaSplitted));
		} catch(FileAlreadyExistsException faex){
			System.out.println("Portada ya descargada, juego multidisco");
		}
	}
	
	public void downloadImagen(String portada, String portdaSplitted, String rutaRoms) throws MalformedURLException, IOException{
		URL url = new URL("http://thegamesdb.net/banners/" + portada);
		URLConnection uc = url.openConnection();
		uc.addRequestProperty("User-Agent", 
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		InputStream in = uc.getInputStream();
		try {
			Files.copy(in, Paths.get(rutaRoms + System.getProperty("file.separator") + "downloaded_images" + 
					System.getProperty("file.separator") + portdaSplitted));
		} catch(FileAlreadyExistsException faex){
			System.out.println("Portada ya descargada, juego multidisco");
		}
	}
	
	
	public String getGameData(String name) throws URISyntaxException{
		String respuesta = null;
		setProperties(properties);
		ResponseHandler<String> respuestaHandler = new BasicResponseHandler();
		URI uri = new URI(getURI(name, URLGETGAMES));
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
	
	public String getGameData(String name, String platform) throws URISyntaxException{
		name = replacesName(name);
		String respuesta = null;
		setProperties(properties);
		ResponseHandler<String> respuestaHandler = new BasicResponseHandler();
		URI uri = new URI(getURI(name, properties.getProperty(platform), URLGETGAMES));
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
	
	
	public String getGameList(String name, String platform) throws URISyntaxException{
		String respuesta = null;
		setProperties(properties);
		ResponseHandler<String> respuestaHandler = new BasicResponseHandler();
		URI uri = new URI(getURI(name, properties.getProperty(platform), URLGETGAMELIST));
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
	
	private String getURI(String name, String uri){
		String initURI = uri;
		StringBuilder sb = new StringBuilder();
		sb.append(initURI.replaceFirst("#1", name));
		return sb.toString();
	}
	
	private String getURI(String name, String platform, String uri){
		String initURI = uri;
		initURI = initURI.replaceFirst("#1", name);
		initURI = initURI.replaceFirst("#2", platform);
		return initURI;
	}
	
	private String replacesName(String name){
		if(name.contains(" ") || name.contains(":") || name.contains("-")){
			String nname = "";
			if(name.contains(" ")){
				nname = name.replace(" ", "%20");
			} else if(nname.contains(":")){
				nname = nname.replace(":", "%3A");
			} else if(nname.contains("-")){
				nname = nname.replace("-", "%2D");
			}
			return nname;
		}
		return name;
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
