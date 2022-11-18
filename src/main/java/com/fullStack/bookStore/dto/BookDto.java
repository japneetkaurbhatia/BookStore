package com.fullStack.bookStore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //-> create getter and setter
@Builder //-> create builder design pattern
@AllArgsConstructor //-> create all constructor
@NoArgsConstructor //-> create default constructor
// cmd + , -> open preferences
public class BookDto {
    private String title;
}
