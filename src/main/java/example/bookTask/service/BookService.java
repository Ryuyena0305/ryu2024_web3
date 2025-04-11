package example.bookTask.service;

import example.bookTask.model.dto.BookDto;
import example.bookTask.model.entity.BookEntity;
import example.bookTask.model.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BookDto bookSave(BookDto bookDto){
        BookEntity bookEntity = bookDto.toEntity();
        BookEntity saveEntity = bookRepository.save(bookEntity);
        if(saveEntity.getBid()>0){
            return saveEntity.bookDto();
        }else{
            return null;
        }


    }
    public List<BookDto> bookFindAll(){
        return bookRepository.findAll().stream().map(BookEntity::bookDto).collect(Collectors.toList());
    }
    public BookDto bookFindById(int bid){
        return bookRepository.findById(bid).map(BookEntity::bookDto).orElse(null);
    }

    public BookDto bookUpdate(BookDto bookDto){
        return bookRepository.findById(bookDto.getBid())
                .map((entity) ->{

                    entity.setBname(bookDto.getBname());
                    entity.setBwriter(bookDto.getBwriter());
                    entity.setBcontent(bookDto.getBcontent());
                    entity.setBpwd(bookDto.getBpwd());
                    return entity.bookDto();
                } ).orElse(null);
    }
    public boolean bookDelete(int bid){
        return bookRepository.findById(bid)
                .map((entity)->{
                    bookRepository.deleteById(bid);
                    return true;
                })
                .orElse(false);
    }

}
