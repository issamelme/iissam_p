package com.exam.EmpSystem.controller;

import com.exam.EmpSystem.entity.Employee;
import com.exam.EmpSystem.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService service;

    @GetMapping("/")
    public String home(Model m){


        List<Employee> emp=service.getAllEmp();
        m.addAttribute("emp",emp);

        return "index";

    }

    @GetMapping("/addemp")
    public String addEmpForm(){

        return "add_emp";

    }

@PostMapping("/register")
    public String empRegister(@ModelAttribute Employee e, HttpSession session) {

        service.addEmp(e);
        session.setAttribute("msg","Employee Added Sucessfully...");

        System.out.println(e);
        return "redirect:/";

}

@GetMapping("/edit{id}")
public String edit(@PathVariable int id, Model m){


        Employee e=service.getEMpById(id);

        m.addAttribute("emp",e);
        return "edit";

}

@PostMapping(/update)
    public String updateEmp(@ModelAttribute Employee e,HttpSession session)
{

    service.addEmp(e);
    session.setAttribute("msg","Emp Data Updated Successfully..");
    return "redirect:/";

}

public String deleteEmp(@PathVariable int id, HttpSession session)
{

    service.deleteEMp(id);
    session.setAttribute("msg","Emp Data Deleted Successfully..");
    return "redirect:/";

}

}
