package optativa2.schools.framework.adapter.output;

import lombok.RequiredArgsConstructor;
import optativa2.schools.application.port.output.GetStudentsBySchoolIdOutputPort;
import optativa2.schools.domain.vo.Id;
import optativa2.schools.domain.vo.Student;
import optativa2.schools.framework.adapter.output.httpClient.StudentFeignClient;

import java.util.List;

@RequiredArgsConstructor
public class GetStudentsBySchoolIdMySqlAdapter implements GetStudentsBySchoolIdOutputPort {

    private final StudentFeignClient studentFeignClient;

    @Override
    public List<Student> get(Id schoolId) {
        return studentFeignClient.get(schoolId.id());
    }
}
