package kr.co.sboard.dto;


import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Data
@Component      //  Been으로 만드는
@SessionScope // ★ 각 세션(사용자)마다 생성
public class SessionDataDTO {

    private String code;

}
