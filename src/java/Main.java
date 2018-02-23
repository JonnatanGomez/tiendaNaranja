
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;


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
public class Main {
        
    public void newOperation(String data){
        Sale s = new Sale();
        s.save(data);
    }
    public String getCloseDay(){
        Consult c = new Consult();
        String str = c.getCloseDay();
        return str;
    }
    public String getSaldo(String nit){        
        Consult c = new Consult();
        String str = c.getCredit(nit);
        return str;
    }
}
