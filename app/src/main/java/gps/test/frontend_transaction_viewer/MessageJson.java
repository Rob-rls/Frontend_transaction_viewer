package gps.test.frontend_transaction_viewer;


import org.json.JSONObject;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Set;


public class MessageJson {


    public JSONObject convertToJSON(HashMap<String, Object> transactionData) {
        JSONObject transactionJson = new JSONObject();
        Set setOfKeys = transactionData.keySet();
        for ( Object key : setOfKeys) {
            String stringKey = key.toString();
            try {
                transactionJson.put(stringKey, transactionData.get(stringKey));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return transactionJson;
    }

}

//
//    StringWriter out = new StringWriter();
//
//    JSONObject obj = new JSONObject();
//    LinkedHashMap m1 = new LinkedHashMap();
//    LinkedList l1 = new LinkedList();
//    obj.put("k1", "v1");
//    obj.put("k2", m1);
//    obj.put("k3", l1);
//    m1.put("mk1", "mv1");
//    l1.add("lv1");
//    l1.add("lv2");
//    m1.put("mk2", l1);
//    obj.writeJSONString(out);
//    System.out.println("jsonString:");
//    System.out.println(out.toString());
//    String jsonString = obj.toJSONString();
//    System.out.println(jsonString);