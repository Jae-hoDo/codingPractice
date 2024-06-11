package dw.movieDic.Dto;

import dw.movieDic.Model.User;
import lombok.*;

@NoArgsConstructor
public class PostDto {
    private String postTitle;
    private String postContent;
//    private Long boardId;
    private User user;




}
