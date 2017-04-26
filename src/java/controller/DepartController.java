/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Depart;
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

/**
 *
 * @author Do Tien Dung
 */
@Transactional
@Controller
@RequestMapping("/admin/depart")
public class DepartController {

    @Autowired
    SessionFactory factory;

    @RequestMapping()
    public String indexdp(ModelMap model) {
        model.addAttribute("depart", new Depart());
        model.addAttribute("departs", getDeparts());
        return "admin/depart";
    }

    @RequestMapping(params = "btnInsert")
    public String insertdp(ModelMap model,
            @Validated @ModelAttribute("depart") Depart depart, BindingResult errors) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
        } else {
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();
            try {
                session.save(depart);
                t.commit();
                model.addAttribute("message", "Thêm mới thành công !");
            } catch (Exception e) {
                t.rollback();
                model.addAttribute("message", "Thêm mới thất bại !");
            } finally {
                session.close();
            }

        }
        model.addAttribute("departs", getDeparts());
        return "admin/depart";
    }

    @RequestMapping(params = "btnUpdate")
    public String updatedp(ModelMap model,
            @Validated @ModelAttribute("depart") Depart depart, BindingResult errors) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
        } else {
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();
            try {
                session.update(depart);
                t.commit();
                model.addAttribute("message", "Cập nhật thành công !");
            } catch (Exception e) {
                t.rollback();
                model.addAttribute("message", "Cập nhật thất bại !");
            } finally {
                session.close();
            }

        }
        model.addAttribute("departs", getDeparts());
        return "admin/depart";
    }

    @RequestMapping(params = "btnDelete")
    public String deletedp(ModelMap model,@Validated Depart depart, BindingResult errors) {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.delete(depart);
            t.commit();
            model.addAttribute("message", "Xóa thành công !");
        } catch (Exception e) {
            t.rollback();
            model.addAttribute("message", "Xóa thất bại !");
        } finally {
            session.close();
        }
        model.addAttribute("depart", new Depart());
        model.addAttribute("departs", getDeparts());
        return "admin/depart";
    }

    @RequestMapping("edit/{id}")
    public String editdp(ModelMap model, @PathVariable("id") String id) {
        Session session = factory.getCurrentSession();
        Depart depart = (Depart) session.get(Depart.class, id);

        model.addAttribute("depart", depart);
        model.addAttribute("departs", getDeparts());
        return "admin/depart";
    }

//	@SuppressWarnings("unchecked")
    public List<Depart> getDeparts() {
        Session session = factory.getCurrentSession();
        String hql = "FROM Depart";
        Query query = session.createQuery(hql);
        List<Depart> list = query.list();
        return list;
    }
}
