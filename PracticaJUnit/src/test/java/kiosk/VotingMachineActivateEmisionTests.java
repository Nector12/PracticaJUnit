package kiosk;

import mocks.ForbiddenMailerService;
import mocks.ForbiddenSignatureService;
import mocks.ForbiddenVotePrinter;
import mocks.ForbiddenVotesDB;
import mocks.ValidationServiceOkay;
import mocks.ValidationServiceWrong;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author rav3
 */
public class VotingMachineActivateEmisionTests {

    private VotingMachine votingMachine;

    public VotingMachineActivateEmisionTests() {
        votingMachine = new VotingMachine();
    }

    @Test
    public void correctlyActivatedEmission() {
        votingMachine.setValidationService(new ValidationServiceOkay());
        votingMachine.setVotePrinter(new ForbiddenVotePrinter());
        votingMachine.setVotesDB(new ForbiddenVotesDB());
        votingMachine.setSignatureService(new ForbiddenSignatureService());
        votingMachine.setMailerService(new ForbiddenMailerService());
        votingMachine.activateEmission(new ActivationCard("valid_code"));
        assertTrue(votingMachine.canVote());
    }

    @Test
    public void errorActivatingEmissionInvalidCode() {
        votingMachine.setValidationService(new ValidationServiceWrong());
        votingMachine.setVotePrinter(new ForbiddenVotePrinter());
        votingMachine.setVotesDB(new ForbiddenVotesDB());
        votingMachine.setSignatureService(new ForbiddenSignatureService());
        votingMachine.setMailerService(new ForbiddenMailerService());
        votingMachine.activateEmission(new ActivationCard("invalid_code"));
        assertFalse(votingMachine.canVote());
    }

}
