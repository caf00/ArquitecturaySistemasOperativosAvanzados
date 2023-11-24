package optativa2.students.framework.adapter.output;

import lombok.RequiredArgsConstructor;
import optativa2.students.application.port.output.GetStudentsBySchoolIdOutputPort;
import optativa2.students.domain.Student;
import optativa2.students.framework.adapter.output.mapper.StudentMapper;
import optativa2.students.framework.adapter.output.repository.StudentJpaRepository;

import java.util.List;

@RequiredArgsConstructor
public class GetStudentsBySchoolIdMySqlAdapter implements GetStudentsBySchoolIdOutputPort {

    private final StudentJpaRepository studentJpaRepository;

    @Override
    public List<Student> getStudentsBySchoolId(String schoolId) {
        return studentJpaRepository
                .findAllBySchoolId(schoolId)
                .stream()
                .map(StudentMapper::StudentDataToDomain)
                .toList();
    }
}
