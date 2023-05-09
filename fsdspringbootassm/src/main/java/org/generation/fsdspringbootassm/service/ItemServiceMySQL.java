package org.generation.fsdspringbootassm.service;

import org.generation.fsdspringbootassm.repository.entity.Todolistdata;
import org.generation.fsdspringbootassm.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ItemServiceMySQL implements ItemService {

    //This ItemServiceMySQL class object has to depend on another class object to perform
    // actions (e.g. save, delete, all, findItemById)
    //dependent object class is the CRUDRepository class that is provided by Spring boot
    //to perform dependency injection -> access the CRUDRepository class method through the
    // ItemRepository interface that we have created that extend CrudRepository interface

    private final ItemRepository itemRepository;

    //Dependency Injection of another class object to this class object can be done with
    // @Autowired annotation

    public ItemServiceMySQL(@Autowired ItemRepository itemRepository)
    {
        this.itemRepository = itemRepository;
    }



    @Override
    public Todolistdata save(Todolistdata item)
    {
        //1st method : @Query - Query class provided by Spring Boot : SELECT * from itemslist
        //2nd method : Repository class provided by Springboot : we do not need to write a single query
        //Since we have done the dependency injection of the itemRepository, therefore now we can call any methods from the CRUDRepository class
        return this.itemRepository.save(item);

    }

    @Override
    public void delete(int itemId)
    {
        this.itemRepository.deleteById(itemId);
    }

    @Override
    public ArrayList<Todolistdata> all()
    {
        ArrayList<Todolistdata> result = new ArrayList<>();
        this.itemRepository.findAll().forEach(result::add);
        return result;

    }

    @Override
    public Todolistdata findById(int itemId)
    {
        //Optional is list that accept either a null (empty), or with item
        Optional<Todolistdata> item = itemRepository.findById(itemId);
        Todolistdata itemResponse = item.get();
        return itemResponse;

    }



}
