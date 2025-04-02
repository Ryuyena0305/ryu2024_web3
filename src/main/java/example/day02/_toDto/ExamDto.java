package example.day02._toDto;

import lombok.Builder;
import lombok.Data;

//DTO : 서로 다른 계층/레이어 강의 이동 객체
@Data
@Builder
public class ExamDto {
    private String id;
    private String title;
    private int price;

    public ExamEntity1 toEntity(){
        return ExamEntity1.builder()
               .id(id)
               .title(title)
               .price(price)
               .build();
    }
}
