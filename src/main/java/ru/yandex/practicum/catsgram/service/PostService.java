package ru.yandex.practicum.catsgram.service;

import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.dao.PostDao;
import ru.yandex.practicum.catsgram.exception.UserNotFoundException;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.model.User;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostDao postDao;
    private final UserService userService;

    public PostService(PostDao postDao, UserService userService) {
        this.postDao = postDao;
        this.userService = userService;
    }

    public Collection<Post> findPostsByUserId(String userId) throws UserNotFoundException {
        User user = userService.findUserById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found."));

        return postDao.findPostsByUser(user);
    }

    public Collection<Post> findPostsByUserId(String authorId, Integer size, String sort) throws UserNotFoundException {
        return findPostsByUserId(authorId)
                .stream()
                .sorted((p0, p1) -> {
                    int comp = p0.getCreationDate().compareTo(p1.getCreationDate());
                    if (sort.equals("desc")) {
                        comp = -1 * comp;
                    }
                    return comp;
                })
                .limit(size)
                .collect(Collectors.toList());
    }
}
