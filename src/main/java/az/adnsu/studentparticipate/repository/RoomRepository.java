package az.adnsu.studentparticipate.repository;

import az.adnsu.studentparticipate.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends JpaRepository<RoomEntity,Long> {

}
