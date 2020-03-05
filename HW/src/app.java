import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
public class app {
	public static void main(String[] args) {
		
		ValMod("0422");
	}
	
	public static void ValMod(String PersonId) {
		

        try{
           
           File folder = new File("C:\\HCM");
           File[] listOfFiles = folder.listFiles();

           for (int i = 0; i < listOfFiles.length; i++) {
             if (listOfFiles[i].isFile()) {
              muestraContenido(folder + "\\" + listOfFiles[i].getName(), PersonId);
             }
           }
        }catch(IOException exp){
            System.out.println("Error while reading file " + exp.getMessage());
        }        	
	}
	
    public static void muestraContenido(String archivo, String PersonId) throws FileNotFoundException, IOException {
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
 	   int count = 0;
 	   boolean del = false;
       String strLine;
        while((strLine = b.readLine())!=null) {
        	
        	 if (count > 0) {
     	        String[] data = strLine.split("\\|");
     	        if (PersonId.equals(data[0])) {
     	        	System.out.println("Es Igual");
     	        	del = true;
     	        	    
     	        	}
     	    }
     	    ++count;
        }
        b.close();

		if (del)
		{
	        File file = new File(archivo);
		  if(file.delete()) 
         { 
             System.out.println("File deleted successfully"); 
         } 
         else
         { 
             System.out.println("Failed to delete the file"); 
         }      
    }
    }
	

}