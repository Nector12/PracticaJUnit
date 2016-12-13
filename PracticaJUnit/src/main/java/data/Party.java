package data;

import java.util.Objects;

/**
 * Describes a Party
 * 
 * @author Nector
 */
final public class Party {
    
    private final String name;

    public Party(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
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
        final Party other = (Party) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Party{" + "name=" + name + '}';
    }
    
    
    
}
