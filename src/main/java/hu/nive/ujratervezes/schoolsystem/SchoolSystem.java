package hu.nive.ujratervezes.schoolsystem;


import java.time.LocalDate;
import java.util.*;

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
        for (Student student : students){
            Set<String> subjectList = new HashSet<>(student.getSubjects());
            subjectList.remove(subject);
            student.setSubjects(subjectList);
        }

    }

    public List<Student> getListOfStudentsByStartDate(LocalDate date){
        return students.stream().filter(Student -> Student.getStartDate().equals(date)).toList();
    }


    public Map<LocalDate, List<Student>> getListOfStudentsGroupByStartDate(){
        Map<LocalDate, List<Student>> resultMaps = new HashMap<>();
        for(Student student : students){
            if(!resultMaps.containsKey(student.getStartDate())){
                List<Student> studentsStartDate = new ArrayList<>();
                studentsStartDate.add(student);
                resultMaps.put(student.getStartDate(), studentsStartDate);
            } else {
                List<Student> studentsStartDate = resultMaps.get(student.getStartDate());
                studentsStartDate.add(student);
                resultMaps.put(student.getStartDate(), studentsStartDate );
            }
        }
        return resultMaps;
    }

    public Set<String> getCommonSubjectsAmongStudents(Set<String> studentNames) {
        return null;
    }
}
