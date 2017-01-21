package mocks;

import data.Vote;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rav3
 */
/**
 * Mock of VotesDB Used to test if the correct Vote is registered
 */
public class VotesDBFake extends ForbiddenVotesDB {

    public List<Vote> votes = new ArrayList<>();
    public int nVotes = 0;

    @Override
    public void registerVote(Vote vote) {
        this.votes.add(vote);
        this.nVotes++;
    }

    @Override
    public List<Vote> getVotes() {
        return this.votes;
    }

}
