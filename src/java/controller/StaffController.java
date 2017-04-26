package controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Depart;
import entity.Staff;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Transactional
@Controller
@RequestMapping("/admin")
public class StaffController {

    @Autowired
    SessionFactory factory;

    @RequestMapping()
    public String index(ModelMap model) {
        model.addAttribute("student", new Staff());
        model.addAttribute("students", getStaffs());
        return "admin/staff";
    }

    @RequestMapping(params = "btnInsert")
    public String insertnv(ModelMap model, 
            @Validated @ModelAttribute("student") Staff staff, BindingResult errors) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
        } else {
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();
            try {
                session.save(staff);
                t.commit();
                model.addAttribute("message", "Thêm mới thành công !");
            } catch (Exception e) {
                t.rollback();
                model.addAttribute("message", "Thêm mới thất bại !");
            } finally {
                session.close();
            }
        }
        model.addAttribute("students", getStaffs());
        return "admin/staff";
    }

    @RequestMapping(params = "btnUpdate")
    public String update(ModelMap model,
           @Validated @ModelAttribute("student") Staff staff, BindingResult errors) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
        } else {
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();
            try {
                session.update(staff);
                t.commit();
                model.addAttribute("message", "Cập nhật thành công !");
            } catch (Exception e) {
                t.rollback();
                model.addAttribute("message", "Cập nhật thất bại !");
            } finally {
                session.close();
            }
        }
        model.addAttribute("students", getStaffs());
        return "admin/staff";
    }

    @RequestMapping(params = "btnDelete")
    public String delete(ModelMap model, Staff staff) {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.delete(staff);
            t.commit();
            model.addAttribute("message", "Xóa thành công !");
        } catch (Exception e) {
            t.rollback();
            model.addAttribute("message", "Xóa thất bại !");
        } finally {
            session.close();
        }
        model.addAttribute("student", new Staff());
        model.addAttribute("students", getStaffs());
        return "admin/staff";
    }

    @RequestMapping("{id}")
    public String edit(ModelMap model, @PathVariable("id") String id) {
        Session session = factory.getCurrentSession();
        Staff student = (Staff) session.get(Staff.class, id);

        model.addAttribute("student", student);
        model.addAttribute("students", getStaffs());
        return "admin/staff";
    }

    @SuppressWarnings("unchecked")
    public List<Staff> getStaffs() {
        Session session = factory.getCurrentSession();
        String hql = "FROM Staff";
        Query query = session.createQuery(hql);
        List<Staff> list = query.list();
        return list;
    }

    @ModelAttribute("departs")
    @SuppressWarnings("unchecked")
    public List<Depart> getDeparts() {
        Session session = factory.getCurrentSession();
        String hql = "FROM Depart";
        Query query = session.createQuery(hql);
        List<Depart> list = query.list();
        return list;
    }

    @RequestMapping("report")
    public String report(ModelMap model) {
        Session session = factory.getCurrentSession();
        String hql = "SELECT r.staff.id, r.staff.name, SUM(case when r.type=1 then 1 else 0 end), SUM(case when r.type=0 then 1 else 0 end) FROM Record r  GROUP BY r.staff.id, r.staff.name";
        Query query = session.createQuery(hql);
        List<Object[]> list = query.list();
        model.addAttribute("arrays", list);
        return "admin/report";
    }

    @RequestMapping("report2")
    public String report2(ModelMap model) {
        Session session = factory.getCurrentSession();
        String hql = "SELECT r.staff.id, r.staff.name, r.staff.birthday, SUM(case when r.type=1 then 1 else 0 end), SUM(case when r.type=0 then 1 else 0 end) FROM Record r  GROUP BY r.staff.id, r.staff.name, r.staff.birthday";
        Query query = session.createQuery(hql);
        List<Object[]> list = query.list();
        model.addAttribute("arrays", list);
        return "admin/report2";
    }
}
