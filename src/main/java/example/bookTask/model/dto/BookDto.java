package example.bookTask.model.dto;

import example.bookTask.model.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private int bid;
    private String bname;
    private String bwriter;
    private String bcontent;
    private String bpwd;

public BookEntity toEntity(){
    return BookEntity.builder()
            .bid(this.bid)
            .bname(this.bname)
            .bwriter(this.bwriter)
            .bcontent(this.bcontent)
            .bpwd(this.bpwd)
            .build();
}
}
