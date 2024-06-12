package dw.movieDic.Repository;

import dw.movieDic.Model.Board;
import dw.movieDic.Model.Post;
import dw.movieDic.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
