package optativa2.schools.application.port.input;

import lombok.RequiredArgsConstructor;
import optativa2.schools.application.GetSchoolWithStudentsUseCase;
import optativa2.schools.application.port.output.GetSchoolByIdOutputPort;
import optativa2.schools.application.port.output.GetStudentsBySchoolIdOutputPort;
import optativa2.schools.domain.School;
import optativa2.schools.domain.vo.Id;

@RequiredArgsConstructor
public class GetSchoolWithStudentsInputPort implements GetSchoolWithStudentsUseCase {

    private final GetStudentsBySchoolIdOutputPort getStudentsBySchoolIdOutputPort;
    private final GetSchoolByIdOutputPort getSchoolByIdOutputPort;
    @Override
    public School get(Id schoolId) {
        var school = getSchoolByIdOutputPort.getById(schoolId);
        var students = getStudentsBySchoolIdOutputPort.get(schoolId);
        return school.addStudents(students);
    }
}
