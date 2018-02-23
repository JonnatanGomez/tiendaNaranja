
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

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
public class Sale {

    private HashMap<String, String> articles = new HashMap<>();
    public int credito;
    public String nit;
    public String nombre;
    public String code;
    public float price;
    public int cant;
    
    private String dirSales = "sales";

    public void addArticle(String code) {
        this.code = code;        
    }
    public void save(String json) {
        Filemanager f = new Filemanager();
        Date date = new Date();
        DateFormat formatoFechaHora = new SimpleDateFormat("yyyyMMddHHmmss");          
        f.post(System.getProperty("user.dir")+"\\"+dirSales+"\\"+formatoFechaHora.format(date)+".txt", json);
    }
    public void cancel() {
        articles = null;
    }
}