package com.errorpoint.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
   
    private Long id;
    private String title;
    private String description;
    private boolean status;
    
    public boolean getStatus() {
        return this.status;
    }
}
