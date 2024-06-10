package dw.movieDic.service;

import dw.movieDic.dto.PostDto;
import dw.movieDic.model.Post;
import dw.movieDic.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Service
@Transactional
public class PostService {
    private PostRepository postRepository;

    public String savePost(PostDto postDto) {
        Optional<Post> postOptional = postRepository
    }
}
