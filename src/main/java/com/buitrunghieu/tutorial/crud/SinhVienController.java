package com.buitrunghieu.tutorial.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SinhVienController {
	@Autowired
    private SinhVienService service;
 
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<SinhVien> listSinhVien = service.listAll();
        model.addAttribute("listSinhVien", listSinhVien);
        System.out.print("Get / ");
        return "index";
    }
    
    


       

        @GetMapping("/search-condition-two")
        public String searchByNameAndAge(
            @RequestParam("tenkhoa") String tenkhoa,
            @RequestParam(value = "diemtin", required = false) Float diemtin, Model model
        ) {
            List<SinhVien> searchResults;
            if (diemtin != null) {
                searchResults = service.searchByNameAndAgeWithOperator(tenkhoa, ">=", diemtin);
            } else {
                searchResults = service.searchByTenSinhVien(tenkhoa);
            }
            model.addAttribute("listSinhVien", searchResults);
            return "index";
        }


    
    @GetMapping("/search")
    public String searchByName(@RequestParam("tenSinhVien") String tenSinhVien, Model model) {
        List<SinhVien> searchResults = service.searchByTenSinhVien(tenSinhVien);
        model.addAttribute("listSinhVien", searchResults);
        return "index";
    }

   
 
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("SinhVien", new SinhVien());
        return "new";
    }
 
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSinhVien(@ModelAttribute("SinhVien") SinhVien std) {
        service.save(std);
        return "redirect:/";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("update");
        SinhVien std = service.get(id);
        mav.addObject("SinhVien", std);
        return mav;
        
    }
    @RequestMapping("/delete/{id}")
    public String deleteSinhVien(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
