package kiosk;

import data.IrisScan;
import mocks.ForbiddenIrisScanner;
import mocks.ForbiddenMailerService;
import mocks.ForbiddenSignatureService;
import mocks.ForbiddenValidationService;
import mocks.ForbiddenVotePrinter;
import mocks.ForbiddenVotesDB;
import mocks.ValidationServiceOkay;
import mocks.ValidationServiceWrong;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author rav3
 */
public class VotingMachineActivateEmisionTests {

    private VotingMachine votingMachine;

    public VotingMachineActivateEmisionTests() {
    }

    @Before
    public void setUpVotingMachine() {
        votingMachine = new VotingMachine();
        votingMachine.setValidationService(new ForbiddenValidationService());
        votingMachine.setVotePrinter(new ForbiddenVotePrinter());
        votingMachine.setVotesDB(new ForbiddenVotesDB());
        votingMachine.setSignatureService(new ForbiddenSignatureService());
        votingMachine.setMailerService(new ForbiddenMailerService());
        votingMachine.setIrisScanner(new ForbiddenIrisScanner());
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

    @Test
    public void activateEmissionWithIrisScan() {
        votingMachine.setValidationService(new ValidationServiceOkay());
        FakeIrisScanner irisScanner = new FakeIrisScanner();
        votingMachine.setIrisScanner(irisScanner);

        IrisScan iris = new IrisScan(new byte[]{1, 2, 3, 4, 5});
        ActivationCard card = new ActivationCard("some_code");
        card.setIrisScan(iris);
        votingMachine.activateEmission(card);
        assertTrue("Iris not scanned", irisScanner.scanned);
        assertTrue("Card not activated", votingMachine.canVote());
    }

    @Test
    public void activateEmissionWithIrisScanCodesNotMatching() {
        votingMachine.setValidationService(new ValidationServiceOkay());
        FakeIrisScanner irisScanner = new FakeIrisScanner();
        votingMachine.setIrisScanner(irisScanner);

        IrisScan iris = new IrisScan(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        ActivationCard card = new ActivationCard("some_code");
        card.setIrisScan(iris);
        votingMachine.activateEmission(card);
        assertTrue("Iris not scanned", irisScanner.scanned);
        assertFalse("Card not activated", votingMachine.canVote());
    }

    private static class FakeIrisScanner extends ForbiddenIrisScanner {

        public boolean scanned = false;

        @Override
        public IrisScan scan() {
            scanned = true;
            IrisScan iris = new IrisScan(new byte[]{1, 2, 3, 4, 5});
            return iris;
        }

    }

}
