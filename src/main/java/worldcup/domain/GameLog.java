package worldcup.domain;

public class GameLog {

    private final Nation nation;
    private final int score;

    public GameLog(Nation nation, int score) {
        this.nation = nation;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public Nation getNation() {
        return nation;
    }
}
