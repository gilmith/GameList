package gamelist.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 


public class Utils {
	
	private static Log log = LogFactory.getLog(Utils.class);
	
	
	public static File string2File(String string, String ruta){
		File file = new File(ruta);
		try {
			FileUtils.write(file, string, "UTF-8", false);
		} catch (IOException e) {
			log.error("Error al escribir el fichero con la respuesta", e);
		}
		return file;
		
	}

}
