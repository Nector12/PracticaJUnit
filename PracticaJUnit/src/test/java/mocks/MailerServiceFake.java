package mocks;

import data.MailAddress;
import data.Signature;
import services.MailerService;

/**
 *
 * @author rav3
 */
/**
 * Mock for MailerService
 * Stores # of sent mails, the mailAddress and the signature sent.
 */
public class MailerServiceFake implements MailerService {

    public int nSent = 0;
    public MailAddress address;
    public Signature signature;
    
    @Override
    public void send(MailAddress address, Signature signature) {
        this.nSent++;
        this.address = address;
        this.signature = signature;
    }

}
