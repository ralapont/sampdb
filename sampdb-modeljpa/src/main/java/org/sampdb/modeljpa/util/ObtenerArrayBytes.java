package org.sampdb.modeljpa.util;

import java.io.File;
import java.io.FileInputStream;

import javax.swing.JOptionPane;

public class ObtenerArrayBytes {
	
	public byte[] obtenerBlob(String fichero) {
		//byte[] userimage = null;
	    //Blob blob = null;
		byte[] bFile = null;
		
	    try{
			File image = new File(fichero); 
			bFile = new byte[(int) image.length()];
			
			FileInputStream fileInputStream = new FileInputStream(image);
			
		    fileInputStream.read(bFile);
		    fileInputStream.close();
		     
			//blob = new SerialBlob(userimage);
	    
	    }
	    catch(Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }    		
		
	    return bFile;
	}
}
