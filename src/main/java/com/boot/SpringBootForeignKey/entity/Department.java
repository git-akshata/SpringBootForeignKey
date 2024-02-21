package com.boot.SpringBootForeignKey.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_Id",nullable = false, unique = true)
    private long deptId;

    @Column(name = "dept_Name")
    @NotNull
    private String deptName;

    //Default value is false
    @Column(name = "is_active", nullable = false)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean isActive=true;



}
