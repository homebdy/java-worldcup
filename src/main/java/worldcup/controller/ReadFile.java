package worldcup.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    private final List<String> matches;

    public ReadFile() {
        this.matches = read();
    }

    public List<String> read() {
        Path path = Paths.get("src/main/resources/MatchResult.txt");
        Charset charset = StandardCharsets.UTF_8;
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public List<String> getMatches() {
        return matches;
    }
}
