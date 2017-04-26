/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Do Tien Dung
 */
@Controller
@RequestMapping("/admin/")
public class MailerController {
    @RequestMapping("mail")
    public String index(){
        return "admin/mail";
    }
    @Autowired
    JavaMailSender mailer;
    
    @RequestMapping("send")
    public String send(ModelMap model,
            @RequestParam("from")String from,
            @RequestParam("to") String to,
            @RequestParam("subject") String subject,
            @RequestParam("body") String body){
        try{
                //Tạo mail
                MimeMessage mail = mailer.createMimeMessage();
                // Sử dụng lớp hổ trợ
                MimeMessageHelper helper = new MimeMessageHelper(mail);
                helper.setFrom(from,from);
                helper.setTo(to);
                helper.setReplyTo(from,from);
                helper.setSubject(subject);
                helper.setText(body,true);
                //Gửi mail
                mailer.send(mail);
                model.addAttribute("message", "Send mail succes");
            }catch(Exception e){
                model.addAttribute("message", "Send mail fail");
            }
        return "admin/mail";
    }
}
