package org.levelup.shop.service;


import org.levelup.shop.domain.dto.Category;

import java.util.Collection;

public interface CategoryService {

    Collection<Category> findAll();

    Category findById(Integer categoryId);
}
