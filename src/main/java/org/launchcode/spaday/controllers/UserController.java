package org.launchcode.spaday.controllers;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/")
    public String index(){
        return "/user/index";
    }
    @GetMapping("/add")
    public String displayAddUserForm(Model model){
//        if(!error.isBlank()) {
//            String errorString = "";
//            if(error.equals("passdoesnotmatch")) {errorString = "Your password did not match, please re-enter";}
//            model.addAttribute("error", errorString);
//        }
        return "/user/add";
    }
    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if(!user.getPassword().equals(verify)) {
            model.addAttribute("passDoesNotMatch",true);
            model.addAttribute("username",user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "/user/add";
        } else {
            return "/user/index";
        }
    }

}
