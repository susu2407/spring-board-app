package kr.co.sboard.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {

    private int cno;
    private int ano;
    private String content;
    private String writer;
    private String reg_ip;
    private String wdate;

    // 추가필드
    private String nick;


}
