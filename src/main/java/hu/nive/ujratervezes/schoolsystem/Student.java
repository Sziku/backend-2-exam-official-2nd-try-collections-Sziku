package hu.nive.ujratervezes.schoolsystem;

import java.time.LocalDate;
import java.util.Set;

public class Student {
    private String name;
    private LocalDate startDate;
    Set<String> subjects;

    public Student(String name, LocalDate startDate, Set<String> subjects) {
        this.name = name;
        this.startDate = startDate;
        this.subjects = subjects;
    }

}
