package optativa2.schools.application;

import optativa2.schools.domain.School;
import optativa2.schools.domain.vo.Address;
import optativa2.schools.domain.vo.Id;
import optativa2.schools.domain.vo.Name;
import optativa2.schools.domain.vo.Phone;

public interface RegisterNewSchoolUseCase {

    default School create(Id id, Name name, Address address, Phone phone) {
        return School.register(id, name, address, phone);
    }

    void register(School school);

}
