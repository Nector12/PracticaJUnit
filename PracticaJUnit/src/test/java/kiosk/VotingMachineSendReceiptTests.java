package kiosk;

import data.Vote;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import services.VotePrinter;

/**
 *
 * @author rav3
 */
public class VotingMachineSendReceiptTests {

    VotingMachine votingMachine;

    public VotingMachineSendReceiptTests() {
    }

    @Before
    public void setUpVotingMachine() {
        this.votingMachine = new VotingMachine();
    }

    @Test
    public void cannotSendIfMachineNotActivated() {

    }

    @Test
    public void cannotSendIfNotVoted() {

    }

    @Test
    public void sentToCorrectAddress() {

    }

    @Test
    public void sentCorrectSignature() {
    
    }

}
