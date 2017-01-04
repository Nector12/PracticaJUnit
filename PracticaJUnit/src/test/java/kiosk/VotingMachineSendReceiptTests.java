package kiosk;

import data.MailAddress;
import data.Signature;
import data.Vote;
import mocks.MailerServiceFake;
import mocks.SignatureServiceFake;
import mocks.ValidationServiceOkay;
import mocks.VotePrinterFake;
import mocks.VotesDBFake;
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
        this.votingMachine.setValidationService(new ValidationServiceOkay());
        this.votingMachine.setVotesDB(new VotesDBFake());
        this.votingMachine.setVotePrinter(new VotePrinterFake());
    }

    @Test(expected = IllegalStateException.class)
    public void cannotSendIfMachineNotActivated() {
        this.votingMachine.sendReceipt(new MailAddress("any_address"));        
    }

    @Test(expected = IllegalStateException.class)
    public void cannotSendIfNotVoted() {
        this.votingMachine.activateEmission(new ActivationCard("valid_code"));
        this.votingMachine.sendReceipt(new MailAddress("any_address"));
    }

    @Test
    public void sentToCorrectAddress() {
        MailerServiceFake mailerService = new MailerServiceFake();
        SignatureServiceFake signatureService = new SignatureServiceFake();
        this.votingMachine.setMailerService(mailerService);
        this.votingMachine.setSignatureService(signatureService);
        
        MailAddress address = new MailAddress("any_address");
        
        this.votingMachine.activateEmission(new ActivationCard("valid_code"));
        this.votingMachine.vote(new Vote("any_party"));
        this.votingMachine.sendReceipt(address);
        assertEquals(address, mailerService.address);
    }

    @Test
    public void sentCorrectSignature() {
        MailerServiceFake mailerService = new MailerServiceFake();
        SignatureServiceFake signatureService = new SignatureServiceFake();
        this.votingMachine.setMailerService(mailerService);
        this.votingMachine.setSignatureService(signatureService);
        
        Signature expected = new Signature(
                new byte[]{1,2,3,4,5,6,7,8,9});
        
        this.votingMachine.activateEmission(new ActivationCard("valid_code"));
        this.votingMachine.vote(new Vote("any_party"));
        this.votingMachine.sendReceipt(new MailAddress("any_address"));
        assertEquals(expected, mailerService.signature);
    }

}
