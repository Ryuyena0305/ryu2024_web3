package web.model.entity;

import example.bookTask.model.dto.BookDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.model.dto.MemberDto;

@Entity @Table(name="member")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno;
    private String memail;
    private String mpwd;
    private String mname;

    public MemberDto toDto(){
        return MemberDto.builder()
                .mno(this.mno)
                .memail(this.memail)
                .mname(this.mname)
                .build();
    }

}
