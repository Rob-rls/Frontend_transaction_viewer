package gps.test.frontend_transaction_viewer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class Transaction {

    String userId = "bob";

    public HashMap userData() {
        HashMap<String, Object> userDataMap = new HashMap<String, Object>();
        userDataMap.put("userId", userId);
        return userDataMap;
    }

    public HashMap transactionData() {
        HashMap transactionDataMap = new HashMap();
        transactionDataMap.put("type", getTransactionType());
        transactionDataMap.put("time", getTime());
        return transactionDataMap;
    }

    private String getTransactionType() {
        String[] types = {"login", "payment"};
        Random rand = new Random();
        return types[rand.nextInt(2)];
    }

    private String getTime() {
        SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.UK);
        return formattedDate.format(new Date());
    }

    public HashMap locationData() {
        HashMap locationDataMap = new HashMap();
        locationDataMap.put("longitude", getLoc());
        locationDataMap.put("latitide", getLoc());
        return locationDataMap;
    }

    private Double getLoc() {
        return Math.random() * 100;
    }

    public HashMap deviceData() {
        HashMap deviceDataMap = new HashMap();
        deviceDataMap.put("type", getPhoneType());
        deviceDataMap.put("os", "Android");
        deviceDataMap.put("model", "Nexus6");
        return deviceDataMap;
    }

    private String getPhoneType() {
        String[] types = {"smart_phone", "feature_phone", "browser"};
        Random rand = new Random();
        return types[rand.nextInt(3)];
    }


}
