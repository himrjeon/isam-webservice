package kr.seoulautogallery.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언한 모든 필드의 get 메소드를 생성해준다.
@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자를 생성해준다. / final 없으면 안됨.
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
