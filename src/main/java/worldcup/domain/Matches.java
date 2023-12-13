package worldcup.domain;

public class Matches {

    private final Nation winner;
    private final Nation loser;
    private int winnerScore;
    private int loserScore;
    private final boolean draw ;

    public Matches(GameLog nation1, GameLog nation2) {
        this.winner = getWinner(nation1, nation2);
        this.loser = getLoser(nation1, nation2);
        this.draw = isSame(nation1, nation2);
    }

    private Nation getWinner(GameLog nation1, GameLog nation2) {
        if (nation1.getScore() > nation2.getScore()) {
            this.winnerScore = nation1.getScore();
            return nation1.getNation();
        }
        this.winnerScore = nation2.getScore();
        return nation2.getNation();
    }

    private Nation getLoser(GameLog nation1, GameLog nation2) {
        if (nation1.getScore() < nation2.getScore()) {
            this.loserScore = nation1.getScore();
            return nation1.getNation();
        }
        this.loserScore = nation2.getScore();
        return nation2.getNation();
    }

    private boolean isSame(GameLog nation1, GameLog nation2) {
        return nation1.getScore() == nation2.getScore();
    }

    public Nation getWinner() {
        return winner;
    }

    public Nation getLoser() {
        return loser;
    }

    public int getWinnerScore() {
        return winnerScore;
    }

    public int getLoserScore() {
        return loserScore;
    }
}
