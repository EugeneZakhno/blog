package io.github.eugenezakhno.blog.repositoires;

import io.github.eugenezakhno.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {



}
