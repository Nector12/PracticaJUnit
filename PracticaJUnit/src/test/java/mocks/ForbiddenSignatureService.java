package mocks;

import data.Signature;
import data.Vote;
import services.SignatureService;

/**
 *
 * @author rav3
 */
public class ForbiddenSignatureService implements SignatureService {

    @Override
    public Signature sign(Vote vote) {
        throw new UnsupportedOperationException("Illegal operation");
    }

}
