package az.adnsu.studentparticipate.util;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Lesson {
    private LocalTime begin;
    private LocalTime end;

    public Lesson(LocalTime begin, LocalTime end) {
        this.begin = begin;
        this.end = end;
    }

    public LocalTime getBegin() {
        return begin;
    }

    public void setBegin(LocalTime begin) {
        this.begin = begin;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }
}
