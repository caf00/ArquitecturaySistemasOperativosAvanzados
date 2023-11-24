package optativa2.schools.framework.adapter.output;

import optativa2.schools.application.port.output.RegisterNewSchoolOutputPort;
import optativa2.schools.domain.School;
import optativa2.schools.framework.adapter.output.mapper.SchoolMapper;
import optativa2.schools.framework.adapter.output.repository.SchoolJpaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegisterNewSchoolMySqlAdapter implements RegisterNewSchoolOutputPort {

    private final SchoolJpaRepository schoolJpaRepository;

    @Override
    public boolean exists(School school) {
        return schoolJpaRepository.existsById(school.id().id());
    }

    @Override
    public void persist(School school) {
        schoolJpaRepository.save(SchoolMapper.SchoolToSchoolData(school));
    }
}
