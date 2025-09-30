package kr.co.sboard.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDTO {

    private int ano;

    @Builder.Default
    private String cate = "free";

    private String title;
    private String content;
    private int content_cnt;
    private int file_cnt;
    private int hit_cnt;
    private String write;
    private String reg_ip;
    private LocalDateTime wdate;

    // 파일 (전송) 업로드 객체
    private MultipartFile file1;
    private MultipartFile file2;

    // 파일 (전송) 업로드 객체를 반환하는 메서드
    public List<MultipartFile> getFiles() {
        return List.of(file1, file2);
    }
}
