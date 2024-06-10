package dw.movieDic.service;

import dw.movieDic.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PostService {
    private PostRepository postRepository;
}
