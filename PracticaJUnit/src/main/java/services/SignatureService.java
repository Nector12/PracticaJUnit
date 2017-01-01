package services;

import data.Signature;
import data.Vote;

/**
 *
 * @author rav3
 */
/**
 * External service for signing votes
 */
public interface SignatureService {

    Signature sign(Vote vote);
    
}
