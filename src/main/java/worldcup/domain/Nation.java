package worldcup.domain;

import java.util.Objects;

public class Nation {

    private final String name;
    private int winCount = 0;
    private int drawCount = 0;
    private int loseCount = 0;

    public Nation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void increaseWin() {
        winCount += 1;
    }

    public void increaseDraw() {
        drawCount += 1;
    }

    public void increaseLose() {
        loseCount += 1;
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

    public int getWinCount() {
        return winCount;
    }

    public int getDrawCount() {
        return drawCount;
    }

    public int getLoseCount() {
        return loseCount;
    }
}
