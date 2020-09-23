package kr.seoulautogallery.service.posts;

import kr.seoulautogallery.domain.CarGuestBook;
import kr.seoulautogallery.domain.CarGuestBookRepository;
import kr.seoulautogallery.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarGuestBookService {
    private final CarGuestBookRepository carGuestBookRepository;

    @Transactional
    public Long save(CarGuestBookSaveRequestDto requestDto) {
        return carGuestBookRepository.save(requestDto.toEntity()).getId();

    }

    @Transactional
    public Long update(Long id, CarGuestBookUpdateRequestDto requestDto) {
        CarGuestBook carguestbook = carGuestBookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        carguestbook.update(requestDto.getContent());

        return id;
    }

    public CarGuestBookResponseDto findById(Long id) {
        CarGuestBook entity = carGuestBookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new CarGuestBookResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<CarGuestBookListResponseDto> findAllDesc() {
        return carGuestBookRepository.findAllDesc().stream()
                .map(CarGuestBookListResponseDto::new) // .map(posts -> new PostsListResponseDto(posts))
                // 결과로 넘어온 posts의 스트림을 map을 통해 listdto로 변환하고 list로 변환하는 메소드.
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        CarGuestBook guestBook = carGuestBookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        carGuestBookRepository.delete(guestBook);
        // JpaRepository에서 이미 delete 메소드 지원하니 활용, id로 삭제할 수도 있고 파라미터로 삭제할 수도 있음. 존재하는 posts인지 엔티티 조회후 그대로 삭제한다.
    }
}
