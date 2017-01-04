package mocks;

import data.Signature;
import data.Vote;
import services.SignatureService;

/**
 *
 * @author rav3
 */
/**
 * Mock for SignatureService
 * Simply returns a new signature for testing
 */
public class SignatureServiceFake implements SignatureService {

    public Vote vote;
    
    @Override
    public Signature sign(Vote vote) {        
        this.vote = vote;
        Signature signature = new Signature(
                new byte[]{1,2,3,4,5,6,7,8,9});
        return signature;
    }
    
}
