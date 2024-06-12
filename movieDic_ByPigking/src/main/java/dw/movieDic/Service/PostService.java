package dw.movieDic.Service;

import dw.movieDic.Dto.PostDto;
import dw.movieDic.Dto.SurveyDto;
import dw.movieDic.Model.Post;
import dw.movieDic.Model.Survey;
import dw.movieDic.Repository.BoardRepository;
import dw.movieDic.Repository.PostRepository;
import dw.movieDic.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;

    public PostDto savePost(Post post) {
        Post savePost = postRepository.save(post);
        PostDto postDto = new PostDto();

        return postDto.toPostDtoFromPost(savePost);
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }
}
