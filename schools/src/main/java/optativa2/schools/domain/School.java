package optativa2.schools.domain;

import optativa2.schools.domain.vo.*;

import java.util.Collections;
import java.util.List;

public record School(Id id, Name name, Address address, Phone phone, List<Student> students) {
    public static School register(Id id, Name name, Address address, Phone phone) {
        return new School(id, name, address, phone, Collections.emptyList());
    }

    public School addStudents(List<Student> students) {
        return new School(this.id, this.name, this.address, this.phone, students);
    }
}
