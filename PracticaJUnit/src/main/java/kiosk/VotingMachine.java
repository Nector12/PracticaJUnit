package kiosk;

import data.MailAddress;
import data.Vote;
import services.MailerService;
import services.SignatureService;
import services.ValidationService;
import services.VotePrinter;
import services.VotesDB;

/**
 *
 * @author rav3
 */
/**
 * Implements a simplification of Use Case: Emit Vote
 */
public class VotingMachine {

    private ValidationService validationService;
    private VotePrinter votePrinter;
    private VotesDB votesDB;
    private SignatureService signatureService;
    private MailerService mailerService;

    private boolean activated;

    public VotingMachine() {
        this.activated = false;
    }

    public void setValidationService(ValidationService validationService) {
        this.validationService = validationService;
    }

    public void setVotePrinter(VotePrinter votePrinter) {
        this.votePrinter = votePrinter;
    }

    public void setVotesDB(VotesDB votesDB) {
        this.votesDB = votesDB;
    }

    public void setSignatureService(SignatureService signatureService) {
        this.signatureService = signatureService;
    }

    public void setMailerService(MailerService mailerService) {
        this.mailerService = mailerService;
    }

    public void activateEmission(ActivationCard card)
            throws IllegalStateException {

        if (this.activated) {
            throw new IllegalStateException("VotingMachine already activated.");
        }
        if (validationService.validate(card)) {
            // Card is valid
            this.activated = true;
        }
    }

    public boolean canVote() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void vote(Vote vote)
            throws IllegalStateException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void sendReceipt(MailAddress mailAddress)
            throws IllegalStateException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean isActivated() {
        return activated;
    }

}
