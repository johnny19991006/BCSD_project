package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Category;
import org.example.repository.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;


    @Transactional
    public Category getCategoryInfo(long CategoryId) {
        return categoryMapper.getCategoryById(CategoryId);
    }

    @Transactional
    public void createCategory(Category category) {
        categoryMapper.create(category);
    }


    @Transactional
    public void updateCategory(long CategoryId, Category updateCategory) {

        Category categoryTest = categoryMapper.getCategoryById(CategoryId);

        if (categoryTest != null) {

            /*categoryTest = Category.builder()
                    .CategoryContent(updateCategory.getCategoryContent())
                    .RegisterDate(updateCategory.getRegisterDate())
                    .UpdateDate(updateCategory.getUpdateDate())
                    .DeleteDate(updateCategory.getDeleteDate())
                    .build();*/
            categoryTest.setCategoryContent(updateCategory.getCategoryContent());
            categoryTest.setRegisterDate(updateCategory.getRegisterDate());
            categoryTest.setUpdateDate(updateCategory.getUpdateDate());
            categoryTest.setDeleteDate(updateCategory.getDeleteDate());
            categoryMapper.update(categoryTest);
        } else {
            throw new IllegalStateException("회원이 존재하지 않습니다.");
        }

    }


    @Transactional
    public void deleteCategory(long CategoryId) {
        if (categoryMapper.getCategoryById(CategoryId) != null) {
            categoryMapper.delete(CategoryId);
        } else {
            throw new IllegalStateException("회원이 존재하지 않습니다");
        }
    }
}
