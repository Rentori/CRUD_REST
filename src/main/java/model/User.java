package model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ToString.Exclude
    @Transient
    private Long eventId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_events",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")}
    )
    private List<Event> events;

    public User() {
    }

    public User(String firstName, String lastName, Long eventId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eventId = eventId;
    }
}
