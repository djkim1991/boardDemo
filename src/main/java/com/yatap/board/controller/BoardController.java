package com.yatap.board.controller;

import com.yatap.board.domain.dto.BoardDto;
import com.yatap.board.domain.dto.ResponseDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class BoardController {

    @GetMapping("/boards")
    public ResponseDto getBoards() {

        List<Long> ids = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        List<BoardDto> boards = ids.stream()
                .map(id -> (BoardDto.builder()
                        .id(id)
                        .title("title")
                        .contents("contents")
                        .createdAt(LocalDateTime.now())
                        .modifiedAt(LocalDateTime.now())
                        .build()))
                .collect(Collectors.toList());

        return ResponseDto.builder()
                .data(boards)
                .build();
    }

    @GetMapping("/board")
    public ResponseDto getBoard() {
        return ResponseDto.builder().build();
    }

    @PostMapping("/board")
    public ResponseDto postBoard() {
        return ResponseDto.builder().build();
    }

    @DeleteMapping("/board")
    public ResponseDto deleteBoard() {
        return ResponseDto.builder().build();
    }
}
