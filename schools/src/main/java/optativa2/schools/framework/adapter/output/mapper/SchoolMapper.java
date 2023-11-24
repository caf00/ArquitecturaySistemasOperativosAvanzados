package optativa2.schools.framework.adapter.output.mapper;

import optativa2.schools.domain.School;
import optativa2.schools.domain.vo.*;
import optativa2.schools.framework.adapter.input.rest.dto.StudentDto;
import optativa2.schools.framework.adapter.output.data.SchoolData;

public class SchoolMapper {

    public static School SchoolDataToDomain(SchoolData schoolData) {
        return School.register(
                new Id(schoolData.getId()),
                new Name(schoolData.getName()),
                new Address(schoolData.getAddress()),
                new Phone(schoolData.getPhone())
        );
    }

    public static SchoolData SchoolToSchoolData(School school) {
        return new SchoolData(
                school.id().id(),
                school.name().name(),
                school.address().address(),
                school.phone().phone()
        );
    }

    public static StudentDto StudentToStudentDto(Student student) {
        String fullName = student.firstname() + ", " + student.lastname();
        return new StudentDto(student.id(), fullName);
    }

}
