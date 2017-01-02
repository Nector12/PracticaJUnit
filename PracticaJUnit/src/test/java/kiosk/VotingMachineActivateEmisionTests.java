package kiosk;

import mocks.ForbiddenValidationService;
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
        assertTrue(votingMachine.isActivated());
    }

    @Test
    public void errorActivatingEmissionInvalidCode() {
        votingMachine.setValidationService(new ValidationServiceWrong());
        votingMachine.activateEmission(new ActivationCard("invalid_code"));
        assertFalse(votingMachine.isActivated());
    }

    /*
    Mock implementations of ValidationService
     */
    private static class ValidationServiceOkay
            extends ForbiddenValidationService {

        @Override
        public boolean validate(ActivationCard card) {
            return true;
        }

    }

    private static class ValidationServiceWrong
            extends ForbiddenValidationService {

        @Override
        public boolean validate(ActivationCard card) {
            return false;
        }

    }

}
