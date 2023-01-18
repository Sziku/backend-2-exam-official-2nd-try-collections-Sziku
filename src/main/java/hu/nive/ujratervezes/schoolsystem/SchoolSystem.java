package hu.nive.ujratervezes.schoolsystem;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SchoolSystem {

    private List<Student> students;

    public SchoolSystem(List<Student> students) throws IllegalArgumentException{
        if(students == null) throw new IllegalArgumentException();
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Student> getListOfStudentsLearningSubject(String subject){
        return students.stream().filter(Student -> Student.getSubjects().contains(subject)).toList();
    }

    public void deleteSubjectFromAllStudents(String subject){
        students.forEach(Student -> Student.getSubjects().remove(subject));
    }

    public List<Student> getListOfStudentsByStartDate(LocalDate date){
        return null;
    }


    public Map<LocalDate, List<Student>> getListOfStudentsGroupByStartDate(){
        return null;
    }

    public Set<String> getCommonSubjectsAmongStudents(Set<String> studentNames) {
        return null;
    }
}
