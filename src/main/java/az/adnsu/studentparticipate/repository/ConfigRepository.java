package az.adnsu.studentparticipate.repository;

import az.adnsu.studentparticipate.entity.ConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ConfigRepository extends JpaRepository<ConfigEntity, Long> {

}
