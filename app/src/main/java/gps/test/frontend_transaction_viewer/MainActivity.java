package gps.test.frontend_transaction_viewer;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    JSONObject transactionJson;
    TextView responseText;
    TextView request_log;
    final String URL = "https://backend-transaction-viewer.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseText = (TextView) findViewById(R.id.response);
        request_log = (TextView) findViewById(R.id.request_log);
    }


    public void onGenerateRequestClick(View view) {

        Transaction transaction = new Transaction();
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            responseText.setText("Waiting For Server to Respond");
            transactionJson = MessageJson.messageData(transaction);
            request_log.setText(transactionJson.toString());

            new authenticateTransaction().execute(transactionJson.toString());

        } else {
            responseText.setText("There is a problem connecting to the Network");
        }
    }

    private class authenticateTransaction extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... transactionString) {
            try {
                ConnectToServer responseString = new ConnectToServer();
                return responseString.getResponse(URL, transactionString[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return "Unable to retrieve response from Server";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            responseText.setText(result);
        }
    }
}
