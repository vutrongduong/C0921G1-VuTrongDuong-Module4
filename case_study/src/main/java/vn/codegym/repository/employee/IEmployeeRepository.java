package vn.codegym.repository.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.model.employee.Employee;
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value="SELECT * FROM  Employee where employee_name like concat('%',:name,'%') " +
            " and  position_id like concat('%',:position_id,'%')  and division_id like concat('%',:division_id,'%') " +
            " and education_degree_id like concat('%',:education_degree_id,'%')", nativeQuery=true)
    Page<Employee> search(@Param("name") String name,@Param("position_id") String positionId,
                          @Param("division_id") String divisionId, @Param("education_degree_id")
                                  String educationDegreeId, Pageable pageable);
}
