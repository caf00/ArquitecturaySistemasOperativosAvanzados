package optativa2.schools.application.port.input;

import optativa2.schools.application.RegisterNewSchoolUseCase;
import optativa2.schools.application.port.output.RegisterNewSchoolOutputPort;
import optativa2.schools.domain.School;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterNewSchoolInputPort implements RegisterNewSchoolUseCase {

    private final RegisterNewSchoolOutputPort registerNewSchoolOutputPort;

    @Override
    public void register(School school) {

        if(registerNewSchoolOutputPort.exists(school)) {
            throw new RuntimeException("School already exist");
        }

        registerNewSchoolOutputPort.persist(school);

    }
}
