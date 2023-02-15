package org.example.repository;

import org.example.domain.Board;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface BoardMapper {
    Board getBoardById(Long BoardId);


    void create(Board board);

    void update(Board board);

    void delete(Long BoardId);

}

