package kz.bitlab.spring_task.springtask1.controllers;

import kz.bitlab.spring_task.springtask1.db.DBManager;
import kz.bitlab.spring_task.springtask1.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {


    @GetMapping("/")
    public String homepage(Model model) {
        model.addAttribute("items", DBManager.getItems());
        return "home";
    }

    @GetMapping("/add_Student")
    public String addStudentpage() {
        return "add_Student";
    }

    @PostMapping("/add_Student")
    public String addStudent(Item item) {
        DBManager.addItem(item);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String detailspage(@PathVariable Long id, Model model) {
        System.out.printf(String.valueOf(id));
        Item item = DBManager.getItemById(id);
        model.addAttribute("detailsItem", item);
        return "details";
    }

    @PostMapping("edit-item/{id}")
    public String editItem(@PathVariable Long id,
                           @RequestParam(name = "edit_student_name") String name,
                           @RequestParam(name = "edit_student_surname") String surname,
                           @RequestParam(name = "edit_student_exam") int exam) {
        Item item = DBManager.getItemById(id);
        item.setName(name);
        item.setSurname(surname);
        item.setExam(exam);
        return "redirect:/details/" + id;
    }

    @PostMapping("delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        DBManager.DeleteItem(id);
        return "redirect:/";
    }
}
