/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author rav3
 */
public class ActivationCardTest {
    
    private ActivationCard activationCard;
    
    public ActivationCardTest() {
    }

    @Before
    public void setUp() {
        activationCard = new ActivationCard("activation_code");
    }
    
    @Test
    public void newActivationCardIsActive() {
        assertTrue(activationCard.isActive());
    }
    
    @Test
    public void activationCardCreatedWithCorrectCode() {
        String expected = "activation_code";
        String actual = activationCard.getCode();
        assertEquals(expected, actual);
    }
    
    @Test
    public void activationCardIsNotActive() {
        activationCard.erase();
        assertTrue(!activationCard.isActive());
    }
    
    @Test
    public void erasedCodeIsNull() {
        activationCard.erase();
        String expected = null;
        String actual = activationCard.getCode();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testEqualsDifferentCodes() {
        ActivationCard activationCard2 = new ActivationCard("different_code");
        assertFalse(activationCard.equals(activationCard2));
    }
    
    @Test
    public void testEqualsSameCodes() {
        ActivationCard activationCard2 = new ActivationCard("activation_code");
        assertTrue(activationCard.equals(activationCard2));
    }
    
}
