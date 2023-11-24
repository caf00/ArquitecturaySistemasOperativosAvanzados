package optativa2.schools.framework.adapter.input.rest.dto;

import optativa2.schools.domain.School;
import optativa2.schools.framework.adapter.output.mapper.SchoolMapper;

import java.io.Serializable;
import java.util.List;

public record SchoolWithStudentsDto(SchoolDto school, List<StudentDto> students) implements Serializable {
    public static SchoolWithStudentsDto from(School school) {
        var schoolDto = new SchoolDto(school.id().id(), school.name().name(), school.address().address(), school.phone().phone());
        var studentsDto = school.students().stream().map(SchoolMapper::StudentToStudentDto).toList();
        return new SchoolWithStudentsDto(schoolDto, studentsDto);
    }
}
