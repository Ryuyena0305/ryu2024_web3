package example.day04.model.dto;

import example.day04.model.entity.FixEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class FixDto {
    private int fid;
    private String fname;
    private String fdesc;
    private int fquent;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public FixEntity toEntity(){
        return FixEntity.builder()
                .fid(this.fid)
                .fname(this.fname)
                .fdesc(this.fdesc)
                .fquent(this.fquent)
                .build();
    }
}
