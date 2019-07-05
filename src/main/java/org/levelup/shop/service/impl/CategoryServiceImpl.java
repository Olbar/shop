package org.levelup.shop.service.impl;

import org.levelup.shop.domain.dto.Category;
import org.levelup.shop.domain.entity.CategoryEntity;
import org.levelup.shop.exception.ShopException;
import org.levelup.shop.repository.CategoryRepository;
import org.levelup.shop.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CategoryServiceImpl extends AbstractService implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(ModelMapper modelMapper, CategoryRepository categoryRepository) {
        super( modelMapper );
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Collection<Category> findAll() {
        Iterable<CategoryEntity> values = categoryRepository.findAll();
        return findAllEntities( values, Category.class );
    }

    @Override
    public Category findById(Integer categoryId) {
        return categoryRepository.findById( categoryId ) // Optional<CategoryEntity>
                .map( entity -> modelMapper.map( entity, Category.class ) )
                .orElseThrow( ShopException::new );
    }
}
