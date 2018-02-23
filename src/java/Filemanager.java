
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 ©2018 All Rights Reserved. Jonnatan Gomez. 

 Autor      : Austro
 Hora      : 21/02/2018 11:55:55 PM
 Email      : jonnatan.gomez1.6180@gmail.com
 */
/**
 *
 * @author Austro
 */
public class Filemanager {

    public String getAll(String strDir) {
        String res = "";
        final File f = new File(strDir);
        File[] ficheros = f.listFiles();
        for (int x = 0; x < ficheros.length; x++) {
            String strFile = ficheros[x].getName();
            String content = "";
            File file = new File(strDir + strFile); //for ex foo.txt
            FileReader reader = null;
            try {
                reader = new FileReader(file);
                char[] chars = new char[(int) file.length()];
                reader.read(chars);
                content = new String(chars);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Filemanager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                res += (res.equals("") ? "" : ",") + content;
            }
        }
        return "["+res+"]";
    }   

    public boolean post(String strDirname, String strDataJson) {
        //System.getProperty returns absolute path
        File f = new File(strDirname);
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        //Remove if clause if you want to overwrite file
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            //dir will change directory and specifies file name for writer
            File dir = new File(f.getParentFile(), f.getName());
            PrintWriter writer = new PrintWriter(dir);
            writer.print(strDataJson);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
