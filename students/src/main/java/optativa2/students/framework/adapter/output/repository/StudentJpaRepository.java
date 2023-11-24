package optativa2.students.framework.adapter.output.repository;

import optativa2.students.framework.adapter.output.data.StudentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentData, String> {
    List<StudentData> findAllBySchoolId(String schoolId);
}
