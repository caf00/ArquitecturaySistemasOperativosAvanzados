package optativa2.students.application.port.input;

import lombok.RequiredArgsConstructor;
import optativa2.students.application.GetStudentsBySchoolIdUseCase;
import optativa2.students.application.port.output.GetStudentsBySchoolIdOutputPort;
import optativa2.students.domain.Student;

import java.util.List;

@RequiredArgsConstructor
public class GetStudentsBySchoolIdInputPort implements GetStudentsBySchoolIdUseCase {

    private final GetStudentsBySchoolIdOutputPort getStudentsBySchoolIdOutputPort;

    @Override
    public List<Student> getStudentsBySchoolId(String schoolId) {
        return getStudentsBySchoolIdOutputPort.getStudentsBySchoolId(schoolId);
    }
}
