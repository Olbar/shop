package org.levelup.shop.service.impl;


import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class AbstractService {

    protected ModelMapper modelMapper;

    protected AbstractService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    protected <DTO, ENTITY> Collection<DTO> findAllEntities(Iterable<ENTITY> values, Class<DTO> classOfT) {
        return StreamSupport.stream( values.spliterator(), false )
                .map( entity -> modelMapper.map( entity, classOfT ) )
                .collect( Collectors.toList() );
    }
}
