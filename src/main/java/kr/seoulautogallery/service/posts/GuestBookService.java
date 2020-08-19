package kr.seoulautogallery.service.posts;

import kr.seoulautogallery.domain.GuestBook;
import kr.seoulautogallery.domain.GuestBookRepository;
import kr.seoulautogallery.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GuestBookService {
    private final GuestBookRepository guestBookRepository;

    @Transactional
    public Long save(GuestBookSaveRequestDto requestDto) {
        return guestBookRepository.save(requestDto.toEntity()).getId();

    }

    @Transactional
    public Long update(Long id, GuestBookUpdateRequestDto requestDto) {
        GuestBook guestbook = guestBookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        guestbook.update(requestDto.getContent());

        return id;
    }

    public GuestBookResponseDto findById(Long id) {
        GuestBook entity = guestBookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new GuestBookResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<GuestBookListResponseDto> findAllDesc() {
        return guestBookRepository.findAllDesc().stream()
                .map(GuestBookListResponseDto::new) // .map(posts -> new PostsListResponseDto(posts))
                // 결과로 넘어온 posts의 스트림을 map을 통해 listdto로 변환하고 list로 변환하는 메소드.
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        GuestBook guestBook = guestBookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        guestBookRepository.delete(guestBook);
        // JpaRepository에서 이미 delete 메소드 지원하니 활용, id로 삭제할 수도 있고 파라미터로 삭제할 수도 있음. 존재하는 posts인지 엔티티 조회후 그대로 삭제한다.
    }
}