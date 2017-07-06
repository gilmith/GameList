package gamelist.exe;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import gamelist.file.FileInspector;
import gamelist.file.GameListFile;
import gamelist.file.Utils;
import gamelist.http.Get;
import gamelist.xslt.Transformacion;



public class MainExecutor {
	
	private static Log log = LogFactory.getLog(MainExecutor.class);
	

	public static void main(String[] args) throws IOException {
		Get get = new Get();
		String consulta;
		try {
			FileInspector fi = new FileInspector("/mnt/seagate/raspberry/roms/psx/");
			ArrayList<String> nombres = fi.getGameListStorage();
			ArrayList<String> ficheros = fi.getGameFileName();
			StringBuilder sb = new StringBuilder("<? xml version=\"1.0\" encoding=\"UTF-8\" ?>");
			for(String s : nombres){
				System.out.println("consultando para el juego " + s);
				consulta = get.getGameData(s,fi.getPlatform());
//				ArrayList<Integer> posiciones = buscaCoincidencias(ficheros, s);
				sb.append(genGameList(consulta,s, s));
//				for(Integer i : posiciones){
//					System.out.println("consultando para el gengame " + s);
//					sb.append(genGameList(consulta,ficheros.get(i), s));
//				}
			}
			FileUtils.writeStringToFile(new File("/mnt/seagate/raspberry/roms/psx/gameListJacobo.xml"), sb.toString());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static String genGameList(String consulta, String filename, String title){
		Transformacion transformacion = new Transformacion(Utils.string2File(consulta), "/home/jake/workspace/GameList/xslt/GetGameData.xsl", title);		
		Properties props = new Properties();
		try {
			props.load(transformacion.trans());
			props.put("path", filename);
			GameListFile glf = new GameListFile(props);
			return glf.sustituir();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	private static ArrayList<Integer> buscaCoincidencias(ArrayList<String> ficheros, String s){
		ArrayList<Integer> posiciones = new ArrayList<Integer>();
		for(String fichero : ficheros){
			if(fichero.contains(s)){
				posiciones.add((Integer)ficheros.indexOf(fichero));
			}
		}
		return posiciones;
	}
	
	
}
