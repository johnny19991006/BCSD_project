package org.example.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.example.domain.Reply;
import org.example.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/replys")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    @ApiOperation(value = "댓글 읽기", notes = "댓글을 가져옵니다")
    @RequestMapping(value = "/{ReplyId}", method = RequestMethod.GET)
    public Reply replyInfo(@ApiParam(name = "id", value = "(required:id)", required = true) @PathVariable("ReplyId") Long ReplyId) {
        return replyService.getReplyInfo(ReplyId);
    }

    @ApiOperation(value = "댓글 쓰기", notes = "댓글을 씁니다")
    @PostMapping()
    public ResponseEntity createReply(@RequestBody Reply reply) {
        replyService.createReply(reply);
        return new ResponseEntity<>("create Reply", HttpStatus.OK);
    }

    @ApiOperation(value = "댓글 최신화", notes = "댓글을 고칩니다")
    @PutMapping("/{ReplyId}")
    public ResponseEntity updateReply(@ApiParam(name = "id", value = "(required:id)", required = true) @PathVariable Long ReplyId, @RequestBody Reply reply) {
        replyService.updateReply(ReplyId, reply);
        return new ResponseEntity<>("update Reply", HttpStatus.OK);
    }

    @ApiOperation(value = "댓글 삭제", notes = "댓글을 삭제합니다")
    @DeleteMapping("/{ReplyId}")
    public ResponseEntity deleteReply(@ApiParam(name = "id", value = "(required:id)", required = true) @PathVariable Long ReplyId) {
        replyService.deleteReply(ReplyId);
        return new ResponseEntity("delete Reply", HttpStatus.OK);
    }
}
