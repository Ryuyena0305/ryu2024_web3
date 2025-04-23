package web.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.model.entity.ReplyEntity;

public interface ReplyEntityRepository extends
        JpaRepository<ReplyEntity,Long> {
}
