package model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "event_name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private File file;

    @ToString.Exclude
    @ManyToMany(mappedBy = "events", fetch = FetchType.LAZY)
    private List<User> users;

    public Event(Long id, String name, File file) {
        this.id = id;
        this.name = name;
        this.file = file;
    }

    public Event(String name, File file) {
        this.name = name;
        this.file = file;
    }

    public Event() {
    }
}
