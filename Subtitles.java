package Subtitles;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subtitles {
    private List<Subtitle> subtitleList;

    public int loadSubtitles(InputStream in) {
        int count = 0;
        subtitleList = new ArrayList<>();
        Scanner scanner = new Scanner(in);
        while(scanner.hasNextLine()) {
            String indexLine =  scanner.nextLine();
            String timeLine = scanner.nextLine();
            StringBuilder textLines = new StringBuilder();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.compareTo("") == 0)
                    break;
                textLines.append(line).append("\n");
            }
            subtitleList.add(new Subtitle(indexLine, timeLine, textLines.toString()));
            count++;
        }
        System.out.println(count);
        return count;
    }

    public void print() {
        subtitleList.stream().forEach(System.out::println);
    }

    public void shift(int shift) {
        subtitleList.stream().forEach(subtitle -> subtitle.shift(shift));
    }
}
