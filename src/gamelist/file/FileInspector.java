package gamelist.file;

import java.io.File;
import java.util.ArrayList;

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
			if(f.isFile()){
				String fname = f.getName();
				fname = fname.replaceAll("\\(Disc \\d\\)\\.[a-z,A-Z]*", "");
				fname = fname.replaceAll("", "%20");
				listado.add(fname);
			} else {
				platform = f.getName();
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
