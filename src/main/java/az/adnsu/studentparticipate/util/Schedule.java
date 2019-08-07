package az.adnsu.studentparticipate.util;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Schedule {
    public static final List<Lesson> data = new ArrayList<>();

    static {
        data.add(new Lesson(LocalTime.of(8, 30), LocalTime.of(10, 5)));
        data.add(new Lesson(LocalTime.of(10, 20), LocalTime.of(11, 55)));
        data.add(new Lesson(LocalTime.of(12, 15), LocalTime.of(13, 50)));
        data.add(new Lesson(LocalTime.of(14, 5), LocalTime.of(15, 40)));
        data.add(new Lesson(LocalTime.of(15, 55), LocalTime.of(17, 30)));
        data.add(new Lesson(LocalTime.of(17, 50), LocalTime.of(19, 25)));
        data.add(new Lesson(LocalTime.of(19, 40), LocalTime.of(21, 15)));
    }

}
