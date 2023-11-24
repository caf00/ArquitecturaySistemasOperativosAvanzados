package optativa2.schools.framework.adapter.output;

import optativa2.schools.application.port.output.ListAllSchoolsOutputPort;
import optativa2.schools.domain.School;
import optativa2.schools.framework.adapter.output.mapper.SchoolMapper;
import optativa2.schools.framework.adapter.output.repository.SchoolJpaRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ListAllSchoolsMySqlAdapter implements ListAllSchoolsOutputPort {

    private final SchoolJpaRepository schoolJpaRepository;

    @Override
    public List<School> retrieve() {
        return schoolJpaRepository
                .findAll()
                .stream()
                .map(SchoolMapper::SchoolDataToDomain)
                .toList();
    }
}
