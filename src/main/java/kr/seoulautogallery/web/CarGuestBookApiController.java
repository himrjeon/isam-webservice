package kr.seoulautogallery.web;

import kr.seoulautogallery.service.posts.CarGuestBookService;
import kr.seoulautogallery.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CarGuestBookApiController {
    private final CarGuestBookService carGuestBookService;

    @PostMapping("/api/v2/carguestbook")
    public Long save(@RequestBody CarGuestBookSaveRequestDto requestDto) {
        return carGuestBookService.save(requestDto);
    }

    @PutMapping("/api/v2/carguestbook/{id}")
    public Long update(@PathVariable Long id, @RequestBody CarGuestBookUpdateRequestDto requestDto) {
        return carGuestBookService.update(id, requestDto);
    }

    @GetMapping("/api/v2/carguestbook/{id}")
    public CarGuestBookResponseDto findById (@PathVariable Long id) {
        return carGuestBookService.findById(id);
    }

    @DeleteMapping("/api/v2/carguestbook/delete/{id}")
    public Long delete(@PathVariable Long id) {
        carGuestBookService.delete(id);
        return id;
    }
}
