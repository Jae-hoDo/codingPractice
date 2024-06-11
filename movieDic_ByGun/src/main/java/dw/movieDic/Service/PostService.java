package dw.movieDic.Service;

import dw.movieDic.Repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Service
@Transactional
public class PostService {
    @Autowired
    private PostRepository postRepository;
    public
}
