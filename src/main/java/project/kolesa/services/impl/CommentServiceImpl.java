package project.kolesa.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.kolesa.dto.CommentDto;
import project.kolesa.model.Ad;
import project.kolesa.model.Comments;
import project.kolesa.model.User;
import project.kolesa.repository.CommentRepository;
import project.kolesa.services.AdService;
import project.kolesa.services.CommentService;
import project.kolesa.services.UserService;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private AdService adService;

    @Autowired
    private UserService userService;

    @Override
    public Comments addComment(CommentDto commentDto, Long id) {
        Comments checkComment = new Comments();
        checkComment.setComment(commentDto.getComment());
        checkComment.setAd(adService.getAd(id));
        checkComment.setUser(userService.getCurrentUser());
        return commentRepository.save(checkComment);
    }

    @Override
    public List<Comments> getComments() {
        return commentRepository.findAll();
    }

    public List<Comments> getByAd(Ad ad) {
        return commentRepository.findByAd(ad);
    }

    @Override
    public Comments getCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteComment(Comments comment) {
        User user = userService.getCurrentUser();
        if (Objects.equals(comment.getUser().getId(), user.getId())) {
            comment.setDeleted(true);
            commentRepository.save(comment);
        }
    }
}
