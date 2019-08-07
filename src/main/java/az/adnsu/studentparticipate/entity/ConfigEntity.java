package az.adnsu.studentparticipate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "config")
public class ConfigEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "acceptable_latency")
   private int acceptableLatency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAcceptableLatency() {
        return acceptableLatency;
    }

    public void setAcceptableLatency(int acceptableLatency) {
        this.acceptableLatency = acceptableLatency;
    }
}
