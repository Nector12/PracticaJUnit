package mocks;

import data.Vote;

/**
 *
 * @author rav3
 */
/**
 * Mock of VotesDB
 * Used to test if the correct Vote is registered
 */
public class VotesDBFake extends ForbiddenVotesDB {

    public Vote lastVote;
    public int nVotes = 0;

    @Override
    public void registerVote(Vote vote) {
        this.lastVote = vote;
        this.nVotes++;
    }

}
