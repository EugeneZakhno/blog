package ru.intervale.mylibrary.repositoires;

import ru.intervale.mylibrary.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {

}
