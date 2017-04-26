package controller;

import entity.User;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Transactional
@Controller
@RequestMapping("/home/")
public class HomeController {

    @Autowired
    SessionFactory factory;

    @RequestMapping("index")
    public String index() {
        return "home/index";
    }

    @RequestMapping("about")
    public String about() {
        return "home/about";
    }

    @RequestMapping("login")
    public String login() {
        return "home/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(ModelMap model,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession httpSession) {
        Session session = factory.getCurrentSession();
        try {
            User user = (User) session.get(User.class, username);
            if (username.equals("admin") & password.equals("123")) {
                if (!user.getPassword().equals(password)) {
                    model.addAttribute("message", "Sai tên mật khẩu !");
                } else {
                    httpSession.setAttribute("home", user);
                    model.addAttribute("message", "Đăng nhập thành công quyền quản trị !");
                }
                     return "redirect:/admin/list.htm";   
            }else{
                if (!user.getPassword().equals(password)) {
                    model.addAttribute("message", "Sai tên mật khẩu !");
                } else {
                    httpSession.setAttribute("home", user);
                    model.addAttribute("message", "Đăng nhập thành công !");
                }
                return "home/index";
            }
        } catch (Exception e) {
            model.addAttribute("message", "Sai tên đăng nhập !");
        }

        return "home/login";
    }

    @RequestMapping("logoff")
    public String logoff(HttpSession httpSession) {
        httpSession.removeAttribute("home");
        return "redirect:/home/login.htm";
    }
}
