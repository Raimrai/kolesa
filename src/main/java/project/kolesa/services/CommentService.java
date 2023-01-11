package project.kolesa.services;

import project.kolesa.dto.CommentDto;
import project.kolesa.model.Ad;
import project.kolesa.model.Comments;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Comments addComment(CommentDto commentDto, Long id);
    List <Comments> getComments();
    void deleteComment(Comments comments);
    List<Comments> getByAd(Ad ad);

    Comments getCommentById(Long id);
}
