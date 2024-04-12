package com.exam.EmpSystem.service;

import com.exam.EmpSystem.entity.Employee;
import com.exam.EmpSystem.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepo repo;

    public void addEmp(Employee e){

        repo.save(e);

    }

    public List<Employee> getAllEmp(){

        return repo.findAll();
    }

    public Employee getEMpById(int id)
    {

        Optional<Employee> e=repo.findById(id);
        if(e.isPresent())
        {
            return e.get();
        }
        return null;
    }

    public void deleteEMp(int id)
    {
        repo.deleteById(id);
    }

}
