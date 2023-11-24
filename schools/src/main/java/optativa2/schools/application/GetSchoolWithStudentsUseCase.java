package optativa2.schools.application;

import optativa2.schools.domain.School;
import optativa2.schools.domain.vo.Id;

public interface GetSchoolWithStudentsUseCase {
    School get(Id schoolId);
}
