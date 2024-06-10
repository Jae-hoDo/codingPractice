package dw.movieDic.repository;

import dw.movieDic.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,String> {
}
