package example._과제;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookEntityRepository bookEntityRepository;

    public boolean post(BookEntity bookEntity){
        BookEntity bookEntity2 = bookEntityRepository.save(bookEntity);
        return true;
    }

    public List<BookEntity> get(){
        List<BookEntity> bookEntityList =
                bookEntityRepository.findAll();
        return bookEntityList;
    }

    public boolean put(BookEntity bookEntity){
        bookEntityRepository.save(bookEntity);
        return true;
    }

    public boolean delete(int bid){
        bookEntityRepository.deleteById(bid);
        System.out.println(bookEntityRepository.count());
        System.out.println(bookEntityRepository.existsById(bid));
        return true;
    }

}
