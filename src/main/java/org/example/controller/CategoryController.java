package org.example.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.example.domain.Category;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @ApiOperation(value = "카테고리 만들기", notes = "카테고리를 만듭니다")
    @PostMapping()
    public ResponseEntity createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("create Category", HttpStatus.OK);
    }

    @ApiOperation(value = "카테고리 조회", notes = "카테고리를 조회합니다")
    @RequestMapping(value = "/{CategoryId}", method = RequestMethod.GET)
    public Category CategoryInfo(@ApiParam(name = "id", value = "(required:id)", required = true) @PathVariable("CategoryId") Long CategoryId) {
        return categoryService.getCategoryInfo(CategoryId);
    }


    @ApiOperation(value = "카테고리 수정", notes = "카테고기를 수정합니다")
    @PutMapping("/{CategoryId}")
    public ResponseEntity updateCategory(@ApiParam(name = "id", value = "(required:id)", required = true) @PathVariable Long CategoryId, @RequestBody Category category) {
        categoryService.updateCategory(CategoryId, category);
        return new ResponseEntity<>("update Category", HttpStatus.OK);
    }

    @ApiOperation(value = "카테고리 삭제", notes = "카테고리를 삭제합니다")
    @DeleteMapping("/{CategoryId}")
    public ResponseEntity deleteCategory(@ApiParam(name = "id", value = "(required:id)", required = true) @PathVariable Long CategoryId) {
        categoryService.deleteCategory(CategoryId);
        return new ResponseEntity<>("delete Category", HttpStatus.OK);
    }
}
