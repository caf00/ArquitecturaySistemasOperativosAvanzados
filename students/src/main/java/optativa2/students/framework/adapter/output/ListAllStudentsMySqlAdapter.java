package optativa2.students.framework.adapter.output;

import optativa2.students.application.port.output.ListAllStudentsOutputPort;
import optativa2.students.domain.Student;
import optativa2.students.framework.adapter.output.mapper.StudentMapper;
import optativa2.students.framework.adapter.output.repository.StudentJpaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListAllStudentsMySqlAdapter implements ListAllStudentsOutputPort {

    private final StudentJpaRepository studentJpaRepository;

    @Override
    public List<Student> retrieve() {
        return studentJpaRepository
                .findAll()
                .stream()
                .map(StudentMapper::StudentDataToDomain)
                .toList();
    }
}
