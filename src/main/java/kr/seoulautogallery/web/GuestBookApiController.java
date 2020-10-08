package kr.seoulautogallery.web;

import kr.seoulautogallery.service.posts.GuestBookService;
import kr.seoulautogallery.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class GuestBookApiController {

    private final GuestBookService guestBookService;

    @PostMapping("/api/v2/guestbook")
    public Long save(@RequestBody GuestBookSaveRequestDto requestDto) {
        return guestBookService.save(requestDto);
    }

    @PutMapping("/api/v2/guestbook/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody GuestBookUpdateRequestDto requestDto) {
        return guestBookService.update(id, requestDto);
    }

    @GetMapping("/api/v2/guestbook/{id}")
    public GuestBookResponseDto findById (@PathVariable Long id) {
        return guestBookService.findById(id);
    }

    @DeleteMapping("/api/v2/guestbook/delete/{id}")
    public Long delete(@PathVariable Long id) {
        guestBookService.delete(id);
        return id;
    }

}
