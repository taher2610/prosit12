import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Etudiant student1 = new Etudiant(1, "AA", 10);
        Etudiant student2 = new Etudiant(2, "BB", 20);
        Etudiant student3 = new Etudiant(3, "VC", 24);

        List<Etudiant> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);


        StudentManagement studentManagement = new StudentManagement();

        studentManagement.displayStudents(students, System.out::println);

        Predicate<Etudiant> filterByAge = student -> student.getAge() > 20;
        studentManagement.displayStudentsByFilter(students, filterByAge, System.out::println);

        Function<Etudiant, String> getStudentName = Etudiant::getNom;
        String allNames = studentManagement.returnStudentsNames(students, getStudentName);
        System.out.println(allNames);

        Supplier<Etudiant> createNewStudent = () -> new Etudiant(4, "CC", 15);
        Etudiant newStudent = studentManagement.createStudent(createNewStudent);
        System.out.println(newStudent);

        Comparator<Etudiant> compareById = Comparator.comparingInt(Etudiant::getId);
        List<Etudiant> sortedStudents = studentManagement.sortStudentsById(students, compareById);
        sortedStudents.forEach(System.out::println);

        studentManagement.convertToStream(students).forEach(System.out::println);
    }
}
