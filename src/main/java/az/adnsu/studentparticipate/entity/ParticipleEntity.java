package az.adnsu.studentparticipate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "participle")
public class ParticipleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "card_id")
    private String cardId;

    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "participle_date")
    private LocalDateTime participleDate;

    @Column(name = "in_out")
    @Enumerated(EnumType.STRING)
    private TypeInout inpout;

    @Column(name = "participation")
    @Enumerated(EnumType.STRING)
    private ParticipationType participation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public LocalDateTime getParticipleDate() {
        return participleDate;
    }

    public void setParticipleDate(LocalDateTime participleDate) {
        this.participleDate = participleDate;
    }

    public TypeInout getInpout() {
        return inpout;
    }

    public void setInpout(TypeInout inpout) {
        this.inpout = inpout;
    }

    public ParticipationType getParticipation() {
        return participation;
    }

    public void setParticipation(ParticipationType participation) {
        this.participation = participation;
    }

    @Override
    public String toString() {
        return "ParticipleEntity{" +
                "id=" + id +
                ", cardId='" + cardId + '\'' +
                ", roomId=" + roomId +
                ", participleDate=" + participleDate +
                ", inpout=" + inpout +
                ", participation=" + participation +
                '}';
    }
}
