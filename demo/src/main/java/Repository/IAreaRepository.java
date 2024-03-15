package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Area;

@Repository
public interface IAreaRepository extends JpaRepository <Area, Long>{

}
