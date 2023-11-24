package optativa2.students.framework.adapter.input.rest.dto;

import optativa2.students.domain.Student;

import java.io.Serializable;

public record StudentDto(String id, String firstname, String lastname, String phone, String schoolId) implements Serializable {
    public static StudentDto fromStudent(Student student) {
        return new StudentDto(
                student.id().id(),
                student.firstname().firstname(),
                student.lastname().lastName(),
                student.phone().phone(),
                student.schoolId().id()
        );
    }
}
