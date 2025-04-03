package example.day03._자바참조관계;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class Category {
    //클래스 : 인스턴스(객체)의 설계/타입
    private int 카테고리번호; // 멤버변수 선언
    private String 카테고리명;//멤버변수 선언
    @ToString.Exclude
    private List<Board> boardList;
    //private Board board;//양방향 참조

}
