package optativa2.schools.framework.adapter.input.rest.dto;

import optativa2.schools.domain.School;

import java.io.Serializable;

public record SchoolDto(String id, String name, String address, String phone) implements Serializable {
    public static SchoolDto fromSchool(School school) {
        return new SchoolDto(
                school.id().id(),
                school.name().name(),
                school.address().address(),
                school.phone().phone()
        );
    }
}
