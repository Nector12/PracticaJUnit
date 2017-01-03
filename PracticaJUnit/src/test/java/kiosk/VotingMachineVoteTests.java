package kiosk;

import data.Vote;
import mocks.ForbiddenValidationService;
import mocks.ForbiddenVotesDB;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import services.VotePrinter;

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
        VotesDBOkay votesDB = new VotesDBOkay();
        votingMachine.setValidationService(new ValidationServiceOkay());
        votingMachine.setVotesDB(votesDB);
        votingMachine.setVotePrinter(new VotePrinterFake());
        votingMachine.activateEmission(new ActivationCard("valid_code"));
        votingMachine.vote(vote);
        assertEquals(vote, votesDB.vote);
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
        votingMachine.setVotesDB(new VotesDBOkay());
        votingMachine.setVotePrinter(new VotePrinterFake());
        votingMachine.activateEmission(new ActivationCard("valid_code"));
        votingMachine.vote(vote);
        votingMachine.vote(vote);
    }
    
    @Test
    public void codeFromActivationCardErased() {
        ActivationCard card = new ActivationCard("valid_code");
        votingMachine.setValidationService(new ValidationServiceOkay());
        votingMachine.setVotesDB(new VotesDBOkay());
        votingMachine.setVotePrinter(new VotePrinterFake());
        votingMachine.activateEmission(card);
        votingMachine.vote(new Vote("any_party"));
        assertNull(card.getCode());
    }
    
    @Test
    public void voteIsPrinted() {
        VotePrinterFake votePrinter = new VotePrinterFake();
        votingMachine.setValidationService(new ValidationServiceOkay());
        votingMachine.setVotesDB(new VotesDBOkay());
        votingMachine.setVotePrinter(votePrinter);
        votingMachine.activateEmission(new ActivationCard("valid_code"));
        votingMachine.vote(new Vote("any_party"));
        assertTrue(votePrinter.printed);
    }

    /*
    Mocks for services used in tests
    */
    private static class ValidationServiceOkay
            extends ForbiddenValidationService {

        @Override
        public boolean validate(ActivationCard card) {
            return true;
        }
        
        @Override
        public void deactivate(ActivationCard card) {
            card.erase();
        }

    }
    
    private static class VotesDBOkay
            extends ForbiddenVotesDB {

        Vote vote;
        
        @Override
        public void registerVote(Vote vote) {
            this.vote = vote;
        }
        
    }
    
    private static class VotePrinterFake
            implements VotePrinter {

        boolean printed = false;
        
        @Override
        public void print(Vote vote) {
            this.printed = true;
        }
    }
}
