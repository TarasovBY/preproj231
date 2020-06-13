package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.model.User;
import web.service.Service;
import javax.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/")
public class CrudController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private Service service;



    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getPageAdmin(ModelMap modelMap) {
                modelMap.addAttribute("users", service.getAllUser());
                return "pageadmin";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String getAddUser() {
                User user = new User(request.getParameter("name"),
                        request.getParameter("telephone"));
                service.addUser(user.getName(), user.getTelephone());
                return "redirect:/admin";

    }

    @RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
    public String getDeleteUser() {
                User user = new User(Integer.parseInt(request.getParameter("id")),
                        request.getParameter("name"));
                service.deleteUser(user);
                return "redirect:/admin";

    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public String getUpdateUser() {
                User user = new User(Integer.parseInt(request.getParameter("id")),
                        request.getParameter("name"),
                        request.getParameter("telephone"));
                service.editUser(user);
                return "redirect:/admin";
    }


}
