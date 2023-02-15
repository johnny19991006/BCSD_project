package org.example.service;

import org.example.domain.Category;


public interface CategoryService {
    Category getCategoryInfo(long CategoryId);

    void createCategory(Category category);

    void updateCategory(long CategoryId, Category category);

    void deleteCategory(long CategoryId);
}

