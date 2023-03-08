package com.dapo.data.mapper

abstract class DataModelMapper<E, D> {

    abstract fun mapFromEntity(entity: E): D

    abstract fun mapToEntity(model: D): E

    fun mapFromEntityList(entityList: List<E>): List<D> {
        val models = mutableListOf<D>()
        entityList.forEach {
            models.add(mapFromEntity(it))
        }

        return models
    }


    fun mapFromModelList(models: List<D>): List<E> {
        val entityList = mutableListOf<E>()
        models.forEach {
            entityList.add(mapToEntity(it))
        }

        return entityList
    }
}