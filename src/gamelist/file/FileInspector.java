package gamelist.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class FileInspector {
	
	private File[] arrayFiles;
	private File file;
	private String platform = null;
	private Properties props;
	
	public FileInspector(String path){
		File file = new File(path);
		arrayFiles = FileUtils.convertFileCollectionToFileArray(
				FileUtils.listFilesAndDirs(file, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE));
		props = new Properties();
		setProperties(props);
	}
	

	
	public ArrayList<String> getGameFileName(){
		ArrayList<String> listado = new ArrayList<String>();
		for(File f : arrayFiles){
			if (f.isFile() &&
					(f.getName().endsWith(".bin") || f.getName().endsWith("iso"))){
				listado.add(f.getName());
			}

		}
		return listado;
	}
	
	public ArrayList<String> getGameListStorage(){
		ArrayList<String> listado = new ArrayList<String>();
		for(File f : arrayFiles){
			if(f.isFile() && 
					(extensionesValidas(f.getName()))){
				String fname = f.getName();
				Pattern patron = Pattern.compile("(^[A-Z,a-z,0-9, ,\\-, _, \\',:,!,\\&]*)");
				Matcher match = patron.matcher(fname);
				if (match.find()){
					fname = match.group(0);
					fname = fname.trim();
				}
				if (!listado.contains(fname)){
					listado.add(fname);
				}
			} else if (!f.isFile()){
				if (System.getProperty("os.name").contains("Windows")) {
					//cambiar el 3
					platform = f.getAbsolutePath().split("\\\\")[3];
				} else {
					platform = f.getAbsolutePath().split("/")[3];
				}
			}
		}
		return listado;
	}



	public String getPlatform() {
		return platform;
	}



	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	private boolean extensionesValidas(String nombre) {
		boolean valida = false;
		StringTokenizer st = new StringTokenizer(props.getProperty("extensiones"), ",");
		while(st.hasMoreTokens()) {
			if(nombre.endsWith(st.nextToken())) {
				return !valida;
			}
		}
		return valida;
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
