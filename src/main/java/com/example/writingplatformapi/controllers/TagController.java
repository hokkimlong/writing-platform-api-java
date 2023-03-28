package com.example.writingplatformapi.controllers;

import com.example.writingplatformapi.models.PopularTag;
import com.example.writingplatformapi.models.Tag;
import com.example.writingplatformapi.models.TagRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/Tags")
public class TagController {
    private final TagRepository tagRepository;

    public TagController(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @RequestMapping(value = "")
    public Iterable<Tag> find(@RequestParam(required = false) String search) {
        return tagRepository.findAllByNameContainingIgnoreCase(search);
    }

    @RequestMapping(value = "/popular")
    public Iterable<PopularTag> find() {
        return tagRepository.findPopular();
    }


    @RequestMapping(value = "/{id}")
    public Optional<Tag> findByTagId(@PathVariable int id) {
        return tagRepository.findById(id);
    }


}
