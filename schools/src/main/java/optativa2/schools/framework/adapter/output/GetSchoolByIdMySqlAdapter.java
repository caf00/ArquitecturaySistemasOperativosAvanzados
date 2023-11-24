package optativa2.schools.framework.adapter.output;

import lombok.RequiredArgsConstructor;
import optativa2.schools.application.port.output.GetSchoolByIdOutputPort;
import optativa2.schools.domain.School;
import optativa2.schools.domain.vo.Id;
import optativa2.schools.framework.adapter.output.mapper.SchoolMapper;
import optativa2.schools.framework.adapter.output.repository.SchoolJpaRepository;

@RequiredArgsConstructor
public class GetSchoolByIdMySqlAdapter implements GetSchoolByIdOutputPort {

    private final SchoolJpaRepository schoolJpaRepository;

    @Override
    public School getById(Id id) {
        return schoolJpaRepository.findById(id.id())
                .map(SchoolMapper::SchoolDataToDomain)
                .orElseThrow(() -> new RuntimeException("School not found."));
    }
}
