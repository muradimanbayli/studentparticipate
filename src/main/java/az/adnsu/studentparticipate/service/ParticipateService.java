package az.adnsu.studentparticipate.service;

import az.adnsu.studentparticipate.entity.ConfigEntity;
import az.adnsu.studentparticipate.entity.ParticipationType;
import az.adnsu.studentparticipate.entity.ParticipleEntity;
import az.adnsu.studentparticipate.entity.TypeInout;
import az.adnsu.studentparticipate.repository.ConfigRepository;
import az.adnsu.studentparticipate.repository.ParticipleRepository;
import az.adnsu.studentparticipate.repository.RoomRepository;
import az.adnsu.studentparticipate.util.Lesson;
import az.adnsu.studentparticipate.util.Schedule;
import az.adnsu.studentparticipate.util.SystemResourceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipateService {

    @Autowired
    private ParticipleRepository repository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ConfigRepository configRepository;

    @Transactional
    public void register(String cardId) {
        ParticipleEntity entity = new ParticipleEntity();

        Long roomId = findRoomId();
        TypeInout inout = findInOut(cardId,roomId);

        entity.setParticipleDate(LocalDateTime.now());
        entity.setCardId(cardId);
        entity.setInpout(inout);
        entity.setParticipation(findParticipated());
        entity.setRoomId(roomId);

        repository.save(entity);

    }

    public List<ParticipleEntity> findParticipleEntityList(){
        return repository.findAllByParticipleDateAfterOrderByParticipleDateDesc(LocalDate.now().atStartOfDay())
                .orElseGet(()->new ArrayList<>());
    }

    private ParticipationType findParticipated(){
        Optional<ConfigEntity> optionalConfigEntity = configRepository.findAll().stream().findFirst();

        LocalTime now = LocalTime.now();

        if(optionalConfigEntity.isPresent()){
            now.minusMinutes(optionalConfigEntity.get().getAcceptableLatency());
        }

        Optional<Lesson> optionalCurrentLesson = Schedule.data.stream().filter(l->l.getEnd().isAfter(now)).findFirst();

        if(optionalCurrentLesson.isPresent()){
            if(optionalCurrentLesson.get().getBegin().isAfter(now)){
                return ParticipationType.PARTICIPATED;
            }
        }

        return ParticipationType.NOT_PARTICIPATED;
    }

    private Long findRoomId() {
        return roomRepository.findAll()
                .stream()
                .filter(r -> r.getMac().equals(SystemResourceHelper.findMacAddress()))
                .findFirst()
                .get()
                .getId();
    }

    private TypeInout findInOut(String cardId,Long roomId){
        Optional<ParticipleEntity> optionalParticipleEntity = repository.findTopByCardIdAndParticipleDateAfterAndRoomIdOrderByParticipleDateDesc(
                cardId, LocalDate.now().atStartOfDay(),roomId);

        if(!optionalParticipleEntity.isPresent()){
            return TypeInout.IN;
        } else {
            if(optionalParticipleEntity.get().getInpout() == TypeInout.IN){
                return TypeInout.OUT;
            } else {
                return TypeInout.IN;
            }
        }
    }


}
