package data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rav3
 */
public class VoteTest {
    
    public VoteTest() {
    }

    /**
     * Test of hashCode method, of class Vote.
     */
    @Test
    public void sameHashcodeForEqualVotes() {
        Vote vote = new Vote("Party 1");
        Vote sameVote = new Vote("Party 1");
        assertEquals(vote.hashCode(), sameVote.hashCode());
    }

    /**
     * Test of equals method, of class Vote.
     */
    @Test
    public void testEquals() {
        Vote vote = new Vote("Party 1");
        Vote sameVote = new Vote("Party 1");
        assertTrue(vote.equals(sameVote));
    }
    
}
