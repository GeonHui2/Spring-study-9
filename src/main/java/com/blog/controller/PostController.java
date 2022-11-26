package com.blog.controller;

import com.blog.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class PostController {

    @PostMapping("/posts")
    public Map<String, String> post(@RequestBody @Valid PostCreate params, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            FieldError firstFieldError = fieldErrors.get(0);
            String fieldName = firstFieldError.getField(); // title
            String errorMessage = firstFieldError.getDefaultMessage(); // ..에러 메시지

            Map<String, String> error = new HashMap<>();
            error.put(fieldName, errorMessage);
            return error;
        }

        return Map.of();
    }


}

// 데이터를 검증하는 이유

// 1. client 개발자가 깜발할 수 있다. 실수로 값을 안 보낼 수 있다.
// 2. cloent bug로 값이 누락될 수 있다.
// 3. 외부에 나쁜 사람이 값을 임의로 조작해서 보낼 수 있다.
// 4. DB에 값을 저장할 때 의도치 않은 오류가 발생할 수 있다.
// 5. 서버 개발자의 편안함을 위해서

// 반복 검증 안 좋은 이유

// 1. 어렵다. (반복 작업)
// 2. 개발 팁 -> 무언가 3번 이상 반복 작업을 할 때 내가 뭔가 잘못하고 있는건 아닌지 의심해본다.
// 3. 누락 가능성
// 4. 생각보다 검증해야할게 많다. (꼼꼼하지 않을 수 있다.)
// 5. 뭔가 개발자스럽지 않다.
