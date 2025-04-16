package web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import web.model.dto.MemberDto;
import web.service.MemberService;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor // final(수정불가) 필드의 생성자 자동 생성
@CrossOrigin("*")

//-> 관례적으로 클래스 내부에서 사용하는 모든 필드들을 수정못하도록 final 사용한다.
//-> 즉 final 사용시 @RequiredArgsConstructor 때문에 @Autowired 안해도 된다.
public class MemberController {
    private final MemberService memberService;

    // [1]회원가입
    //{"memail":"bear","mpwd":"1234","mname":"mumu"}
    @PostMapping("/signup")
    public boolean signUp(@RequestBody MemberDto memberDto){
        return memberService.signUp(memberDto);
    }

    // [2]로그인
    //{"memail":"bear","mpwd":"1234"}
    //eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiZWFyIiwiaWF0IjoxNzQ0NzcwNjcyLCJleHAiOjE3NDQ4NTcwNzJ9.7GbKB0WYxC4N6Y9Ybo0WLY1C_3kNg9RvRex4DNKSn3M
    @PostMapping("/login")
    public String login(@RequestBody MemberDto memberDto){
        return memberService.login(memberDto);
    }
    
    // [3]로그인된 회원 검증/ 내정보 조회
    @GetMapping("/info")
    //@RequestHeader : HTTP 헤더 정보를 매핑하는 어노테이션, JWT정보는 HTTP 헤더에 담을 수 있다.
        //Authorization : 인증 속성, { Authorization : token값}
    //@RequestParam : HTTP 헤더의 쿼리스트링 매핑하는 어노테이션
    //@RequestBody : HTTP 본문의 객체를 매핑하는 어노테이션
    //@PathVariable : HTTP 헤더의 경로 값 매핑하는 어노테이션
    public MemberDto info(@RequestHeader("Authorization") String token){
        System.out.println(token);
        return memberService.info(token);
    }
        

}
