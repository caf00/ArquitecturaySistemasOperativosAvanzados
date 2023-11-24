package optativa2.students.framework.config;

import optativa2.students.application.GetStudentsBySchoolIdUseCase;
import optativa2.students.application.port.input.GetStudentsBySchoolIdInputPort;
import optativa2.students.application.port.input.ListAllStudentsInputPort;
import optativa2.students.application.port.input.RegisterNewStudentInputPort;
import optativa2.students.application.ListAllStudentsUseCase;
import optativa2.students.application.RegisterNewStudentUseCase;
import optativa2.students.framework.adapter.output.GetStudentsBySchoolIdMySqlAdapter;
import optativa2.students.framework.adapter.output.ListAllStudentsMySqlAdapter;
import optativa2.students.framework.adapter.output.RegisterNewStudentMySqlAdapter;
import optativa2.students.framework.adapter.output.repository.StudentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final StudentJpaRepository studentJpaRepository;

    @Bean
    public ListAllStudentsUseCase listAllStudentsUseCase() {
        return new ListAllStudentsInputPort(new ListAllStudentsMySqlAdapter(studentJpaRepository));
    }

    @Bean
    public RegisterNewStudentUseCase registerNewStudentUseCase() {
        return new RegisterNewStudentInputPort(new RegisterNewStudentMySqlAdapter(studentJpaRepository));
    }

    @Bean
    public GetStudentsBySchoolIdUseCase getStudentsBySchoolIdUseCase() {
        return new GetStudentsBySchoolIdInputPort(new GetStudentsBySchoolIdMySqlAdapter(studentJpaRepository));
    }

}
