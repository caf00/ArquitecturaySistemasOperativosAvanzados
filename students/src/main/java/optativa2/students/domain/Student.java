package optativa2.students.domain;

import optativa2.students.domain.vo.FirstName;
import optativa2.students.domain.vo.Id;
import optativa2.students.domain.vo.LastName;
import optativa2.students.domain.vo.Phone;

public record Student(Id id, FirstName firstname, LastName lastname, Phone phone, Id schoolId) {}
