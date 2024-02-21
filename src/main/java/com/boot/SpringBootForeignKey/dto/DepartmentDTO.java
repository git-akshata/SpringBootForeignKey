package com.boot.SpringBootForeignKey.dto;

import com.boot.SpringBootForeignKey.entity.Department;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartmentDTO   {

    @Id
    private long deptId;

    private String deptName;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean isActive;
}
