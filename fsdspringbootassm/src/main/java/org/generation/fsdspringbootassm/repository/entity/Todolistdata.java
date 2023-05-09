package org.generation.fsdspringbootassm.repository.entity;

//Repository package is part of the Model Component (MVC)
//Customer is the entity class to use to map against the table from the database

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import org.generation.fsdspringbootassm.controller.dto.ItemDTO;



@Entity
public class Todolistdata {

    //Properties/attributes - will be mapped to the columns of the database table
    //Need to use the Wrapper class on primitive data types - need to pass the datatype
    // as an object to CRUDRepository Class (provided by SpringBoot framework)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  //retrieve product item by ID - has to be an object

    private String title;
    private String description;
    private String targetDate;

    //Customer Class is used to map with the Database table
    //And CRUD operation, JPA will make use of this Customer Class to map
    //For the Read or delete Operation, the JPA requires a empty constructor to
    //populate all the records from the database to the Customer instances

    //Contructor overloading
    public Todolistdata() {  }

    // DTO - Data Transfer Object at the Controller
    // Create and Update operation, JPA requires the ItemDTO object to be sent via the controller
    public Todolistdata(ItemDTO itemDTO)
    {
        //Transfer the object (with the data) to Entity Class for mapping with the
        // database table columns and to be able to save the data in the columns
        this.title = itemDTO.getTitle();
        this.description = itemDTO.getDescription();
        this.targetDate = itemDTO.getTargetDate();
    }


    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }
    public String getTargetDate()
    {
        return targetDate;
    }

    public void setTargetDate( String targetDate )
    {
        this.targetDate = targetDate;
    }



    @Override
    public String toString()
    {
        return "Item{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + ", Target Date ='" + targetDate +  '}';
    }


}

