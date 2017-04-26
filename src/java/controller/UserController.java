/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Do Tien Dung
 */
@Transactional
@Controller
@RequestMapping("/admin/list")
public class UserController {

    @Autowired
    SessionFactory factory;

//    @RequestMapping("list")
//    public String index(ModelMap model) {
//        Session session = factory.getCurrentSession();
//        String hql = "FROM User";
//        Query query = session.createQuery(hql);
//        List<User> list = query.list();
//        model.addAttribute("users", list);
//        return "admin/list";
//    }
//
//    @RequestMapping("delete/{username}")
//    public String delete(ModelMap model, @PathVariable("username") String username) {
//        Session session = factory.getCurrentSession();
//        User user = (User) session.get(User.class, username);
//        session.delete(user);
//        model.addAttribute("message", "xoá thành công");
//        return "redirect:/admin/list.htm";
//    }
//    @RequestMapping("edit")
//    public String update(ModelMap model, @PathVariable("username") String username) {
//        Session session = factory.getCurrentSession();
//        User user = (User) session.get(User.class, username);
//        session.update(user);
//        model.addAttribute("message", "xoá thành công");
//        return "redirect:/admin/list.htm";
//    }
//
//    @RequestMapping(value = "insert", method = RequestMethod.GET)
//    public String insert(ModelMap model) {
//        model.addAttribute("user", new User());
//        return "admin/insert";
//    }
//
//    @RequestMapping(value = "insert", method = RequestMethod.POST)
//    public String insert(ModelMap model, @ModelAttribute("user") User user) {
//        Session session = factory.openSession();
//        Transaction t = session.beginTransaction();
//        try {
//            session.save(user);
//            t.commit();
//            model.addAttribute("message", "Thêm mới thành công !");
//        } catch (Exception e) {
//            t.rollback();
//            model.addAttribute("message", "Thêm mới thất bại !");
//        } finally {
//            session.close();
//        }
//        return "admin/insert";
//    }
////    @RequestMapping(value = "update", method = RequestMethod.GET)
////    public String update(ModelMap model) {
////        model.addAttribute("user", new User());
////        return "admin/update";
////    }
////    @RequestMapping(value = "update", method = RequestMethod.POST)
////    public String update(ModelMap model, @ModelAttribute("user") User user) {
////        Session session = factory.openSession();
////        Transaction t = session.beginTransaction();
////        try {
////            session.update(user);
////            t.commit();
////            model.addAttribute("message", "cập nhật thành công !");
////        } catch (Exception e) {
////            t.rollback();
////            model.addAttribute("message", "Cập nhật thất bại !");
////        } finally {
////            session.close();
////        }
////        return "admin/update";
////    }
    @RequestMapping()
    public String indexus(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", getUsers());
        return "admin/list";
    }

    @RequestMapping(params = "btnInsert")
    public String insertus(ModelMap model, @Validated @ModelAttribute("user") User user, BindingResult errors) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
        } else {
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();
            try {
                session.save(user);
                t.commit();
                model.addAttribute("message", "Thêm mới thành công !");
            } catch (Exception e) {
                t.rollback();
                model.addAttribute("message", "Thêm mới thất bại !");
            } finally {
                session.close();
            }

        }
        model.addAttribute("users", getUsers());
        return "admin/list";

    }

    @RequestMapping(params = "btnUpdate")
    public String updateus(ModelMap model, @Validated @ModelAttribute("user") User user, BindingResult errors) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
        } else {
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();
            try {
                session.update(user);
                t.commit();
                model.addAttribute("message", "Cập nhật thành công !");
            } catch (Exception e) {
                t.rollback();
                model.addAttribute("message", "Cập nhật thất bại !");
            } finally {
                session.close();
            }

        }
        model.addAttribute("users", getUsers());
        return "admin/list";
    }

    @RequestMapping(params = "btnDelete")
    public String deleteus(ModelMap model,@Validated User user, BindingResult errors) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Bạn phải nhập đầy đủ để xoá !");
        } else {
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();
            try {
                session.delete(user);
                t.commit();
                model.addAttribute("message", "Xoá thành công !");
            } catch (Exception e) {
                t.rollback();
                model.addAttribute("message", "Xoá thất bại !");
            } finally {
                session.close();
            }

        }
        model.addAttribute("user", new User());
        model.addAttribute("users", getUsers());
        return "admin/list";
    }

    @RequestMapping("edit/{username}")
    public String editus(ModelMap model, @PathVariable("username") String username) {
        Session session = factory.getCurrentSession();
        User user = (User) session.get(User.class, username);

        model.addAttribute("user", user);
        model.addAttribute("users", getUsers());
        return "admin/list";
    }

//	@SuppressWarnings("unchecked")
    public List<User> getUsers() {
        Session session = factory.getCurrentSession();
        String hql = "FROM User";
        Query query = session.createQuery(hql);
        List<User> list = query.list();
        return list;
    }
}
