package worldcup.domain;

import worldcup.constant.OutputMessage;

import java.util.Objects;

public class Nation {

    private final String name;
    private int winCount = 0;
    private int drawCount = 0;
    private int loseCount = 0;
    private int point = 0;
    private int goal = 0;
    private int otherSideGoal = 0;

    public Nation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void increaseWin() {
        winCount += 1;
        point += 3;
    }

    public void increaseDraw() {
        drawCount += 1;
        point += 1;
    }

    public void increaseLose() {
        loseCount += 1;
    }

    public void increaseGoal(int ourGoal, int otherGoal) {
        goal += ourGoal;
        otherSideGoal += otherGoal;
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

    public int getPoint() {
        return point;
    }

    public int getDifference() {
        return goal - otherSideGoal;
    }

    public int getGoal() {
        return goal;
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        appendName(sb);
        appendWin(sb);
        appendDraw(sb);
        appendLose(sb);
        appendPoint(sb);
        appendDifference(sb);
        appendGoal(sb);
        return sb.toString();
    }

    private void appendName(StringBuilder sb) {
        sb.append(name).append(OutputMessage.COMMA.getMessage());
    }

    private void appendWin(StringBuilder sb) {
        sb.append(OutputMessage.WIN.getMessage())
                .append(OutputMessage.COLON.getMessage())
                .append(winCount)
                .append(OutputMessage.COMMA.getMessage());
    }

    private void appendLose(StringBuilder sb) {
        sb.append(OutputMessage.LOSE.getMessage())
                .append(OutputMessage.COLON.getMessage())
                .append(loseCount)
                .append(OutputMessage.COMMA.getMessage());
    }

    private void appendDraw(StringBuilder sb) {
        sb.append(OutputMessage.DRAW.getMessage())
                .append(OutputMessage.COLON.getMessage())
                .append(drawCount)
                .append(OutputMessage.COMMA.getMessage());
    }

    private void appendPoint(StringBuilder sb) {
        sb.append(OutputMessage.SCORE.getMessage())
                .append(OutputMessage.COLON.getMessage())
                .append(point)
                .append(OutputMessage.COMMA.getMessage());
    }

    private void appendDifference(StringBuilder sb) {
        sb.append(OutputMessage.DIFFERENCE.getMessage())
                .append(OutputMessage.COLON.getMessage())
                .append(goal - otherSideGoal)
                .append(OutputMessage.COMMA.getMessage());
    }

    private void appendGoal(StringBuilder sb) {
        sb.append(OutputMessage.GOAL.getMessage())
                .append(OutputMessage.COLON.getMessage())
                .append(goal);
    }
}
