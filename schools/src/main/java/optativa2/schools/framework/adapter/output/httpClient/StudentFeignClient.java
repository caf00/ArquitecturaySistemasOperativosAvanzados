package optativa2.schools.framework.adapter.output.httpClient;

import optativa2.schools.domain.vo.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "students", url = "${application.config.student-url}")
public interface StudentFeignClient {
    @GetMapping("/school/{schoolId}")
    public List<Student> get(@PathVariable String schoolId);
}
