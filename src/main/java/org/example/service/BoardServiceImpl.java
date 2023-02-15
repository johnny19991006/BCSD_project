package org.example.service;


import lombok.RequiredArgsConstructor;
import org.example.domain.Board;
import org.example.repository.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Transactional
    public Board getBoardInfo(long BoardId) {
        return boardMapper.getBoardById(BoardId);
    }

    @Transactional
    public void createBoard(Board board) {
        boardMapper.create(board);
    }


    @Transactional
    public void updateBoard(long BoardId, Board updateBoard) {
        Board boardTest = boardMapper.getBoardById(BoardId);

        if (boardTest != null) {

            boardTest.setBoardTitle(updateBoard.getBoardTitle());
            boardTest.setBoardContent(updateBoard.getBoardContent());
            boardTest.setBoardWriter(updateBoard.getBoardWriter());
            boardTest.setRegisterDate(updateBoard.getRegisterDate());
            boardTest.setUpdateDate(updateBoard.getUpdateDate());
            boardTest.setDeleteDate(updateBoard.getDeleteDate());
            boardTest.setBoard_CategoryId(updateBoard.getBoard_CategoryId());
            boardTest.setBoard_UserId(updateBoard.getBoard_UserId());
            boardMapper.update(boardTest);
        } else {
            throw new IllegalStateException("회원이 존재하지 않습니다.");
        }

    }

    @Transactional
    public void deleteBoard(long BoardId) {
        if (boardMapper.getBoardById(BoardId) != null) {
            boardMapper.delete(BoardId);
        } else {
            throw new IllegalStateException("회원이 존재하지 않습니다");
        }
    }

}

