package services;

import data.Vote;
import java.util.List;

/**
 *
 * @author rav3
 */
/**
 * Local service that registers votes.
 */
public interface VotesDB {

    void registerVote(Vote vote);
    List<Vote> getVotes();
    
}
