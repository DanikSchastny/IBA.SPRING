package by.iba.schastny.controller;

import by.iba.schastny.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;

@Controller
public class MessageController {
    @RequestMapping(method = RequestMethod.GET, value = "/helloworld")
    public String handler(Model model){
        Message message = new Message("Hello world!", (new Date()).toString());
        model.addAttribute("message", message);
        return "helloworld";
    }
}
