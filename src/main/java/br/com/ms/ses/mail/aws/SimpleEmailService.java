package br.com.ms.ses.mail.aws;

import br.com.ms.ses.mail.model.MailDTO;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;

public class SimpleEmailService {
    public static void sendMail(MailDTO dto) {
        AmazonSimpleEmailService client =
                AmazonSimpleEmailServiceClientBuilder.standard()
                        .withRegion(Regions.US_EAST_1).build();
        SendEmailRequest request = new SendEmailRequest()
                .withDestination(new Destination().withToAddresses(dto.getTo()))
                .withMessage(new Message()
                        .withBody(new Body()
//                                    .withHtml(new Content()
//                                            .withCharset("UTF-8").withData(HTMLBODY))
                                .withText(new Content()
                                        .withCharset("UTF-8").withData(dto.getBody())))
                        .withSubject(new Content()
                                .withCharset("UTF-8").withData(dto.getSubject())))
                .withSource(dto.getFrom());
        client.sendEmail(request);
    }
}
