package Subtitles;

import java.security.cert.TrustAnchor;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Subtitle {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss,SSS");
    private int index;
    private LocalTime startTime;
    private LocalTime endTime;
    private String text;

    public Subtitle(String indexLine, String timeLine, String text){
        index = Integer.parseInt(indexLine);
        String[] timeParts = timeLine.split(" --> ");
        startTime = LocalTime.parse(timeParts[0], formatter);
        endTime = LocalTime.parse(timeParts[1], formatter);
        this.text = text;
    }

    public void shift(int millis){
        startTime = startTime.plus(millis, ChronoUnit.MILLIS);
        endTime = endTime.plus(millis, ChronoUnit.MILLIS);
    }

    @Override
    public String toString() {
        return String.format("%d\n%s --> %s\n%s", index, formatter.format(startTime), formatter.format(endTime), text);
    }
}
