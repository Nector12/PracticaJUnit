package kiosk;

import mocks.ForbiddenIrisScanner;
import mocks.ForbiddenMailerService;
import mocks.ForbiddenSignatureService;
import mocks.ForbiddenVotePrinter;
import mocks.ForbiddenVotesDB;
import mocks.ValidationServiceOkay;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author rav3
 */
public class VotingMachineCanVoteTests {

    private VotingMachine votingMachine;

    public VotingMachineCanVoteTests() {
    }

    @Before
    public void setUpVotingMachine() {
        votingMachine = new VotingMachine();
        votingMachine.setValidationService(new ValidationServiceOkay());
        votingMachine.setVotePrinter(new ForbiddenVotePrinter());
        votingMachine.setVotesDB(new ForbiddenVotesDB());
        votingMachine.setSignatureService(new ForbiddenSignatureService());
        votingMachine.setMailerService(new ForbiddenMailerService());
        votingMachine.setIrisScanner(new ForbiddenIrisScanner());
    }

    @Test
    public void voterCanVote() {
        votingMachine.activateEmission(new ActivationCard("valid_code"));
        assertTrue(votingMachine.canVote());
    }

    @Test
    public void voterCannotVoteEmissionNotActivated() {
        assertFalse(votingMachine.canVote());
    }

    @Test(expected = IllegalStateException.class)
    public void cannotActivateTwice() {
        ActivationCard card = new ActivationCard("valid_code");
        votingMachine.activateEmission(card);
        votingMachine.activateEmission(card);
    }

}
