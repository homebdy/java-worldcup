package worldcup.domain;

public class Match {

    private Nation winner;
    private Nation loser;
    private int winnerScore;
    private int loserScore;
    private final boolean draw;
    private final String message;

    public Match(GameLog nation1, GameLog nation2, String log) {
        getResult(nation1, nation2);
        this.draw = isDraw(nation1, nation2);
        this.message = log;
    }

    private void getResult(GameLog nation1, GameLog nation2) {
        if (nation1.getScore() > nation2.getScore()) {
            this.winnerScore = nation1.getScore();
            this.winner = nation1.getNation();
            this.loserScore = nation2.getScore();
            this.loser = nation2.getNation();
            return;
        }
        this.winnerScore = nation2.getScore();
        this.winner = nation2.getNation();
        this.loserScore = nation1.getScore();
        this.loser = nation1.getNation();
    }

    private boolean isDraw(GameLog nation1, GameLog nation2) {
        return nation1.getScore() == nation2.getScore();
    }

    public boolean isDraw() {
        return draw;
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

    public String getMessage() {
        return message;
    }

    public boolean isContain(String nationName) {
        return message.contains(nationName);
    }
}
