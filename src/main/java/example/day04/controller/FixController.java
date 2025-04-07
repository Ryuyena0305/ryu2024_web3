package example.day04.controller;

import example.day04.model.dto.FixDto;
import example.day04.service.FixService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day04/fixs")
@RequiredArgsConstructor
public class FixController {
    private final FixService fixService;

    //등록
    @PostMapping
    public FixDto fixSave(@RequestBody FixDto fixDto){
        return fixService.fixSave(fixDto);
    }
    //전체조회
    @GetMapping
    public List<FixDto> fixFindAll(){
        return fixService.fixFindAll();
    }
    //개별조회
    @GetMapping("/view")
    public FixDto fixFindById(@RequestParam int fid){
        return fixService.fixFindById(fid);
    }
    //수정
    @PutMapping
    public FixDto fixUpdate(@RequestBody FixDto fixDto){
        return fixService.fixUpdate(fixDto);
    }
    @DeleteMapping
    public boolean fixDelete(@RequestParam int fid){
        return fixService.fixDelete(fid);
    }

    @GetMapping("/page")
    public List<FixDto> fixFindByPage(
            @RequestParam(defaultValue = "1") int page, @RequestParam (defaultValue = "3")int size){
        return fixService.fixFindByPage(page,size);
    }

}
