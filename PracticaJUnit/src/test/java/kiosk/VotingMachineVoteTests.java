package kiosk;

import data.Vote;
import java.util.ArrayList;
import java.util.List;
import mocks.ForbiddenValidationService;
import mocks.ForbiddenVotesDB;
import org.junit.Before;
import org.junit.Test;
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
    }
    
    @Test(expected = IllegalStateException.class)
    public void cannotVote2Times() {
        Vote vote = new Vote("Party 1");
        votingMachine.setValidationService(new ValidationServiceOkay());
        votingMachine.setVotesDB(new VotesDBOkay());
        votingMachine.setVotePrinter(new VotePrinterFake());
        votingMachine.activateEmission(new ActivationCard("activation_code"));
        votingMachine.vote(vote);
        votingMachine.vote(vote);
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
