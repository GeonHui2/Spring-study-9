package com.blog.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostSearch {

    @Builder.Default
    private Integer page = 1 ;

    @Builder.Default
    private Integer size = 10;


}
