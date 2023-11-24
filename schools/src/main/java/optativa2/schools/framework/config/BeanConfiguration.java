package optativa2.schools.framework.config;

import lombok.RequiredArgsConstructor;
import optativa2.schools.application.GetSchoolWithStudentsUseCase;
import optativa2.schools.application.ListAllSchoolsUseCase;
import optativa2.schools.application.RegisterNewSchoolUseCase;
import optativa2.schools.application.port.input.GetSchoolWithStudentsInputPort;
import optativa2.schools.application.port.input.ListAllSchoolsInputPort;
import optativa2.schools.application.port.input.RegisterNewSchoolInputPort;
import optativa2.schools.framework.adapter.output.GetSchoolByIdMySqlAdapter;
import optativa2.schools.framework.adapter.output.GetStudentsBySchoolIdMySqlAdapter;
import optativa2.schools.framework.adapter.output.httpClient.StudentFeignClient;
import optativa2.schools.framework.adapter.output.ListAllSchoolsMySqlAdapter;
import optativa2.schools.framework.adapter.output.RegisterNewSchoolMySqlAdapter;
import optativa2.schools.framework.adapter.output.repository.SchoolJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final SchoolJpaRepository schoolJpaRepository;
    private final StudentFeignClient studentFeignClient;

    @Bean
    public ListAllSchoolsUseCase listAllSchoolsUseCase() {
        return new ListAllSchoolsInputPort(new ListAllSchoolsMySqlAdapter(schoolJpaRepository));
    }

    @Bean
    public RegisterNewSchoolUseCase registerNewStudentUseCase() {
        return new RegisterNewSchoolInputPort(new RegisterNewSchoolMySqlAdapter(schoolJpaRepository));
    }

    @Bean
    public GetSchoolWithStudentsUseCase getSchoolWithStudentsUseCase() {
        return new GetSchoolWithStudentsInputPort(
                new GetStudentsBySchoolIdMySqlAdapter(studentFeignClient),
                new GetSchoolByIdMySqlAdapter(schoolJpaRepository)
        );
    }

}
