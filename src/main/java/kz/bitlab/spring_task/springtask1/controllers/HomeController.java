package kz.bitlab.spring_task.springtask1.controllers;

import kz.bitlab.spring_task.springtask1.Services.ItemServices;
import kz.bitlab.spring_task.springtask1.models.Item;
import kz.bitlab.spring_task.springtask1.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private ItemServices itemServices;
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/")
    public String homepage(Model model) {
        model.addAttribute("items", itemServices.getitems());
        return "home";
    }

    @GetMapping("/search")
    public String searchPage(@RequestParam(name = "search") String search ,Model model) {
        System.out.println(search);
        model.addAttribute("items",itemRepository.search(search));
        return "home";
    }

    @GetMapping("/add_Student")
    public String addStudentpage() {
        return "add_Student";
    }

    @PostMapping("/add_Student")
    public String addStudent(Item item) {
        itemServices.addItem(item);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String detailspage(@PathVariable Long id, Model model) {
        System.out.printf(String.valueOf(id));
        Item item = itemServices.getItemById(id);
        model.addAttribute("detailsItem", item);
        return "details";
    }

    @PostMapping("edit-item/")
    public String editItem(Item item) {
        itemServices.editItem(item);
        return "redirect:/details/" + item.getId();
    }

//    @PostMapping("edit-item/{id}")
//    public String editItem(@PathVariable Long id,
//                           @RequestParam(name = "edit_student_name") String name,
//                           @RequestParam(name = "edit_student_surname") String surname,
//                           @RequestParam(name = "edit_student_exam") int exam) {
//        Item item = itemServices.getItemById(id);
//        item.setName(name);
//        item.setSurname(surname);
//        item.setExam(exam);
//        return "redirect:/details/" + id;
//    }
//
    @PostMapping("delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemServices.deleteItem(id);
        return "redirect:/";
    }
}
