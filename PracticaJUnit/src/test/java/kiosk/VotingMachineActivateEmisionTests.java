package kiosk;

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
        votingMachine.activateEmission(new ActivationCard("valid_code"));
        assertTrue(votingMachine.canVote());
    }

    @Test
    public void errorActivatingEmissionInvalidCode() {
        votingMachine.setValidationService(new ValidationServiceWrong());
        votingMachine.activateEmission(new ActivationCard("invalid_code"));
        assertFalse(votingMachine.canVote());
    }

}
