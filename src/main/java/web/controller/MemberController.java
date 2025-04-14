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

    @PostMapping("/signup")
    public boolean signUp(@RequestBody MemberDto memberDto){
        return memberService.signUp(memberDto);
    }
}
