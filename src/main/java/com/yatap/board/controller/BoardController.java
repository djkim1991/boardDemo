package com.yatap.board.controller;

import com.yatap.board.domain.dto.BoardDto;
import com.yatap.board.domain.dto.ResponseDto;
import com.yatap.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boards")
    public ResponseDto getBoards() {
        return ResponseDto.builder()
                .data(boardService.getBoards())
                .build();
    }

    @GetMapping("/board/{id}")
    public ResponseDto getBoard(@PathVariable Long id) {
        return ResponseDto.builder()
                .data(boardService.getBoard(id))
                .build();
    }

    @PostMapping("/board")
    public ResponseDto postBoard(@ModelAttribute BoardDto boardDto) {
        boardService.saveBoard(boardDto);

        return ResponseDto.builder().build();
    }

    @DeleteMapping("/board/{id}")
    public ResponseDto deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);

        return ResponseDto.builder().build();
    }
}
