package com.example.demo.jpa.controller;

import com.example.demo.jpa.domain.CrudEntity;
import com.example.demo.jpa.repository.CrudEntityRepository;
import com.example.demo.jpa.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class CrudController {

    private final CrudEntityRepository crudEntityRepository;

    @Autowired
    private CrudService crudService;

    @PersistenceContext
    private EntityManager entityManager;

    // 전체 조회
    @GetMapping("searchAll")
    public List<CrudEntity> searchAll() {
        return crudService.searchAll();
    }

    // age 파라미터를 사용한 조회
    @GetMapping("searchParam")
    public List<CrudEntity> searchParam(@RequestParam(value = "age") int age) {
        return crudService.searchParam(age);
    }

    // Repository에 작성한 쿼리를 이용한 조회
    @GetMapping("searchParamRepo")
    public List<CrudEntity> searchParamRepo(@RequestParam(value = "name") String name) {
        return crudService.searchParamRepo(name);
    }

    // 삽입
    @PostMapping("insert")
    public String insertMember(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age) {
        return crudService.insertMember(name, age);
    }

    // 수정
    @PutMapping("update")
    public String updateMember(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age) {
        return crudService.updateMember(name, age);
    }

    // 삭제
    @DeleteMapping("delete")
    public String deleteMember(@RequestParam(value = "name") String name) {
        return crudService.deleteMember(name);
    }

}
