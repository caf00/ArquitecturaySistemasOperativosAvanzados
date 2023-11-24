package optativa2.students.framework.adapter.output.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentData implements Serializable {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String phone;
    private String schoolId;
}
