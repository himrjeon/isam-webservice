package kr.seoulautogallery.service.posts;

import kr.seoulautogallery.domain.PostComment;
import kr.seoulautogallery.domain.Posts;
import kr.seoulautogallery.domain.PostCommentRepository;
import kr.seoulautogallery.domain.PostsRepository;
import kr.seoulautogallery.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostCommentService {
    private final PostCommentRepository postCommentRepository;
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostCommentSaveRequestDto requestDto) {
        return postCommentRepository.save(requestDto.toEntity()).getCommentid();

    }

    @Transactional
    public Long update(Long id, PostCommentUpdateRequestDto requestDto) {
        PostComment postComment = postCommentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        postComment.update(requestDto.getMemo());

        return id;
    }

    public PostCommentResponseDto findById(Long id) {
        PostComment entity = postCommentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        return new PostCommentResponseDto(entity);
    }

    @Transactional
    public List<PostCommentListResponseDto> findALLByPost(Posts posts) {
        return postCommentRepository.findALLByPost(posts).stream()
                .map(PostCommentListResponseDto::new) // .map(posts -> new PostsListResponseDto(posts))
                // 결과로 넘어온 posts의 스트림을 map을 통해 listdto로 변환하고 list로 변환하는 메소드.
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostCommentListResponseDto> findAllDesc() {
        return postCommentRepository.findAllDesc().stream()
                .map(PostCommentListResponseDto::new) // .map(posts -> new PostsListResponseDto(posts))
                // 결과로 넘어온 posts의 스트림을 map을 통해 listdto로 변환하고 list로 변환하는 메소드.
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        PostComment postComment = postCommentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postCommentRepository.delete(postComment);
        // JpaRepository에서 이미 delete 메소드 지원하니 활용, id로 삭제할 수도 있고 파라미터로 삭제할 수도 있음. 존재하는 posts인지 엔티티 조회후 그대로 삭제한다.
    }
}
