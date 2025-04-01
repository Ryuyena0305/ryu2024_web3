package example._과제;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day01/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public boolean post(@RequestBody BookEntity bookEntity){
        boolean result = bookService.post(bookEntity);
        return result;
    }

    @GetMapping
    public List<BookEntity>get(){
        return bookService.get();
    }

    @PutMapping
    public boolean put(@RequestBody BookEntity bookEntity){
        boolean result = bookService.put(bookEntity);
        return result;
    }

    @DeleteMapping
    public boolean delete(@RequestParam int bid){
        boolean result = bookService.delete(bid);
        return result;
    }

}
