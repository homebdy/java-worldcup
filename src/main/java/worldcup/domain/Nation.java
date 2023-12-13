package worldcup.domain;

import java.util.Objects;

public class Nation {

    private final String name;
    private int goal;

    public Nation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Nation nation = (Nation) obj;
        return this.name.equals(nation.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
