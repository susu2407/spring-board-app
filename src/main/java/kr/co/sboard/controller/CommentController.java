package kr.co.sboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.dto.CommentDTO;
import kr.co.sboard.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comments/{ano}")
    public ResponseEntity<?> list(@PathVariable("ano") int ano){
        List<CommentDTO> dtoList = commentService.getCommentAll(ano);
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/comment/{cno}")
    public ResponseEntity<?> comment(@PathVariable("cno") int cno){
        CommentDTO commentDTO = commentService.getComment(cno);
        return ResponseEntity.ok(commentDTO);
    }

    @PostMapping("/comment")
    public ResponseEntity<?> register(@RequestBody CommentDTO commentDTO, HttpServletRequest request){
        log.info("commentDTO = {}", commentDTO);

        String regip = request.getRemoteAddr();
        commentDTO.setReg_ip(regip);

        CommentDTO savedComment = commentService.save(commentDTO);

        log.info("savedComment = {}", savedComment);

        return ResponseEntity.ok(savedComment);
    }

    @PutMapping("/comment")
    public void modify(){}

    @DeleteMapping("/comment")
    public void delete(){}

    // (처음)아직은 반환에 대해서 정해지지 않았으니, void로 둘게요.

}
