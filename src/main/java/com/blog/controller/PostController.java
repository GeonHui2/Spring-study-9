package com.blog.controller;

import com.blog.request.PostCreate;
import com.blog.request.PostEdit;
import com.blog.request.PostSearch;
import com.blog.response.PostResponse;
import com.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public void post(@RequestBody @Valid PostCreate request) {
        request.validate();
        postService.wirte(request);
    }

    @GetMapping("/posts/{postId}")
    public PostResponse get(@PathVariable(name = "postId") Long postId) {
        return postService.get(postId);
    }

    @GetMapping("/posts")
    public List<PostResponse> getList(@ModelAttribute PostSearch postSearch) {
        return postService.getList(postSearch);
    }

    @PatchMapping("/posts/{postId}")
    public void edit(@PathVariable Long postId, @RequestBody @Valid PostEdit request) {
        postService.edit(postId, request);
    }

    @DeleteMapping("posts/{postId}")
    public void delete(@PathVariable Long postId) {
        postService.delete(postId);
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
