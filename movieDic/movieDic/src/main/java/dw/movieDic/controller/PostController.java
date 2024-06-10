package dw.movieDic.controller;

import dw.movieDic.service.PostService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/post")
public class PostController {
    private PostService postService;

}
