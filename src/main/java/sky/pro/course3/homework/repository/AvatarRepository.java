package sky.pro.course3.homework.repository;

import sky.pro.course3.homework.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    Optional<Avatar> findByStudent_id(long studentId);

    @Query(value = "select * from avatar",nativeQuery = true)
    List<Avatar> getAll();
}