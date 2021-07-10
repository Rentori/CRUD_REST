package model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "file_name")
    private String name;

    @ToString.Exclude
    @OneToOne(mappedBy = "file", cascade = CascadeType.ALL, optional = true)
    private Event event;

    public File() {
    }

    public File(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public File(String name) {
        this.name = name;
    }

    public File(Long id) {
        this.id = id;
    }
}
