package kiosk;

import data.MailAddress;
import data.Signature;
import data.Vote;
import mocks.ForbiddenIrisScanner;
import mocks.ForbiddenMailerService;
import mocks.ForbiddenSignatureService;
import mocks.MailerServiceFake;
import mocks.SignatureServiceFake;
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
public class VotingMachineSendReceiptTests {

    VotingMachine votingMachine;

    public VotingMachineSendReceiptTests() {
    }

    @Before
    public void setUpVotingMachine() {
        this.votingMachine = new VotingMachine();
        this.votingMachine.setIrisScanner(new ForbiddenIrisScanner());

    }

    @Test(expected = IllegalStateException.class)
    public void cannotSendIfMachineNotActivated() {
        votingMachine.setValidationService(new ValidationServiceOkay());
        votingMachine.setVotesDB(new VotesDBFake());
        votingMachine.setVotePrinter(new VotePrinterFake());
        votingMachine.setSignatureService(new ForbiddenSignatureService());
        votingMachine.setMailerService(new ForbiddenMailerService());
        votingMachine.sendReceipt(new MailAddress("any_address"));
    }

    @Test(expected = IllegalStateException.class)
    public void cannotSendIfNotVoted() {
        votingMachine.setValidationService(new ValidationServiceOkay());
        votingMachine.setVotesDB(new VotesDBFake());
        votingMachine.setVotePrinter(new VotePrinterFake());
        votingMachine.activateEmission(new ActivationCard("valid_code"));
        votingMachine.setSignatureService(new ForbiddenSignatureService());
        votingMachine.setMailerService(new ForbiddenMailerService());
        votingMachine.sendReceipt(new MailAddress("any_address"));
    }

    @Test
    public void sentToCorrectAddress() {
        MailerServiceFake mailerService = new MailerServiceFake();
        SignatureServiceFake signatureService = new SignatureServiceFake();
        votingMachine.setValidationService(new ValidationServiceOkay());
        votingMachine.setVotesDB(new VotesDBFake());
        votingMachine.setVotePrinter(new VotePrinterFake());
        votingMachine.setMailerService(mailerService);
        votingMachine.setSignatureService(signatureService);

        MailAddress address = new MailAddress("any_address");

        votingMachine.activateEmission(new ActivationCard("valid_code"));
        votingMachine.vote(new Vote("any_party"));
        votingMachine.sendReceipt(address);
        assertEquals(address, mailerService.address);
    }

    @Test
    public void sentCorrectSignature() {
        votingMachine.setValidationService(new ValidationServiceOkay());
        votingMachine.setVotesDB(new VotesDBFake());
        votingMachine.setVotePrinter(new VotePrinterFake());

        MailerServiceFake mailerService = new MailerServiceFake();
        SignatureServiceFake signatureService = new SignatureServiceFake();
        votingMachine.setMailerService(mailerService);
        votingMachine.setSignatureService(signatureService);

        Signature expected = new Signature(
                new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        votingMachine.activateEmission(new ActivationCard("valid_code"));
        votingMachine.vote(new Vote("any_party"));
        votingMachine.sendReceipt(new MailAddress("any_address"));
        assertEquals(expected, mailerService.signature);
    }

}
