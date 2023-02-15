package org.example.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.example.domain.Board;
import org.example.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;


    @ApiOperation(value = "게시글 만들기", notes = "게시글을 만듭니다")
    @PostMapping()
    public ResponseEntity createBoard(@RequestBody Board board) {
        boardService.createBoard(board);
        return new ResponseEntity<>("boardCreate", HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 조회", notes = "게시글을 조회합니다")
    @RequestMapping(value = "/{BoardId}", method = RequestMethod.GET)
    public Board boardInfo(@ApiParam(name = "id", value = "(required:id)", required = true) @PathVariable("BoardId") Long BoardId) {
        return boardService.getBoardInfo(BoardId);
    }


    @ApiOperation(value = "게시글 최신화", notes = "게시글을 최신화 합니다")
    @PutMapping("/{BoardId}")
    public ResponseEntity updateBoard(@ApiParam(name = "id", value = "(required:id)", required = true) @PathVariable Long BoardId, @RequestBody Board board) {
        boardService.updateBoard(BoardId, board);
        return new ResponseEntity<>("boardUpdate", HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 삭제", notes = "게시글을 삭제합니다")
    @DeleteMapping("/{BoardId}")
    public ResponseEntity deleteBoard(@ApiParam(name = "id", value = "(required:id)", required = true) @PathVariable Long BoardId) {
        boardService.deleteBoard(BoardId);
        return new ResponseEntity<>("delete Board", HttpStatus.OK);
    }


}

