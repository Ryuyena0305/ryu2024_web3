package example.day03._JPA연관관계;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name ="day03reply")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rno;
    private String rcontent;

    @ManyToOne //fk 선언법
    private Board board;
}
