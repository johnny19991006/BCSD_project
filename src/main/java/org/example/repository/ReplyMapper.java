package org.example.repository;


import org.example.domain.Reply;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyMapper {
    Reply getReplyById(Long ReplyId);

    void create(Reply reply);

    void update(Reply reply);

    void delete(Long ReplyId);
}

