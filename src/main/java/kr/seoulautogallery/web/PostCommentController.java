package kr.seoulautogallery.web;

import kr.seoulautogallery.domain.Posts;
import kr.seoulautogallery.domain.PostsRepository;
import kr.seoulautogallery.service.posts.NoticeService;
import kr.seoulautogallery.service.posts.PostCommentService;
import kr.seoulautogallery.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostCommentController {

    private final PostCommentService postCommentService;
    private final PostsRepository postsRepository;

    @PostMapping("/api/v1/postcomment/{id}")
    public Long save(@PathVariable Long id, @RequestBody PostCommentSaveRequestDto requestDto) {
        Optional<Posts> postItem = postsRepository.findById(id);
        requestDto.setPost(postItem.get());
        return postCommentService.save(requestDto);
    }

    @PutMapping("/api/v1/postcomment/{id}/{commentid}")
    public Long update(@PathVariable Long id, @RequestBody PostCommentUpdateRequestDto requestDto) {
        return postCommentService.update(id, requestDto);
    }

    @GetMapping("/api/v1/postcomment/{id}")
    public PostCommentResponseDto findById (@PathVariable Long id) {
        return postCommentService.findById(id);
    }

    @DeleteMapping("/api/v1/postcomment/{id}")
    public Long delete(@PathVariable Long id) {
        postCommentService.delete(id);
        return id;
    }
}
