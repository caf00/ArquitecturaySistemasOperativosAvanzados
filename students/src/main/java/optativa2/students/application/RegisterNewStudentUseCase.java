package optativa2.students.application;

import optativa2.students.domain.Student;
import optativa2.students.domain.vo.FirstName;
import optativa2.students.domain.vo.Id;
import optativa2.students.domain.vo.LastName;
import optativa2.students.domain.vo.Phone;

public interface RegisterNewStudentUseCase {

    default Student create(Id id, FirstName firstName, LastName lastName, Phone phone, Id schoolId) {
        return new Student(id, firstName, lastName, phone, schoolId);
    }

    void register(Student student);
}
