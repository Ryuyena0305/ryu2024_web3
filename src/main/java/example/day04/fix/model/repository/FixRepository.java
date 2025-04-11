package example.day04.fix.model.repository;

import example.day04.fix.model.entity.FixEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixRepository extends JpaRepository<FixEntity,Integer> {

}
