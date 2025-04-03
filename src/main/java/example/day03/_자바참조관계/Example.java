package example.day03._자바참조관계;

import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        //참조 : 실제 인스턴스의 (주소) 위치
        //1. 인스턴스 생성
        //2. 생성된 인스턴스를 변수가 참조한다.
        Category category = new Category();

        //참조안에 참조안에 참조(도트연산자)
        category.set카테고리번호(1);
        category.set카테고리명("공지사항");

        //3. 변수가 참조하는 인스턴스에는 2개의 멤버변수를 참조
        System.out.println(category.get카테고리번호());
        System.out.println(category.get카테고리명());

        //4. '공지사항' 카테고리를 참조하는 게시물 인스턴스 생성
        Board board = Board.builder()
                .게시물번호(1)
                .게시물제목("안녕하세요")
                .게시물내용("하하하")
                .category(category)
                .build();

        //5. board 변수가 참조 횟수 : 변수기준 board참조 7개
        // board는 board참조인거삼?? ㅇㅇㅇㅇㅇ
        // board안에는 번호 제목 내용 카테고리 4개
        // category안에 카테고리번호 카테고리명 2개
        System.out.println(board.get게시물번호());
        System.out.println(board.get게시물제목());
        System.out.println(board.get게시물내용());
        System.out.println(board.getCategory().get카테고리번호());
        System.out.println(board.getCategory().get카테고리명());

        //6. '공지사항' 카테고리에 '1번 게시물'의 댓글 등록;
        Reply reply = Reply.builder()
                .댓글번호(1)
                .댓글내용("댓글입니다")
                .board(board) //1번 댓글에 1번게시물 인스턴스를 대입
                .build();
        
        //6. reply 변수가 참조횟수 : 
        // 리플 리플 참조
        // 리플 댓글번호 댓글내용 보드  참조 
        System.out.println(reply.get댓글번호());
        System.out.println(reply.get댓글내용());
        System.out.println(reply.getBoard().get게시물번호());
        System.out.println(reply.getBoard().get게시물제목());
        System.out.println(reply.getBoard().get게시물내용());
        System.out.println(reply.getBoard().getCategory().get카테고리번호());
        System.out.println(reply.getBoard().getCategory().get카테고리명());


        //[단방향]
        //7. reply 객체에서 board객체와 category 객체 알수 있다? [o]
        //7. category 객체에서 board객체 reply객체 알수 있다? [x]
        //System.out.println(category.getBoard());

        //[양방향]
        //7. reply 객체에서 board객체와 category 객체 알수 있다? [o]
        //7. category 객체에서 board객체 reply객체 알수 있다? [o]
        category.setBoardList(new ArrayList<>());
        category.getBoardList().add(board);
        board.setReplyList(new ArrayList<>());
        board.getReplyList().add(reply);
        System.out.println(category.getBoardList().get(0).getReplyList().get(0));

        //*StackOverflowError


        

    }
}
