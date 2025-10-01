package kr.co.sboard.controller;

import kr.co.sboard.dto.FileDTO;
import kr.co.sboard.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.StandardCharsets;

@Slf4j
@RequiredArgsConstructor
@Controller
public class FileController {

    private final FileService fileService;

    // 파일 다운로드
    @ResponseBody
    @GetMapping("/file/download")
    public ResponseEntity<Resource> download(int fno){
        log.info("fno = {}", fno);

        FileDTO fileDTO = fileService.getFile(fno); // fileDTO 안에 다운로드하는게 초기화 되어 있다?

        // 파일 서비스 먼저 가자.
        // 파일 다운로드 카운트 업데이트
        fileService.modifyDownloadCount(fileDTO);

        fileService.download(fileDTO); // 얕은 복사로 contentType과 resource 초기화 // 여기에서 다운로드 처리.
        log.info("fileDTO = {}", fileDTO);

        // 파일 다운로드 헤더 정보 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(
                ContentDisposition.builder("attachment")
                        .filename(fileDTO.getOname(), StandardCharsets.UTF_8).build());

        headers.add(HttpHeaders.CONTENT_TYPE, fileDTO.getContentType());

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(fileDTO.getResource()); // 리턴되는 값이 탬플릿이 아니지만, @ResponseBody로 출력하라는 어노테이션 덕분에 이 return 값이 탬플릿 취급으로 처리되어 진행된다.
    }
}
