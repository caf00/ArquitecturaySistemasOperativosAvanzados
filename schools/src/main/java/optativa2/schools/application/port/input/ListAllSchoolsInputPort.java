package optativa2.schools.application.port.input;

import optativa2.schools.application.ListAllSchoolsUseCase;
import optativa2.schools.application.port.output.ListAllSchoolsOutputPort;
import optativa2.schools.domain.School;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListAllSchoolsInputPort implements ListAllSchoolsUseCase {

    private final ListAllSchoolsOutputPort listAllSchoolsOutputPort;

    @Override
    public List<School> list() {
        return listAllSchoolsOutputPort.retrieve();
    }
}
