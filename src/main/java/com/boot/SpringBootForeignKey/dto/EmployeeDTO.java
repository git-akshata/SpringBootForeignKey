package com.boot.SpringBootForeignKey.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class EmployeeDTO {

    @Id
    private long empId;

    private String empCode;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String empDOB;

    private String empName;

    private String empGender;

    private String empMobileNo;

    private  long Department;



}
