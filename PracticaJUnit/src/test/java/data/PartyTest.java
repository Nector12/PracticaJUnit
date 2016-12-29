package data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rav3
 */
public class PartyTest {
    
    public PartyTest() {
    }

    /**
     * Test of hashCode method, of class Party.
     */
    @Test
    public void same_hashcode_for_equal_parties() {
        Party party = new Party("Party");
        Party sameParty = new Party("Party");
        assertEquals(party.hashCode(), sameParty.hashCode());
    }

    /**
     * Test of equals method, of class Party.
     */
    @Test
    public void testEquals() {
        Party party = new Party("Party");
        Party sameParty = new Party("Party");
        assertTrue(party.equals(sameParty));
    }
    
}
