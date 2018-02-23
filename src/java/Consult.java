
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
public class Consult {

    public String strNit;
    private String dirSales = "sales";

    public String getCredit(String nit) {
        return getData(nit);
    }

    public String getCloseDay() {
        return getDataStr();
    }

    public String getData(String nit){
        //Obtiene datos
        Filemanager f = new Filemanager();
        String jsonString = f.getAll(System.getProperty("user.dir") + "\\" + dirSales + "\\");
        ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            if (jsonArray != null && jsonArray.length() > 0) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONArray jsonArraySon = jsonArray.getJSONArray(i);                    
                    if (jsonArraySon != null && jsonArraySon.length() > 0) {                        
                        for (int j = 0; j < jsonArraySon.length(); j++) {                            
                            JSONObject childJsonArray = jsonArraySon.getJSONObject(j);
                            HashMap<String, String> articulo = new HashMap<String, String>();
                            if (childJsonArray != null && childJsonArray.length() > 0) {
                                String nitData = childJsonArray.get("nit").toString();
                                if (nitData.equals(nit)){
                                    articulo.put("name", childJsonArray.get("name").toString());
                                    articulo.put("nit", childJsonArray.get("nit").toString());
                                    articulo.put("product", childJsonArray.get("product").toString());
                                    articulo.put("idType", childJsonArray.get("idType").toString());
                                    articulo.put("type", childJsonArray.get("type").toString());
                                    articulo.put("credit", childJsonArray.get("credit").toString());
                                    articulo.put("code", childJsonArray.get("code").toString());
                                    articulo.put("quantity", childJsonArray.get("quantity").toString());
                                    articulo.put("price", childJsonArray.get("price").toString());
                                    articulo.put("total", childJsonArray.get("total").toString());
                                    //Agrega el articulo
                                    dataList.add(articulo);
                                }                                                                
                            }                            
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
                
        //Convierte listarray a json
        List<JSONObject> jsonObj = new ArrayList<JSONObject>();
        for(HashMap<String, String> data : dataList) {
            JSONObject obj = new JSONObject(data);
            jsonObj.add(obj);
        }
        JSONArray test = new JSONArray(jsonObj);
        return test.toString();
    }

    public String getDataStr() {
        Filemanager f = new Filemanager();
        String jsonString = f.getAll(System.getProperty("user.dir") + "\\" + dirSales + "\\");
        return jsonString;
    }
}
