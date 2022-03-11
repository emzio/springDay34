package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    @ResponseBody
    @RequestMapping("/setcookie/{value1}/{value2}")
    public String setCookies(@PathVariable("value1") String value1TestName, @PathVariable String value2, HttpServletResponse response){
        Cookie cookie1 = new Cookie("cookie1", value1TestName);
        cookie1.setPath("/");
        response.addCookie(cookie1);

        Cookie cookie2 = new Cookie("cookie2", value2);
        cookie2.setPath("/");
        response.addCookie(cookie2);
        return "cookiesAdded";
    }

    @ResponseBody
    @RequestMapping("/getcookies")
    public String getCookies(HttpServletRequest request, @CookieValue(value = "cookie1", required = false) String cookie11, @CookieValue(value = "cookie2",defaultValue = "defaultValue") String cookie21 ){
        String result = "cookies: ";
        Cookie cookie1 = WebUtils.getCookie(request, "cookie1");
        Cookie cookie2 = WebUtils.getCookie(request, "cookie2");
        if (cookie1!=null){
            result += String.join(", ",cookie1.getName(), cookie1.getValue() +"\n");
        }
        if (cookie2!=null){
            result += String.join(", ",cookie2.getName(), cookie2.getValue());
        }
        result = (result.concat(" " + cookie11 + " " + cookie21));
        return  result;
    }
}

//    Utwórz akcję dostępną pod adresem /setcookie/<value1>/<value2>.
//        Akcja ma pobrać wartości parametrów value1 oraz value2, a
//        następnie ustawić dwa ciasteczka o nazwach cookie1 i wartości
//        value1 oraz cookie2 i wartości value2.
//        Dla ciasteczek ustaw wartość ścieżki jak w przykładzie:
//        cookie1.setPath("/");
//        Utwórz akcję dostępną pod adresem /getcookies,
//        która pobierze wartości ciasteczek.
//        Wykorzystaj 2 sposoby opisane w prezentacji -
//        klasę WebUtils oraz adnotację @CookieValue.
//        Wyświetl pobrane dane.