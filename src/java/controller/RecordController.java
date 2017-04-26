/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Record;
import entity.Staff;
import java.util.Date;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Do Tien Dung
 */
@Transactional
@Controller
@RequestMapping("/admin/")
public class RecordController {

    @Autowired
    SessionFactory factory;

    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String insert(ModelMap model) {
        model.addAttribute("record", new Record());
        return "admin/insert";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(ModelMap model,
            @Validated @ModelAttribute("record") Record record, BindingResult errors) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
        } else {
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();
            try {
                record.setDate(new Date());
                session.save(record);
                t.commit();
                model.addAttribute("message", "Thêm mới thành công !");
            } catch (Exception e) {
                t.rollback();
                model.addAttribute("message", "Thêm mới thất bại !");
            } finally {
                session.close();
            }
        }
        return "admin/insert";
    }

    @ModelAttribute("staffs")
    public List<Staff> getStaffs() {
        Session session = factory.getCurrentSession();
        String hql = "FROM Staff";
        Query query = session.createQuery(hql);
        List<Staff> list = query.list();
        return list;
    }
}
