import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.Comparator;
import java.util.stream.Stream;

public class StudentManagement implements Management {
    @Override
    public void displayStudents(List<Etudiant> students, Consumer<Etudiant> con) {
        students.forEach(con);
    }

    @Override
    public void displayStudentsByFilter(List<Etudiant> students, Predicate<Etudiant> pre, Consumer<Etudiant> con) {
        students.stream().filter(pre).forEach(con);
    }

    @Override
    public String returnStudentsNames(List<Etudiant> students, Function<Etudiant, String> fun) {
        StringBuilder names = new StringBuilder();
        students.forEach(student -> names.append(fun.apply(student)).append(" "));
        return names.toString();
    }

    @Override
    public Etudiant createStudent(Supplier<Etudiant> sup) {
        return sup.get();
    }

    @Override
    public List<Etudiant> sortStudentsById(List<Etudiant> students, Comparator<Etudiant> com) {
        List<Etudiant> sortedStudents = new ArrayList<>(Etudiant);
        sortedStudents.sort(com);
        return sortedStudents;
    }

    @Override
    public Stream<Etudiant> convertToStream(List<Etudiant> students) {
        return students.stream();
    }
}
