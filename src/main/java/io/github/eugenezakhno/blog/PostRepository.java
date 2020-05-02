package io.github.eugenezakhno.blog;

import io.github.eugenezakhno.blog.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {

}
