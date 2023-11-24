package optativa2.schools.framework.adapter.output.repository;

import optativa2.schools.framework.adapter.output.data.SchoolData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SchoolJpaRepository extends JpaRepository<SchoolData, String> {
}
