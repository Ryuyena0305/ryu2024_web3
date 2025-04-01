package example._엔티티;

import jakarta.persistence.*;

@Entity
@Table(name="exam2")
public class ExamEntity2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
    private long id;

    @Column(nullable = true,unique = true)
    private String col1;

    @Column(nullable = false,unique = false)
    private String col2;

    @Column(columnDefinition = "longtext")
    private String col3;
}
