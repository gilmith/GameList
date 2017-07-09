package gamelist.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import gamelist.file.GameListFile;
import gamelist.file.Utils;
import gamelist.http.Get;
import gamelist.xslt.Transformacion;

public class GamesDBController {
	
	private String consulta, gameList;
	private Get get;
	private Properties proper;

	public GamesDBController() {
		get = new Get();
		proper = new Properties();
		setProperties(proper);
	}

	private String genGameList(String consulta, String filename, String title, 
			String rutaGameList, String rutaRoms){
		Transformacion transformacion = new Transformacion(Utils.string2File(consulta, proper.getProperty("temp.path")), proper.getProperty("xsl"), title);		
		Properties props = new Properties();
		try {
			props.load(transformacion.trans());
			props.put("path", filename);
			GameListFile glf = new GameListFile(props,proper.getProperty("estructuraBase"));
			return glf.sustituir(rutaGameList, rutaRoms);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String getConsulta() {
		return consulta;
	}
	
	
	public String getGameList() {
		return gameList;
	}
	
	
	public String procesa(FolderController folderController, String rutaGameList, String rutaRoms) {
		StringBuilder sb = new StringBuilder("<? xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		ArrayList<String> nombres = folderController.getNombres();
		ArrayList<String> ficheros = folderController.getFicheros();
		for(String s : nombres){
			System.out.println("consultando para el juego " + s);
			try {
				consulta = get.getGameData(s,folderController.getPlatform());
				sb.append(genGameList(consulta,s, s, rutaGameList, rutaRoms));
				System.out.println(sb.toString());
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		try {
			FileUtils.writeStringToFile(new File(rutaGameList),  sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
