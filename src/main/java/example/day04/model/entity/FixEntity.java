package example.day04.model.entity;

import example.day04.model.dto.BaseTime;
import example.day04.model.dto.FixDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="fix")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class FixEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;
    private String fname;
    private String fdesc;
    private int fquent;

    //entity -> dto
    public FixDto fixDto(){
        return FixDto.builder()
                .fid(this.fid)
                .fname(this.fname)
                .fdesc(this.fdesc)
                .fquent(this.fquent)
                .createTime(this.getCreateAt())
                .updateTime(this.getUpdateAt())
                .build();
    }
}
