package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @RequestMapping("/students")
    public String insert(@RequestBody Student student) {
        String sql = "INSERT INTO student(id, name) VALUES (:studentId, :studentName)";
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", student.getId());
        map.put("studentName", student.getName());
        namedParameterJdbcTemplate.update(sql, map);
        return "insert success";
    }
}
