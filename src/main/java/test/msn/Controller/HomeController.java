package test.msn.Controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import test.msn.Services.ServiceUsers1;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {

    private static final Logger log = Logger.getLogger(HomeController.class);

    @Autowired
    ServiceUsers1 serviceUsers1;

	@GetMapping("/")
    public String index() {
        return "index";
    }
	
	@GetMapping("/message")
    public String message() {
        return "showMessage";
    }
	
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {

        if (error != null) {
            model.addAttribute("error", "username/password tidak ditemukan.");
            log.debug("username/password tidak ditemukan.");
            return "login";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }

        return "redirect:/";
	}

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/viewdata")
    public String viewdata(Model model) {
        List<Object[]> listusers = serviceUsers1.allCustom();
        log.info("access view data.");
        model.addAttribute("listusers", listusers);

        return "viewdata";
    }

    @PostMapping("/registerp")
    public String registerp(
            @RequestParam("username") String user
            , @RequestParam("password") String passwd
            , @RequestParam("repassword") String repasswd
            , @RequestParam("age") String age
            , RedirectAttributes redirectAttributes) {

        String message = "register sukses.";

        if (!passwd.equals(repasswd)) {
            message = "password & confirm password harus sama";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/register";
        }

        Pattern pwdpattern = Pattern.compile("^(?=.*\\d)(?=.*[A-Z]).{6,255}$", Pattern.CASE_INSENSITIVE);
        Matcher matchpwd = pwdpattern.matcher(passwd);
        if (!matchpwd.find()) {
            message = "password minimal 6 karakter, harus ada huruf dan angka, setidaknya 1 huruf kapital.";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/register";
        }

        Pattern emailpattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matchemail = emailpattern.matcher(user);
        if (!matchemail.find()) {
            message = "format email harus benar.";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/register";
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Object[] ret = serviceUsers1.saveCustom(user, bCryptPasswordEncoder.encode(passwd), age);

        if (Integer.valueOf(String.valueOf(ret[0])) == 0) {
            message = "user: " + user + " sudah terdaftar.";
            log.error(message);
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/register";
        }

        log.info("register user: " + user + " berhasil.");
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/login";
    }
}
