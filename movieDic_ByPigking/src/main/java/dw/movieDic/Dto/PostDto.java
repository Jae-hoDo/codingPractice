package dw.movieDic.Dto;

import dw.movieDic.Model.Post;
import dw.movieDic.Model.Survey;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDto {
    private long postId;
    private long boardId;
    private String userId;
    private String postTitle;
    private String postContent;

    public PostDto toPostDtoFromPost(Post post) {
        PostDto postDto = new PostDto();
        postDto.setPostId(getPostId());
        postDto.setBoardId(getBoardId());
        postDto.setUserId(getUserId());
        postDto.setPostTitle(getPostTitle());
        postDto.setPostContent(getPostContent());
        return postDto;
    }
}
