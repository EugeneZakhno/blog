package ru.intervale.mylibrary.controllers;

import ru.intervale.mylibrary.models.Post;
import ru.intervale.mylibrary.repositoires.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class LibraryController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/library")
    public String libraryMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "library-main";
    }

    @GetMapping("/library/add")
    public String libraryAdd(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "library-add";
    }

    @PostMapping("/library/add")
    public String libraryPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String fullText, Model model){
        Post post = new Post(title,anons,fullText);
        postRepository.save(post);
        return "redirect:/library";
    }

    @GetMapping("/library/{id}")
    public String libraryDetails(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)){
            return "redirect:/library";
        }
       Optional <Post> post =  postRepository.findById(id);
       ArrayList <Post> res = new ArrayList<>();
       post.ifPresent(res::add);
       model.addAttribute("post", res);
       return "library-details";
    }
    @GetMapping("/library/{id}/edit")
    public String libraryEdit(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)){
            return "redirect:/library";
        }
        Optional <Post> post =  postRepository.findById(id);
        ArrayList <Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "library-edit";
    }

    @PostMapping("/library/{id}/edit")
    public String libraryPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String fullText, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFullText(fullText);
        postRepository.save(post);
        return "redirect:/library";
    }
    @PostMapping("/library/{id}/remove")
    public String libraryPostDelete(@PathVariable(value = "id") long id, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/library";
    }
}
