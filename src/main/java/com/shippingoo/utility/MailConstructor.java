package com.shippingoo.utility;


import com.shippingoo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

import java.util.Locale;

@Component
public class MailConstructor {

    @Autowired
    private Environment env;

    @Autowired
    private TemplateEngine templateEngine;

public SimpleMailMessage constructResetTokenEmail(String contextPath,Locale locale, String token, User user, String password ){
    String url= contextPath + "/newUser?token="+token;
    String message ="\n \nBonjour,\n \nVeuillez valider votre inscription sur la plateforme CuisineMenageChezVous.fr en cliquant sur " +
            "le lien ci-dessous. " +
            "\n \n Merci de votre confiance.\n \n L'Equipe CuisineMenageChezVous \n \n" ;

    SimpleMailMessage email = new SimpleMailMessage();
email.setTo(user.getEmail());
email.setSubject("CuisineMenageChezVous-Validez votre inscription");
email.setText(message+url);
email.setFrom(env.getProperty("support.email"));

return email;
}




}
