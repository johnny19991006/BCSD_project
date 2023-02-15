package org.example.service;


import org.example.domain.Reply;

public interface ReplyService {
    Reply getReplyInfo(long ReplyId);

    void createReply(Reply reply);

    void updateReply(long ReplyId, Reply reply);

    void deleteReply(long ReplyId);
}
