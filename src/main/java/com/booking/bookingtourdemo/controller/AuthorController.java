package com.booking.bookingtourdemo.controller;

//<editor-fold desc="IMPORT">

import com.booking.bookingtourdemo.constant.EventPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//</editor-fold>

@Controller
public class AuthorController {

    //<editor-fold defaultstate="collapsed" desc="WELCOME">
    @GetMapping(EventPath.LandingPage.URL_WELCOME)
    public String welcome() {
        return "redirect:" + EventPath.LandingPage.URL_LANDING_PAGE;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="TEST">
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("message", "<h2>Display <span style='color:red'>HTML</span> inside</h2>");
        return "redirect:" + EventPath.LandingPage.URL_LANDING_PAGE;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="LANDING PAGE">
    @GetMapping(EventPath.LandingPage.URL_LANDING_PAGE)
    public String landingPage(Model model) {
        model.addAttribute("testLoading", "<h2>Display <span style='color:red'>HTML</span> inside</h2>");
        return "pages/landing-page";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="LOGIN PAGE">
    @GetMapping(EventPath.OutOfLogin.URL_LOGIN)
    public String login(HttpSession session) {
        if (session.getAttribute("email") == null) {
            return "author/login";
        }
        return "redirect:" + EventPath.Logged.URL_DASHBOARD;
    }
    //</editor-fold>
}
