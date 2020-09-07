package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private QuestionService service;


    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Question> listQuestions = service.listAll();
        model.addAttribute("listQuestions", listQuestions);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewQuestionPage(Model model) {
        Question question = new Question();
        model.addAttribute("question", question);
        return "new_question";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("question") Question question) {
        service.save(question);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditQuestionPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_question");
        Question question = service.get(id);
        mav.addObject("question", question);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }

}
