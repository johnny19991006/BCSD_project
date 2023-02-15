package org.example.repository;

import org.example.domain.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMapper {
    Category getCategoryById(Long CategoryId);

    void create(Category category);

    void update(Category category);

    void delete(Long CategoryId);
}
