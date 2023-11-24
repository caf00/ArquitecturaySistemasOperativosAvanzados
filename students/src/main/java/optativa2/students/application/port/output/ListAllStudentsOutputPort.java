package optativa2.students.application.port.output;

import optativa2.students.domain.Student;

import java.util.List;

public interface ListAllStudentsOutputPort {
    List<Student> retrieve();
}
