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
