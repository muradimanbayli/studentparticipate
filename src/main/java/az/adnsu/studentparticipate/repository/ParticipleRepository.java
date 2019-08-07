package az.adnsu.studentparticipate.repository;

import az.adnsu.studentparticipate.entity.ParticipleEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ParticipleRepository extends CrudRepository<ParticipleEntity, Long> {

    Optional<ParticipleEntity> findTopByCardIdAndParticipleDateAfterAndRoomIdOrderByParticipleDateDesc(String cardId,
                                                                                                  LocalDateTime participleDate,
                                                                                                  Long roomId);

    Optional<List<ParticipleEntity>> findAllByParticipleDateAfterOrderByParticipleDateDesc(LocalDateTime participleDate);
}
