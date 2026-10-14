package system.mananja;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/consultations")
public class ConsultationController {

    private final JavaMailSender mailSender;
    private final String senderAddress;
    private final String recipientAddress;

    public ConsultationController(
            JavaMailSender mailSender,
            @Value("${spring.mail.username:}") String senderAddress,
            @Value("${app.contact.recipient:wambu2040@gmail.com}") String recipientAddress) {
        this.mailSender = mailSender;
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;
    }

    @PostMapping
    public ResponseEntity<SubmissionResponse> submit(@Valid @RequestBody ConsultationRequest request) {
        if (senderAddress.isBlank()) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(new SubmissionResponse(false,
                            "The consultation form is not configured yet. Please contact us by phone."));
        }

        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(senderAddress);
        email.setTo(recipientAddress);
        email.setReplyTo(request.email());
        email.setSubject("Consultation request: " + request.interest());
        email.setText("A new consultation request was submitted from the website.\n\n"
                + "Name: " + request.name() + "\n"
                + "Email: " + request.email() + "\n"
                + "Phone: " + (request.phone().isBlank() ? "Not provided" : request.phone()) + "\n"
                + "Area of interest: " + request.interest() + "\n\n"
                + "Project details:\n" + request.message());

        try {
            mailSender.send(email);
            return ResponseEntity.ok(new SubmissionResponse(true,
                    "Thanks. Your consultation request has been sent."));
        } catch (MailException exception) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(new SubmissionResponse(false,
                            "We could not send your request right now. Please try again or contact us by phone."));
        }
    }

    public record ConsultationRequest(
            @NotBlank @Size(max = 120) String name,
            @NotBlank @Email @Size(max = 254) String email,
            @Size(max = 40) String phone,
            @NotBlank @Size(max = 120) String interest,
            @NotBlank @Size(max = 5000) String message) {
        public ConsultationRequest {
            phone = phone == null ? "" : phone;
        }
    }

    public record SubmissionResponse(boolean sent, String message) {}
}
