//package kr.co.sboard.service;
//
//import kr.co.sboard.dto.CommentDTO;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest
//class CommentServiceTest {
//
//    @Autowired
//    private CommentService commentService;
//
//    @Test
//    void getCommentAll() {
//
//        List<CommentDTO> dtoList = commentService.getCommentAll(5);
//        System.out.println(dtoList);
//    }
//
//    @Test
//    void getComment() {
//    }
//
//    @Test
//    void save() {
//
//        CommentDTO commentDTO = CommentDTO.builder()
//                .ano(10)
//                .content("5번 댓글 1")
//                .writer("susu")
//                .reg_ip("127.0.0.1")
//                .build();
//
//        CommentDTO savedCommentDTO = commentService.save(commentDTO);
//        System.out.println(savedCommentDTO);
//    }
//
//    @Test
//    void update() {
//    }
//
//    @Test
//    void delete() {
//    }
//}