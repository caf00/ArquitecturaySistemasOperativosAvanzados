package optativa2.schools.framework.adapter.output.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "schools")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolData implements Serializable {
    @Id
    private String id;
    private String name;
    private String address;
    private String phone;
}
