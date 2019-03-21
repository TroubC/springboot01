package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * 关于事务使用 @Transactional
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRespository girlRespository;

    /**
     * 查询所有
     */

    @GetMapping(value="/girls")
    public List<Girl> girlList(){
        return girlRespository.findAll();
    }

    /**
     * 保存方法
     * @return
     */
    @PostMapping
    public Girl saveGirl(@RequestParam("age") Integer age,@RequestParam("cupSize") String cupSize){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return  girlRespository.save(girl);
    }

    /**
     * 根据id查询
     */
    @GetMapping(value="/girls/{id}")
    public Optional<Girl> findGirl(@PathVariable("id") Integer id){
       return girlRespository.findById(id);
    }

    /**
     * 更新方法
     */
    @PutMapping(value="/girls/{id}")
    public void updateGirl(@PathVariable("id") Integer id, @RequestParam("age") Integer age, @RequestParam("cupSize") String cupSize){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girlRespository.save(girl);
    }

    /**
     * 删除方法
     */
    @DeleteMapping(value="/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){
        girlRespository.deleteById(id);
        System.out.println("删除成功");
    }

    /**
     * 根据年龄来查
     */
    @GetMapping(value="/girls/age/{age}")
    public List<Girl> girllists(@PathVariable("age") Integer age){
        return girlRespository.findByAge(age);
    }
}
