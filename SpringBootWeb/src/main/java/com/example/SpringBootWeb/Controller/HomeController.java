package com.example.SpringBootWeb.Controller;

import com.example.SpringBootWeb.model.Person;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @ModelAttribute("author")
    public String author() {
        return "Dhruvik";
    }


    @RequestMapping("/")
    public String home() {
//        System.out.println("home");
//        return "index";

        return "person";
    }

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int a, @RequestParam("num2") int b, ModelAndView mv) {
//        Model model
//        int a,int b
//        HttpServletRequest req, HttpSession session


//        int a=Integer.parseInt(req.getParameter("num1"));
//        int b=Integer.parseInt(req.getParameter("num2"));
           int c=a+b;
           System.out.println(c);
//         session.setAttribute("result", c);

//          model.addAttribute("result", c);

            mv.addObject("result", c);
            mv.setViewName("result");

        return mv;
    }

//    @RequestMapping("addPerson")
//    public ModelAndView addPerson(@RequestParam("pid") int id, @RequestParam("pname") String name,ModelAndView mv) {
//        Person p=new Person();
//        p.setPid(id);
//        p.setPname(name);
//        mv.addObject("person", p);
//        mv.setViewName("result");
//        return mv;
//    }

    @RequestMapping("addPerson")
    public String addPerson(@ModelAttribute Person person) {
        //Person person
//        @ModelAttribute("person1") Person person
        return "result";
    }
}
