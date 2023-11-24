package optativa2.students.framework.adapter.input.rest;

import optativa2.students.application.GetStudentsBySchoolIdUseCase;
import optativa2.students.application.ListAllStudentsUseCase;
import optativa2.students.application.RegisterNewStudentUseCase;
import optativa2.students.domain.vo.FirstName;
import optativa2.students.domain.vo.Id;
import optativa2.students.domain.vo.LastName;
import optativa2.students.domain.vo.Phone;
import optativa2.students.framework.adapter.input.rest.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentManagementInput {

    private final RegisterNewStudentUseCase registerNewStudentUseCase;
    private final ListAllStudentsUseCase listAllStudentsUseCase;
    private final GetStudentsBySchoolIdUseCase getStudentsBySchoolIdUseCase;

    @GetMapping
    public ResponseEntity<List<StudentDto>> listAll() {
        var students = listAllStudentsUseCase.list()
                .stream()
                .map(StudentDto::fromStudent)
                .toList();
        return ResponseEntity.ok(students);
    }

    @PostMapping
    public ResponseEntity<Void> registerNewStudent(@RequestBody StudentDto registerStudentRequest) {
        var newStudent = registerNewStudentUseCase.create(
                new Id(registerStudentRequest.id()),
                new FirstName(registerStudentRequest.firstname()),
                new LastName(registerStudentRequest.lastname()),
                new Phone(registerStudentRequest.phone()),
                new Id(registerStudentRequest.schoolId())
        );
        registerNewStudentUseCase.register(newStudent);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<StudentDto>> studentsBySchoolId(@PathVariable String schoolId) {
        var students = getStudentsBySchoolIdUseCase.getStudentsBySchoolId(schoolId)
                .stream()
                .map(StudentDto::fromStudent)
                .toList();
        return ResponseEntity.ok(students);
    }

}
