package gamelist.file;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import gamelist.http.Get;


public class GameListFile {
	
	private String estructura;
	private Properties xslt, properties;
	
	public GameListFile(Properties xslt){
		byte[] encoded = null;
		this.xslt = xslt;
		try {
			encoded = Files.readAllBytes(Paths.get("/home/jake/workspace/GameList/xslt/GameList.xml"));
			estructura =  new String(encoded, "UTF-8");
			getKeys(xslt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String sustituir(){
		Set<Object> keys = getKeys(xslt);
		Iterator<Object> it = keys.iterator();
		String estructuraBase = new String(estructura);
		while(it.hasNext()){
			String itString = (String) it.next();
			//si es la imagen prepara la ruta y la descarga
			if(itString.equals("Portada")){
				try {
					String[] portdaSplitted = xslt.getProperty(itString).split("/");
					estructuraBase = estructuraBase.replace("$" + itString, portdaSplitted[3]);
					Get g = new Get();
					g.downloadImagen(xslt.getProperty(itString), portdaSplitted[3]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				estructuraBase = estructuraBase.replace("$" + itString, xslt.getProperty(itString));

			}
		}
		System.out.println(estructuraBase);
		return estructuraBase;
		
	}
	
	

	
	private Set<Object> getKeys(Properties props){
		Set<Object> keys = props.keySet();
		return keys;
	}

}
