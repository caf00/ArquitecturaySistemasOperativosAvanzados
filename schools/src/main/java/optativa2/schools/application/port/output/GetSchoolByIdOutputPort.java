package optativa2.schools.application.port.output;

import optativa2.schools.domain.School;
import optativa2.schools.domain.vo.Id;

public interface GetSchoolByIdOutputPort {
    School getById(Id id);
}
