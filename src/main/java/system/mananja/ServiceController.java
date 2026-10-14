package system.mananja;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ServiceController {

    @GetMapping("/health")
    public HealthResponse health() {
        return new HealthResponse("ok");
    }

    @GetMapping("/services")
    public List<ServiceOffering> services() {
        return List.of(
                new ServiceOffering("01", "API Integrations",
                        "Design, implement, and manage secure APIs with WSO2 API Manager, from first architecture through ongoing optimization.",
                        "/services/api-integrations"),
                new ServiceOffering("02", "Cloud & infrastructure",
                        "Build secure, scalable foundations that give your teams room to do their best work."),
                new ServiceOffering("03", "Software & platforms",
                        "Design and deliver the digital products your customers and people actually need.",
                        "/solutions/software-platforms"),
                new ServiceOffering("04", "Enterprise Agentic AI",
                        "Make your data useful, accessible, and ready to support smarter decisions."));
    }

    public static class HealthResponse {
        private final String status;

        public HealthResponse(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }

    public static class ServiceOffering {
        private final String number;
        private final String title;
        private final String description;
        private final String link;

        public ServiceOffering(String number, String title, String description) {
            this(number, title, description, "#contact");
        }

        public ServiceOffering(String number, String title, String description, String link) {
            this.number = number;
            this.title = title;
            this.description = description;
            this.link = link;
        }

        public String getNumber() {
            return number;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getLink() {
            return link;
        }

        public boolean isExternalLink() {
            return link.startsWith("https://");
        }
    }
}
