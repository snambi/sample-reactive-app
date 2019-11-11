package demo.reactive;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import java.sql.Timestamp;
import java.util.Calendar;

@Controller
public class HomeController {

    @Autowired
    NewsRepository newsRepository;

    @RequestMapping("/")
    public String index(Model model){

        // loads 1 and display 1, stream data, data driven mode.
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(newsRepository.findAll(), 1);

        model.addAttribute("news", reactiveDataDrivenMode);

        // classic, wait repository loaded all and display it.
        //model.addAttribute("movies", movieRepository.findAll());

        return "index";
    }

    @RequestMapping("/home")
    public String home(){
        return "/home";
    }

    @GetMapping("/test")
    public String test( Model model ){
        Timestamp ts = new Timestamp(Calendar.getInstance().getTime().getTime());
        model.addAttribute("time", ts);
        return "test";
    }
}
