package com.example.lambda.controller;

import com.example.lambda.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CrudController {

    @GetMapping("/getData")
    public List<ResponseEntity> getData(){
        return null;
    }
    @PostMapping("/createData")
    public ResponseEntity<String> createData(@RequestBody Employee employee)
    {
        return null;
    }
    @PutMapping("/updateData")
    public ResponseEntity<String> updateData(@RequestBody Employee employee)
    {
        return null;
    }
    @DeleteMapping("/deleteData")
    public ResponseEntity<String> deleteData(@RequestParam String empId)
    {
        return null;
    }

}
