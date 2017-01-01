package data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rav3
 */
public class MailAddressTest {
    
    public MailAddressTest() {
    }

    /**
     * Test of hashCode method, of class MailAddress.
     */
    @Test
    public void sameHashcodeForEqualAddresses() {
        MailAddress address = new MailAddress("address");
        MailAddress sameAddress = new MailAddress("address");
        assertEquals(address.hashCode(), sameAddress.hashCode());
    }
    
    @Test
    public void testEquals() {
        MailAddress address = new MailAddress("address");
        MailAddress sameAddress = new MailAddress("address");
        assertTrue(address.equals(sameAddress));
    }
    
}
