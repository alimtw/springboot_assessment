package org.generation.fsdspringbootassm.controller;

import org.generation.fsdspringbootassm.service.ItemService;
import org.generation.fsdspringbootassm.repository.entity.Todolistdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Value;

import org.generation.fsdspringbootassm.controller.dto.ItemDTO;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//Request mapping is to provide a URL route for frontend to call the API endpoints
//We can have controller for /item, /user, /customer, /post

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    // Dependency Injection of the itemService objects as that the controller can call any methods in the ItemServiceMySQL Class

    public ItemController( @Autowired ItemService itemService )
    {
        this.itemService = itemService;
    }
    // 1st API endpoint - To be able to return all products to the front end
    // Frontend will issue a GET http request

    @CrossOrigin
    @GetMapping( "/all" )
    public Iterable<Todolistdata> getItems()
    {
        return itemService.all();
    }

    @CrossOrigin
    @GetMapping( "/{id}" )
    public Todolistdata findItemById( @PathVariable Integer id )
    {
        return itemService.findById( id );
    }

    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }

    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="title", required = true) String title,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="targetDate", required = true) String targetDate) throws IOException

    {

        ItemDTO itemDto = new ItemDTO(title, description, targetDate);
        itemService.save(new Todolistdata(itemDto));
    }
    /*LocalDate date = LocalDate.now();
    String text = date.format(formatter);
    private DateTimeFormatter formatter;
    LocalDate parsedDate = LocalDate.parse(text, formatter);*/

} //Loop End ItemController
