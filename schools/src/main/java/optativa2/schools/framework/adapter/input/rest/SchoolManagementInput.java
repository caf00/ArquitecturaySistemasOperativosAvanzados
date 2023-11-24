package optativa2.schools.framework.adapter.input.rest;

import lombok.RequiredArgsConstructor;
import optativa2.schools.application.GetSchoolWithStudentsUseCase;
import optativa2.schools.application.ListAllSchoolsUseCase;
import optativa2.schools.application.RegisterNewSchoolUseCase;
import optativa2.schools.domain.vo.Address;
import optativa2.schools.domain.vo.Id;
import optativa2.schools.domain.vo.Name;
import optativa2.schools.domain.vo.Phone;
import optativa2.schools.framework.adapter.input.rest.dto.SchoolDto;
import optativa2.schools.framework.adapter.input.rest.dto.SchoolWithStudentsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school")
@RequiredArgsConstructor
public class SchoolManagementInput {

    private final ListAllSchoolsUseCase listAllSchoolsUseCase;
    private final RegisterNewSchoolUseCase registerNewSchoolUseCase;
    private final GetSchoolWithStudentsUseCase getSchoolWithStudentsUseCase;

    @GetMapping
    public ResponseEntity<List<SchoolDto>> listAll() {
        var schools = listAllSchoolsUseCase.list()
                .stream()
                .map(SchoolDto::fromSchool)
                .toList();
        return ResponseEntity.ok(schools);
    }

    @PostMapping
    public ResponseEntity<Void> registerNewStudent(@RequestBody SchoolDto registerSchoolRequest) {
        var newSchool = registerNewSchoolUseCase.create(
                new Id(registerSchoolRequest.id()),
                new Name(registerSchoolRequest.name()),
                new Address(registerSchoolRequest.address()),
                new Phone(registerSchoolRequest.phone())
        );
        registerNewSchoolUseCase.register(newSchool);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{schoolId}/students")
    public ResponseEntity<SchoolWithStudentsDto> findSchoolWithStudents(@PathVariable String schoolId) {
        var schoolStudents = getSchoolWithStudentsUseCase.get(new Id(schoolId));
        return ResponseEntity.ok(SchoolWithStudentsDto.from(schoolStudents));
    }

}
