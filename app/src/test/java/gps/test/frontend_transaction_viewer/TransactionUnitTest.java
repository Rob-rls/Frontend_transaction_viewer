package gps.test.frontend_transaction_viewer;

import org.junit.Test;
import java.util.HashMap;
import static junit.framework.Assert.assertEquals;

public class TransactionUnitTest {
    @Test
    public void Message_creates_userId() throws Exception {

        Transaction transactionTest = new Transaction();
        HashMap testHashMap = transactionTest.userData();

        assertEquals("bob", testHashMap.get("userId"));
    }
}