package hu.nive.ujratervezes.schoolsystem;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SchoolSystemTest {
    private final List<Student> studentList = new ArrayList<>();
    private SchoolSystem school;

    @BeforeEach
    void setUp() {
        studentList.add(new Student("Aladar", LocalDate.of(2020, Month.SEPTEMBER, 2), Set.of("irodalom", "informatika", "matematika", "fizika", "biológia")));
        studentList.add(new Student("Bela", LocalDate.of(2020, Month.SEPTEMBER, 2), Set.of("torna", "francia", "rajz")));
        studentList.add(new Student("Cecil", LocalDate.of(2020, Month.SEPTEMBER, 2), Set.of("fizika", "biológia", "angol")));
        studentList.add(new Student("Dezire", LocalDate.of(2021, Month.FEBRUARY, 8), Set.of("matematika", "francia")));
        studentList.add(new Student("Eleonora", LocalDate.of(2021, Month.FEBRUARY, 8), Set.of("irodalom", "informatika", "matematika")));
        studentList.add(new Student("Ferenc", LocalDate.of(2021, Month.FEBRUARY, 8), Set.of("angol", "torna", "matematika")));
        studentList.add(new Student("Gerda", LocalDate.of(2021, Month.FEBRUARY, 8), Set.of("irodalom", "nyelvtan", "rajz")));
        studentList.add(new Student("Hanna", LocalDate.of(2021, Month.SEPTEMBER, 3), Set.of("filozófia")));
        studentList.add(new Student("Ibolya", LocalDate.of(2021, Month.SEPTEMBER, 3), Set.of("irodalom", "informatika")));
        studentList.add(new Student("Jozsef", LocalDate.of(2021, Month.SEPTEMBER, 3), Set.of("irodalom", "fizika", "matematika")));
        studentList.add(new Student("Karoly", LocalDate.of(2021, Month.SEPTEMBER, 3), Set.of("irodalom", "fizika", "matematika")));
        studentList.add(new Student("Laszlo", LocalDate.of(2021, Month.SEPTEMBER, 3), Set.of("irodalom", "pszichológia")));
        school = new SchoolSystem(studentList);
    }

    @Test
    @Order(1)
    void test_schoolSystemThrowsException() {
        assertThatThrownBy(() -> new SchoolSystem(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(2)
    void test_getListOfStudentsLearningSubjectForNotExistingSubject() {
        String subject = "Bevezetés a digitalis mechanikába II.";
        List<Student> result = school.getListOfStudentsLearningSubject(subject);
        assertThat(result).isEmpty();
    }

    @Test
    @Order(3)
    void test_getListOfStudentsLearningSubject() {
        String subject = "informatika";
        List<Student> result = school.getListOfStudentsLearningSubject(subject);
        assertThat(result)
                .hasSize(3)
                .containsExactlyInAnyOrder(studentList.get(0), studentList.get(4), studentList.get(8));
    }


    @Test
    @Order(4)
    void test_getListOfStudentsLearningSubject_Filo() {
        String subject = "filozófia";
        List<Student> result = school.getListOfStudentsLearningSubject(subject);
        assertThat(result).hasSize(1);
    }

    @Test
    @Order(5)
    void test_getListOfStudentsLearningSubject_Math() {
        String subject = "matematika";
        List<Student> result = school.getListOfStudentsLearningSubject(subject);
        assertThat(result).hasSize(6);
    }

    @Test
    @Order(6)
    void test_getListOfStudentsLearningSubject_Drawing() {
        String subject = "rajz";
        List<Student> result = school.getListOfStudentsLearningSubject(subject);
        assertThat(result).hasSize(2);
    }

    @Test
    @Order(7)
    void test_getListOfStudentsByStartDate() {
        List<Student> result = school.getListOfStudentsByStartDate(LocalDate.of(2020, Month.SEPTEMBER, 2));
        assertThat(result)
                .hasSize(3)
                .containsExactly(studentList.get(0), studentList.get(1), studentList.get(2));
    }

    @Test
    @Order(8)
    void test_getListOfStudentsGroupByStartDate() {
        Map<LocalDate, List<Student>> result = school.getListOfStudentsGroupByStartDate();
        assertThat(result).hasSize(3);
        assertThat(result.get(LocalDate.of(2020, Month.SEPTEMBER, 2))).containsExactly(studentList.get(0), studentList.get(1), studentList.get(2));
        assertThat(result.get(LocalDate.of(2021, Month.FEBRUARY, 8))).containsExactly(studentList.get(3), studentList.get(4), studentList.get(5), studentList.get(6));
    }

    @Test
    @Order(9)
    void test_deleteSubjectFromAllStudents() {
        List<Student> students = school.getStudents();
        String subject = "francia";
        assertThat(students.stream()
                .filter(student -> {
                    Set<String> subjects = student.getSubjects();
                    return subjects.contains(subject);
                })
                .collect(Collectors.toList()))
                .hasSize(2);

        school.deleteSubjectFromAllStudents(subject);

        assertThat(students.stream()
                .filter(student -> {
                    Set<String> subjects = student.getSubjects();
                    return subjects.contains(subject);
                })
                .collect(Collectors.toList()))
                .isEmpty();
    }


    @Test
    @Order(10)
    void test_getCommonSubjectsAmongStudents() {
        assertThatThrownBy(() -> school.getCommonSubjectsAmongStudents(null)).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> school.getCommonSubjectsAmongStudents(Set.of())).isInstanceOf(IllegalArgumentException.class);

        {
            Set<String> studentNames = Set.of("Gerda", "Ibolya");
            Set<String> result = school.getCommonSubjectsAmongStudents(studentNames);
            assertThat(result).containsExactly("irodalom");
        }

        {
            Set<String> studentNames = Set.of("Jozsef", "Karoly", "Aladar");
            Set<String> result = school.getCommonSubjectsAmongStudents(studentNames);
            assertThat(result).containsExactlyInAnyOrder("matematika", "fizika", "irodalom");
        }
    }
}
