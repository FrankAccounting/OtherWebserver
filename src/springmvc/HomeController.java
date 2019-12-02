package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @RequestMapping("/")

    public String showHomePage() {
        return "index";
    }

    @Controller
    public class ErrorController {
        @RequestMapping(path = "/errors")

        public String showErrorPage(HttpServletRequest request, Model theModel) {

            int httpErrorCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
            String errorMsg;

            switch (httpErrorCode) {
                case 404:
                    errorMsg = "Http Error Code 404: Resource not found";
                    break;
                case 403:
                    errorMsg = "UnAuth";

                default:
                    errorMsg = "Great sadness";


            }

            theModel.addAttribute("errorMessage", errorMsg);

            return "errors";


        }
    }
}
