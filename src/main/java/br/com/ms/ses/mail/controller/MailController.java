package br.com.ms.ses.mail.controller;

import br.com.ms.ses.mail.aws.SimpleEmailService;
import br.com.ms.ses.mail.model.MailDTO;
import br.com.ms.ses.mail.model.StatusDTO;
import br.com.ms.ses.mail.model.StatusErrorDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.security.Principal;


@RestController
@EnableWebMvc
public class MailController {
    @RequestMapping(path = "/mail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public StatusDTO sendMail(@RequestBody MailDTO dto, Principal principal) {
        try {
            SimpleEmailService.sendMail(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return new StatusErrorDTO("error", "aws_ses_error", e.getMessage());
        }
        return new StatusDTO("ok");
    }
}
