package optativa2.schools.application.port.output;

import optativa2.schools.domain.vo.Id;
import optativa2.schools.domain.vo.Student;

import java.util.List;

public interface GetStudentsBySchoolIdOutputPort {
    public List<Student> get(Id schoolId);
}
