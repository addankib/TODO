package com.project.TODO.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="todo-table" )
public class TODO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String todo;

    @Column
    private String Description;

    @Column
    private boolean completed;

    public boolean getCompleted(){
        return this.completed;
    }

}
