package worldcup.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {

    private final List<Nation> elements;

    public Group() {
        this.elements = new ArrayList<>();
    }

    public void add(Nation nation) {
        if (!elements.contains(nation)) {
            elements.add(nation);
        }
    }

    public boolean contains(Nation nation) {
        return elements.contains(nation);
    }

    public void increaseWinCount(Nation nation) {
        elements.stream()
                .filter(n -> Objects.equals(n.getName(), nation.getName()))
                .findFirst()
                .get()
                .increaseWin();
    }

    public void increaseDrawCount(Nation nation) {
        elements.stream()
                .filter(n -> Objects.equals(n.getName(), nation.getName()))
                .findFirst()
                .get()
                .increaseDraw();
    }

    public void increaseLoseCount(Nation nation) {
        elements.stream()
                .filter(n -> Objects.equals(n.getName(), nation.getName()))
                .findFirst()
                .get()
                .increaseLose();
    }

    public List<Nation> getElements() {
        return elements;
    }
}
