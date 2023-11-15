package sky.pro.course3.homework.repository;

import sky.pro.course3.homework.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Collection<Student> findStudentsByAgeBetween(int min,int max);

    Collection<Student> findAllByAge(int age);

    @Query(value = "select count(*) from student", nativeQuery = true)
    Integer getCountAvatar();
    @Query(value = "select avg(age) from student", nativeQuery = true)
    Integer getAvgAge();
    @Query(value = "select * from (select * from student order by  id desc limit 5) t order by id;",nativeQuery = true)
    List<Student> getLastFive();
}