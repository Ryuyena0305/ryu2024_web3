package example._과제;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cache;

import java.time.LocalDate;

@Entity @Table(name="taskbook")
@Data
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bid;

    @Column( length = 50, nullable = false)
    private String bname;

    @Column( length = 20, nullable = false)
    private String writer;

    @Column
    private String bpublish;

    @Column(nullable = false)
    private LocalDate bdate;
}
