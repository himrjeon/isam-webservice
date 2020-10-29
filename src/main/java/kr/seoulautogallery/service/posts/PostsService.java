package kr.seoulautogallery.service.posts;

import kr.seoulautogallery.domain.Posts;
import kr.seoulautogallery.domain.PostsRepository;
import kr.seoulautogallery.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();

    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new) // .map(posts -> new PostsListResponseDto(posts))
                // 결과로 넘어온 posts의 스트림을 map을 통해 listdto로 변환하고 list로 변환하는 메소드.
                .collect(Collectors.toList());
    }

    @Transactional
    public List<PostsListResponseDto> getBoardList(Pageable pageable) {
        return postsRepository.findAll(pageable).stream()
                .map(PostsListResponseDto::new) // .map(posts -> new PostsListResponseDto(posts))
                // 결과로 넘어온 posts의 스트림을 map을 통해 listdto로 변환하고 list로 변환하는 메소드.
                .collect(Collectors.toList());

    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(posts);
        // JpaRepository에서 이미 delete 메소드 지원하니 활용, id로 삭제할 수도 있고 파라미터로 삭제할 수도 있음. 존재하는 posts인지 엔티티 조회후 그대로 삭제한다.
    }


}
