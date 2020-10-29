package kr.seoulautogallery.service.posts;

import kr.seoulautogallery.domain.News;
import kr.seoulautogallery.domain.NewsRepository;
import kr.seoulautogallery.domain.ShowRoom;
import kr.seoulautogallery.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NewsService {

    private final NewsRepository newsRepository;

    @Transactional
    public Long save(NewsSaveRequestDto requestDto) {
        return newsRepository.save(requestDto.toEntity()).getId();

    }

    @Transactional
    public Long update(Long id, NewsUpdateRequestDto requestDto) {
        News news = newsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        news.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public NewsResponseDto findById(Long id) {
        News entity = newsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        return new NewsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<NewsListResponseDto> findAllDesc() {
        return newsRepository.findAllDesc().stream()
                .map(NewsListResponseDto::new) // .map(posts -> new PostsListResponseDto(posts))
                // 결과로 넘어온 posts의 스트림을 map을 통해 listdto로 변환하고 list로 변환하는 메소드.
                .collect(Collectors.toList());
    }

    @Transactional
    public List<NewsListResponseDto> getBoardList(Pageable pageable) {
        return newsRepository.findAll(pageable).stream()
                .map(NewsListResponseDto::new) // .map(posts -> new PostsListResponseDto(posts))
                // 결과로 넘어온 posts의 스트림을 map을 통해 listdto로 변환하고 list로 변환하는 메소드.
                .collect(Collectors.toList());

    }

    @Transactional
    public void delete (Long id) {
        News news = newsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        newsRepository.delete(news);
        // JpaRepository에서 이미 delete 메소드 지원하니 활용, id로 삭제할 수도 있고 파라미터로 삭제할 수도 있음. 존재하는 posts인지 엔티티 조회후 그대로 삭제한다.
    }
}
