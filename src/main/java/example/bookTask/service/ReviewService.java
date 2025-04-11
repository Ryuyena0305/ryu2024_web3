package example.bookTask.service;

import example.bookTask.model.dto.ReviewDto;
import example.bookTask.model.entity.BookEntity;
import example.bookTask.model.entity.ReviewEntity;
import example.bookTask.model.repository.BookRepository;
import example.bookTask.model.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    public ReviewDto reviewSave(ReviewDto reviewDto){
        // 먼저 BookEntity를 가져온다
        BookEntity bookEntity = bookRepository.findById(reviewDto.getBid()).orElse(null);
        if (bookEntity == null) return null;

        // 인자 없이 부르면 안 됨! bookEntity를 넘겨줘야 함
        ReviewEntity reviewEntity = reviewDto.toReviewEntity(bookEntity);

        ReviewEntity saved = reviewRepository.save(reviewEntity);
        return saved.toReviewDto();
    }
    public boolean reviewDelete(int rid){
        boolean result = reviewRepository.existsById(rid);
        if (result == true) {
            reviewRepository.deleteById(rid);
            return true;
        }
        return false;
    }
    public List<ReviewDto> reviewListByBook(int bid) {
        BookEntity bookEntity = bookRepository.findById(bid).orElse(null);
        if (bookEntity == null) return Collections.emptyList();

        List<ReviewEntity> reviewEntities = reviewRepository.findAllByBookEntity_Bid(bid);

        List<ReviewDto> reviewDtos = new ArrayList<>();
        for (ReviewEntity reviewEntity : reviewEntities) {
            reviewDtos.add(reviewEntity.toReviewDto());
        }
        return reviewDtos;
    }

}