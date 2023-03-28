package com.example.writingplatformapi.models;

import java.util.Set;

public class CreateArticleDto {
    public String title;
    public String content;
    public Set<Tag> tags;
    public Set<String> newTags;

}
