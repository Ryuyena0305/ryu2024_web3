package example.day04.model.entity;

import example.day04.model.dto.BaseTime;
import example.day04.model.dto.TodoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name ="todo")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class TodoEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //할일 제목
    private String title;// 할일 제목
    private String content;// 할일 내용
    private boolean done;//할일 상태

    //entity -> dto 변환함수
    public TodoDto toDto(){
    //entity에서 dto로 변환할 필드 선택하여 dto객체 만들기
        return TodoDto.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .done(this.done)
                .createAt(this.getCreateAt())//BaseTime에 존재함
                .build();
    }
}
