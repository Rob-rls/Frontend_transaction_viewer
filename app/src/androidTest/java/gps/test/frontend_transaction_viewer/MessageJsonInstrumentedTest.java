package gps.test.frontend_transaction_viewer;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class MessageJsonInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("gps.test.frontend_transaction_viewer", appContext.getPackageName());
    }

    @Test
    public void Message_takes_HashMap_and_returns_JSON() throws Exception {
        HashMap<String, Object> testTransactionMap = new HashMap<String, Object>();
        testTransactionMap.put("name", "Rob");

        MessageJson testMessageJson = new MessageJson();
        String testMessageString = testMessageJson.convertToJSON(testTransactionMap).toString();

        String expectedResult = "{\"name\":\"Rob\"}";

        assertEquals(expectedResult, testMessageString);
    }
}
