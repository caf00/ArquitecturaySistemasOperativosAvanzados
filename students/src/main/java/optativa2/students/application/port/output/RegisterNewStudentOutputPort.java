package optativa2.students.application.port.output;

import optativa2.students.domain.Student;
import optativa2.students.domain.vo.Id;

public interface RegisterNewStudentOutputPort {

    boolean existsById(Id id);
    void persist(Student student);
}
