package web.model.dto;

import example.bookTask.model.entity.BookEntity;
import lombok.*;
import web.model.entity.MemberEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MemberDto {

    private int mno;
    private String memail;
    private String mpwd;
    private String mname;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .mno(this.mno)
                .memail(this.memail)
                .mpwd(this.mpwd)
                .mname(this.mname)
                .build();
    }
}
