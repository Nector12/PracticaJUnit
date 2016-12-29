/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nector
 */
public class MailAddressTest {
    
    public MailAddressTest() {
    }

    /**
     * Test of hashCode method, of class MailAddress.
     */
    @Test
    public void same_hashcode_for_equal_addresses() {
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
