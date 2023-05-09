package org.generation.fsdspringbootassm.controller.dto;

import java.util.Date;

//ItemDTO Class object is used for adding and updating of item services
// Do not need the ID as it is auto-increment
public class ItemDTO {

    private String title;
    private String description;

    private String targetDate;

    public ItemDTO(String title, String description, String targetDate )
    {
        this.title = title;
        this.description = description;
        this.targetDate = targetDate;
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

    public void setTargetDate(String targetDate) { this.targetDate = targetDate; }

    public String getTargetDate()
    {
        return targetDate;
    }


}
