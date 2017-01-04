package kiosk;

import data.Vote;
import mocks.ValidationServiceOkay;
import mocks.VotePrinterFake;
import mocks.VotesDBFake;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rav3
 */
public class VotingMachineVoteTests {

    private VotingMachine votingMachine;

    public VotingMachineVoteTests() {

    }

    @Before
    public void setUpVotingMachine() {
        votingMachine = new VotingMachine();
    }

    @Test
    public void voteRegisteredCorrectly() {
        Vote vote = new Vote("any_party");
        VotesDBFake votesDB = new VotesDBFake();
        votingMachine.setValidationService(new ValidationServiceOkay());
        votingMachine.setVotesDB(votesDB);
        votingMachine.setVotePrinter(new VotePrinterFake());
        votingMachine.activateEmission(new ActivationCard("valid_code"));
        votingMachine.vote(vote);
        assertEquals(vote, votesDB.lastVote);
    }

    @Test(expected = IllegalStateException.class)
    public void cannotVoteIfMachineNotActivated() {
        Vote vote = new Vote("any_party");
        votingMachine.vote(vote);
    }

    @Test(expected = IllegalStateException.class)
    public void cannotVote2Times() {
        Vote vote = new Vote("any_party");
        votingMachine.setValidationService(new ValidationServiceOkay());
        votingMachine.setVotesDB(new VotesDBFake());
        votingMachine.setVotePrinter(new VotePrinterFake());
        votingMachine.activateEmission(new ActivationCard("valid_code"));
        votingMachine.vote(vote);
        votingMachine.vote(vote);
    }

    @Test
    public void codeFromActivationCardErased() {
        ActivationCard card = new ActivationCard("valid_code");
        votingMachine.setValidationService(new ValidationServiceOkay());
        votingMachine.setVotesDB(new VotesDBFake());
        votingMachine.setVotePrinter(new VotePrinterFake());
        votingMachine.activateEmission(card);
        votingMachine.vote(new Vote("any_party"));
        assertNull(card.getCode());
    }

    @Test
    public void voteIsPrintedOneTime() {
        VotePrinterFake votePrinter = new VotePrinterFake();
        votingMachine.setValidationService(new ValidationServiceOkay());
        votingMachine.setVotesDB(new VotesDBFake());
        votingMachine.setVotePrinter(votePrinter);
        votingMachine.activateEmission(new ActivationCard("valid_code"));
        votingMachine.vote(new Vote("any_party"));
        assertEquals(votePrinter.printed, 1);
    }
    
    @Test
    public void consecutiveVaildVotes() {
        VotesDBFake votesDB = new VotesDBFake();
        votingMachine.setValidationService(new ValidationServiceOkay());
        votingMachine.setVotesDB(votesDB);
        votingMachine.setVotePrinter(new VotePrinterFake());
        
        // First Vote
        votingMachine.activateEmission(
                new ActivationCard("valid_code"));
        votingMachine.vote(new Vote("any_party"));
        
        // Second Vote
        Vote vote2 = new Vote("any_party");
        votingMachine.activateEmission(
                new ActivationCard("another_valid_corde"));
        votingMachine.vote(vote2);
        if(votesDB.nVotes < 2) {
            fail("Less than 2 votes registered");
        } else if(votesDB.nVotes > 2) {
            fail("More than 2 votes registered");
        }
        assertEquals(vote2, votesDB.lastVote);
    }

}
