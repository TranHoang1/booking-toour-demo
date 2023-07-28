package com.booking.bookingtourdemo.constant;

public class EventPath {

    //<editor-fold defaultstate="collapsed" desc="INIT">
    public static Class getInnerClassModuleNameBy(String moduleCode) {
        switch (moduleCode) {
            // common
            case "logged":
                return Logged.class;
            case "out-of-login":
                return OutOfLogin.class;
            case "landing-page":
                return LandingPage.class;
            default:
                return null;
        }
    }
    //</editor-fold>

    public static class Logged {
        public static final String URL_DASHBOARD = "/dashboard";
    }

    public static class OutOfLogin {
        public static final String URL_LOGIN = "/login";
    }

    public static class LandingPage {
        public static final String URL_LANDING_PAGE = "/landing-page";
        public static final String URL_WELCOME = "/";
    }

}
