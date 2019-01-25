package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostController {

    private PostService postService;
    private PostRepository postRepository;

    @Autowired
    public PostController(
            PostService postService,
            PostRepository postRepository
    ) {
        this.postService = postService;
        this.postRepository = postRepository;

    }

    @GetMapping("/api/posts")
    @CrossOrigin("http://localhost:4200/")
    public List<Post> getAllPosts() {
        return postService.getAll();
    }

    @GetMapping("/api/posts/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Post get(@PathVariable int id) {
        return postService.get(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/api/posts")
    public ResponseEntity<Void> createPost(@RequestBody Post post) {
        Post postUpdated = this.postRepository.save(post);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()

                .path("/{id").buildAndExpand(postUpdated.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
