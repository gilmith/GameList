package gamelist.exe;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Properties;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import gamelist.file.FileInspector;
import gamelist.file.GameListFile;
import gamelist.file.Utils;
import gamelist.http.Get;
import gamelist.xslt.Transformacion;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class MainExecutor {
	
	private static Log log = LogFactory.getLog(MainExecutor.class);
	

	public static void main(String[] args) {
		Get get = new Get();
		String consulta;
		try {
			consulta = get.getGameData("Parasite%20Eve");
			log.debug(consulta);
			genGameList(consulta);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void genGameList(String consulta){
		Transformacion transformacion = new Transformacion(Utils.string2File(consulta), "/home/jake/workspace/GameList/xslt/GetGameData.xsl");		
		Properties props = new Properties();
		try {
			props.load(transformacion.trans());
			GameListFile glf = new GameListFile(props);
			glf.sustituir();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
