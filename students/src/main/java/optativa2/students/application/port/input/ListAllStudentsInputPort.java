package optativa2.students.application.port.input;

import optativa2.students.application.port.output.ListAllStudentsOutputPort;
import optativa2.students.application.ListAllStudentsUseCase;
import optativa2.students.domain.Student;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListAllStudentsInputPort implements ListAllStudentsUseCase {

    private final ListAllStudentsOutputPort listAllStudentsOutputPort;

    @Override
    public List<Student> list() {
        return listAllStudentsOutputPort.retrieve();
    }
}
