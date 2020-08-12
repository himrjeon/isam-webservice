package kr.seoulautogallery.web;

import kr.seoulautogallery.service.posts.NewsService;
import kr.seoulautogallery.service.posts.NoticeService;
import kr.seoulautogallery.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class NoticeApiController {

    private final NoticeService noticeService;

    @PostMapping("/api/v1/notice")
    public Long save(@RequestBody NoticeSaveRequestDto requestDto) {
        return noticeService.save(requestDto);
    }

    @PutMapping("/api/v1/notice/{id}")
    public Long update(@PathVariable Long id, @RequestBody NoticeUpdateRequestDto requestDto) {
        return noticeService.update(id, requestDto);
    }

    @GetMapping("/api/v1/notice/{id}")
    public NoticeResponseDto findById (@PathVariable Long id) {
        return noticeService.findById(id);
    }

    @DeleteMapping("/api/v1/notice/{id}")
    public Long delete(@PathVariable Long id) {
        noticeService.delete(id);
        return id;
    }
}