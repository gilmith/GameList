package gamelist.xslt;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Transformacion {
	
	private StreamSource sourceinput, xsltinput;
	private Source source;
	private Transformer transformer;
	
	
	public Transformacion(String xmlinput, String xsltfilepath){
		sourceinput = new StreamSource(new File("/home/jake/workspace/GameList/xslt/Parasite_Eve.xml"));
		xsltinput = new StreamSource(new File(xsltfilepath));
	    TransformerFactory factory = TransformerFactory.newInstance();
	    try {
			transformer = factory.newTransformer(xsltinput);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	
	public Transformacion(File string2File, String xsltfilepath) {
		sourceinput = new StreamSource(string2File);
		xsltinput = new StreamSource(new File(xsltfilepath));
	    TransformerFactory factory = TransformerFactory.newInstance();
	    try {
			transformer = factory.newTransformer(xsltinput);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}


	public InputStream trans(){
		StringWriter writer = new StringWriter();
	    StreamResult result = new StreamResult(writer);
	    InputStream stream = null;
	    try {
			transformer.transform(sourceinput, result);
			stream = new ByteArrayInputStream(result.getWriter().toString().getBytes());
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return stream;
	}
}
	
	
	
	
	
	
	
	
