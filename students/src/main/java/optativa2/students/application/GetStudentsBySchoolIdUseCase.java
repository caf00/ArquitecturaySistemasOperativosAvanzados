package optativa2.students.application;

import optativa2.students.domain.Student;

import java.util.List;

public interface GetStudentsBySchoolIdUseCase {
    List<Student> getStudentsBySchoolId(String schoolId);
}
