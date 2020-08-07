package kr.seoulautogallery.web;

import kr.seoulautogallery.service.posts.NewsService;

import kr.seoulautogallery.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class NewsApiController {

    private final NewsService newsService;

    @PostMapping("/api/v1/news")
    public Long save(@RequestBody NewsSaveRequestDto requestDto) {
        return newsService.save(requestDto);
    }

    @PutMapping("/api/v1/news/{id}")
    public Long update(@PathVariable Long id, @RequestBody NewsUpdateRequestDto requestDto) {
        return newsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/news/{id}")
    public NewsResponseDto findById (@PathVariable Long id) {
        return newsService.findById(id);
    }

    @DeleteMapping("/api/v1/news/{id}")
    public Long delete(@PathVariable Long id) {
        newsService.delete(id);
        return id;
    }
}
