package optativa2.students.application.port.input;

import optativa2.students.application.port.output.RegisterNewStudentOutputPort;
import optativa2.students.application.RegisterNewStudentUseCase;
import optativa2.students.domain.Student;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterNewStudentInputPort implements RegisterNewStudentUseCase {

    private final RegisterNewStudentOutputPort registerNewStudentOutputPort;

    @Override
    public void register(Student student) {

        if (registerNewStudentOutputPort.existsById(student.id())) {
            throw new RuntimeException("Student Id already exists");
        }

        registerNewStudentOutputPort.persist(student);
    }
}
