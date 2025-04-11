package example.bookTask.model.dto;

import example.bookTask.model.entity.BookEntity;
import example.bookTask.model.entity.ReviewEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDto {
    private int rid;
    private int bid;
    private String rcontent;
    private String rpwd;

    public ReviewEntity toReviewEntity(BookEntity bookEntity){
        return ReviewEntity.builder()
                .rid(this.rid)
                .rcontent(this.rcontent)
                .rpwd(this.rpwd)
                .bookEntity(bookEntity)
                .build();
    }
}