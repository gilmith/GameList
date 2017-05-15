package gamelist.file;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class FileInspector {
	
	private File file;
	private File[] arrayFiles;
	private String platform = null;
	
	public FileInspector(String path){
		File file = new File(path);
		arrayFiles = FileUtils.convertFileCollectionToFileArray(
				FileUtils.listFilesAndDirs(file, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE));
		
	}
	

	
	public ArrayList<String> getGameListStorage(){
		ArrayList<String> listado = new ArrayList<String>();
		for(File f : arrayFiles){
			if(f.isFile() && 
					(f.getName().endsWith(".bin") || f.getName().endsWith("iso"))){
				String fname = f.getName();
				Pattern patron = Pattern.compile("(^[A-Z,a-z,0-9, ,\\-, _, \\']*)");
				Matcher match = patron.matcher(fname);
				if (match.find()){
					fname = match.group(0);
					fname = fname.trim();
				}
				if (!listado.contains(fname)){
					listado.add(fname);
				}
			} else if (!f.isFile()){
				platform = f.getAbsolutePath().split("/")[5];
			}
		}
		return listado;
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



	public String getPlatform() {
		return platform;
	}



	public void setPlatform(String platform) {
		this.platform = platform;
	}
}
