package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Reply;
import org.example.repository.ReplyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyMapper replyMapper;


    @Transactional
    public Reply getReplyInfo(long ReplyId) {
        return replyMapper.getReplyById(ReplyId);
    }

    @Transactional
    public void createReply(Reply reply) {
        replyMapper.create(reply);
    }

    @Transactional
    public void updateReply(long ReplyId, Reply updateReply) {

        Reply replyTest = replyMapper.getReplyById(ReplyId);

        if (replyTest != null) {

           /* replyTest = Reply.builder()
                    .ReplyContent(updateReply.getReplyContent())
                    .ReplyLike(updateReply.getReplyLike())
                    .Reply_BoardId(updateReply.getReply_BoardId())
                    .Reply_UserId(updateReply.getReply_UserId())
                    .RegisterDate(updateReply.getRegisterDate())
                    .UpdateDate(updateReply.getUpdateDate())
                    .DeleteDate(updateReply.getDeleteDate())
                    .build();*/
            replyTest.setReplyContent(updateReply.getReplyContent());
            replyTest.setReplyLike(updateReply.getReplyLike());
            replyTest.setReply_BoardId(updateReply.getReply_BoardId());
            replyTest.setReply_UserId(updateReply.getReply_UserId());
            replyTest.setRegisterDate(updateReply.getRegisterDate());
            replyTest.setUpdateDate(updateReply.getUpdateDate());
            replyTest.setDeleteDate(updateReply.getDeleteDate());
            replyMapper.update(replyTest);
        } else {
            throw new IllegalStateException("회원이 존재하지 않습니다.");
        }

    }


    @Transactional
    public void deleteReply(long ReplyId) {
        if (replyMapper.getReplyById(ReplyId) != null) {
            replyMapper.delete(ReplyId);
        } else {
            throw new IllegalStateException("회원이 존재하지 않습니다");
        }
    }
}
