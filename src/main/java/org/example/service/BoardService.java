package org.example.service;

import org.example.domain.Board;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;


public interface BoardService {
    Board getBoardInfo(long BoardId);

    void createBoard(Board board);


    void updateBoard(long BoardId, Board board);

    void deleteBoard(long BoardId);
}
