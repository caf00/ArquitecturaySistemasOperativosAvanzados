package optativa2.students.framework.adapter.output.mapper;

import optativa2.students.domain.Student;
import optativa2.students.domain.vo.FirstName;
import optativa2.students.domain.vo.Id;
import optativa2.students.domain.vo.LastName;
import optativa2.students.domain.vo.Phone;
import optativa2.students.framework.adapter.output.data.StudentData;

public class StudentMapper {
    public static Student StudentDataToDomain(StudentData studentData) {
        return new Student(
                new Id(studentData.getId()),
                new FirstName(studentData.getFirstname()),
                new LastName(studentData.getLastname()),
                new Phone(studentData.getPhone()),
                new Id(studentData.getSchoolId())
        );
    }

    public static StudentData StudentToStudentData(Student student) {
        return new StudentData(
                student.id().id(),
                student.firstname().firstname(),
                student.lastname().lastName(),
                student.phone().phone(),
                student.schoolId().id()
        );
    }
}
