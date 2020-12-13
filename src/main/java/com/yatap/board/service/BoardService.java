package com.yatap.board.service;

import com.yatap.board.domain.dto.BoardDto;
import com.yatap.board.domain.entity.Board;
import com.yatap.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;

    public List<BoardDto> getBoards() {
        return boardRepository.findAll().stream()
                .map(board -> modelMapper.map(board, BoardDto.class))
                .collect(Collectors.toList());
    }

    public BoardDto getBoard(Long id) {
        Board board = boardRepository.findById(id).orElse(new Board());

        return modelMapper.map(board, BoardDto.class);
    }

    public void saveBoard(BoardDto boardDto) {
        Board board = modelMapper.map(boardDto, Board.class);

        boardRepository.save(board);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
