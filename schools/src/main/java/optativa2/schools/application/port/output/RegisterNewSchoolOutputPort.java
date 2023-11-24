package optativa2.schools.application.port.output;

import optativa2.schools.domain.School;

public interface RegisterNewSchoolOutputPort {
    boolean exists(School school);

    void persist(School school);
}
