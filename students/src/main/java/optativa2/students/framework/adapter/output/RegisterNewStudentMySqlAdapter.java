package optativa2.students.framework.adapter.output;

import optativa2.students.application.port.output.RegisterNewStudentOutputPort;
import optativa2.students.domain.Student;
import optativa2.students.domain.vo.Id;
import optativa2.students.framework.adapter.output.mapper.StudentMapper;
import optativa2.students.framework.adapter.output.repository.StudentJpaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterNewStudentMySqlAdapter implements RegisterNewStudentOutputPort {

    private final StudentJpaRepository studentJpaRepository;

    @Override
    public boolean existsById(Id id) {
        return studentJpaRepository.existsById(id.id());
    }

    @Override
    public void persist(Student student) {
        studentJpaRepository.save(StudentMapper.StudentToStudentData(student));
    }
}
