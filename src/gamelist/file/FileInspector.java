package gamelist.file;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class FileInspector {
	
	private File file;
	private File[] arrayFiles;
	
	public FileInspector(String path){
		File file = new File(path);
		arrayFiles = FileUtils.convertFileCollectionToFileArray(
				FileUtils.listFilesAndDirs(file, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE));
		
		
	}
	

	
	public ArrayList<String> getGameListStorage(){
		ArrayList<String> listado = new ArrayList<String>();
		for(File f : arrayFiles){
			String fname = f.getName();
			String nname = fname.replaceAll(" ", "%20");
			fname = nname.replaceFirst("(Disc *)", "");
			listado.add(fname);		
		}
		return listado;
	}
}
