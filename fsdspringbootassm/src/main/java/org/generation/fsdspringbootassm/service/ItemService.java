package org.generation.fsdspringbootassm.service;

import org.generation.fsdspringbootassm.repository.entity.Todolistdata;
import java.util.ArrayList;

public interface ItemService {

    //save method is for 2 purposes - Create new item & Update existing item
    Todolistdata save(Todolistdata item);

    //Delete item from database - based on item Id
    void delete(int itemId);

    //Read all item from database
    ArrayList<Todolistdata> all();

    //Read an item from database - based on item Id
    Todolistdata findById(int itemId);

}
