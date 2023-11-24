package optativa2.schools.application.port.output;

import optativa2.schools.domain.School;

import java.util.List;

public interface ListAllSchoolsOutputPort {
    List<School> retrieve();
}
