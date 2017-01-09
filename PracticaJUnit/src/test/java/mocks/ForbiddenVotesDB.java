package mocks;

import data.Vote;
import java.util.List;
import services.VotesDB;

/**
 *
 * @author rav3
 */
public class ForbiddenVotesDB implements VotesDB {

    @Override
    public void registerVote(Vote vote) {
        throw new UnsupportedOperationException("Illegal operation");
    }

    @Override
    public List<Vote> getVotes() {
        throw new UnsupportedOperationException("Illegal operation");
    }

}
