package data;

import java.util.Objects;

/**
 * Represents a vote
 * 
 * @author Nector
 */
final public class Vote {
 
    private final String option;

    public Vote(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    @Override
    public int hashCode() {
        return option.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vote other = (Vote) obj;
        if (!Objects.equals(this.option, other.option)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vote{" + "option=" + option + '}';
    }
    
}
