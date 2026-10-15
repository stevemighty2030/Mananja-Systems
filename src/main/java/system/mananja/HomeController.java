package system.mananja;

import java.time.Year;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Controller
public class HomeController {

    private static final Map<String, TechnologyInfo> TECHNOLOGIES = Map.ofEntries(
            Map.entry("wso2", new TechnologyInfo("WSO2", "Integration, API and identity management",
                    "Plan, build, and support WSO2 platforms around the way your organisation connects applications, manages APIs, and serves its users. We help teams design integrations, govern API access, and run identity services that fit their architecture and operational needs.",
                    List.of("API Manager", "Enterprise Integrator", "Identity Server", "Choreo"),
                    List.of("Architecture and implementation", "Platform upgrades and migration", "Managed services and support", "API strategy and governance"))),
            Map.entry("activemq", new TechnologyInfo("Apache ActiveMQ", "Messaging and application connectivity",
                    "Connect applications through dependable messaging patterns, with implementation and operational support shaped to your environment. We help plan broker architecture, message flows, and the operational practices needed for dependable delivery between systems.", List.of("ActiveMQ", "Artemis", "Camel"), List.of("Broker architecture and configuration", "Application messaging integration", "Migration and version planning", "Operations and support"))),
            Map.entry("kafka", new TechnologyInfo("Apache Kafka", "Event streaming and data flows",
                    "Design and deliver event streaming foundations that help teams connect services and exchange data across their platforms. Our work covers event architecture, reliable data pipelines, and the operational visibility needed to support streaming workloads.", List.of("Kafka platform design", "Event streaming integration", "Operations and monitoring"), List.of("Kafka platform and topic design", "Producer and consumer integration", "Event pipeline monitoring", "Operations and support"))),
            Map.entry("azure-devops", new TechnologyInfo("Azure DevOps", "Build, release, and delivery workflows",
                    "Bring planning, source control, build pipelines, and releases into a delivery workflow that fits your engineering teams. We help establish repeatable CI/CD, automate releases, and improve how teams coordinate delivery from development through deployment.", List.of("CI/CD pipeline design", "Release automation", "Team workflow improvement"), List.of("Azure Boards and repository setup", "CI/CD pipeline implementation", "Release and environment automation", "Workflow coaching and support"))),
            Map.entry("red-hat", new TechnologyInfo("Red Hat", "Middleware, automation, and cloud platforms",
                    "Plan and support enterprise middleware and cloud environments with an emphasis on stable integration and practical operations. We work across application platforms, automation, and hybrid infrastructure so teams can deploy and operate services consistently.", List.of("Middleware platforms", "Cloud infrastructure", "Automation"), List.of("Middleware and integration platforms", "Hybrid cloud architecture", "Automation and configuration", "Platform operations and support"))),
            Map.entry("ibm", new TechnologyInfo("IBM Cloud Pak for Integration", "API management, application integration, and event streaming",
                    "IBM Cloud Pak for Integration brings together capabilities for managing APIs, connecting applications, and building event-driven solutions. We help teams plan how these capabilities fit their architecture, security, and operating model.", List.of("IBM API Connect", "IBM Application Connect Enterprise", "IBM Event Streams"), List.of("Platform architecture and implementation", "API lifecycle and governance", "Application integration and event streaming", "Migration, optimisation, and support"))),
            Map.entry("ibm-mq", new TechnologyInfo("IBM MQ", "Enterprise messaging",
                    "Plan, connect, and support messaging environments that carry business transactions between applications. Our work includes queue design, application connectivity, migration, and operational practices that help protect important message flows.", List.of("Messaging architecture", "Application connectivity", "Operations and support"), List.of("Queue manager and channel design", "Application connectivity", "Resilience and recovery planning", "MQ operations and support"))),
            Map.entry("elk-stack", new TechnologyInfo("ELK Stack", "Logs, search, and operational insight",
                    "Bring logs together and make operational information easier for your teams to search, review, and act on. We help structure collection and indexing, build useful searches and dashboards, and give operations teams clearer context when investigating issues.", List.of("Log collection", "Search and analysis", "Operational dashboards"), List.of("Log source integration", "Index and search design", "Dashboards and alerting", "Retention and operations planning"))),
            Map.entry("datadog", new TechnologyInfo("Datadog", "Metrics, logs, traces, and monitoring",
                    "Build a practical observability approach that helps teams understand the health and performance of connected services. We bring metrics, logs, and traces together into actionable monitoring, useful alerts, and clearer service-level insight.", List.of("Metrics and monitoring", "Logs and traces", "Service visibility"), List.of("Infrastructure and application monitoring", "Logs, traces, and integrations", "Dashboards and alert strategy", "Usage and operations support"))),
            Map.entry("fiorano", new TechnologyInfo("Fiorano", "Enterprise integration and messaging",
                    "Connect applications, APIs, and messaging systems with an integration approach tailored to your organisation. We help plan Fiorano implementations, connect existing platforms, and support integration flows as business requirements change.", List.of("Enterprise integration", "API connectivity", "Messaging"), List.of("Fiorano integration architecture", "API and messaging flows", "Environment and release setup", "Production support and optimisation"))),
            Map.entry("esb", new TechnologyInfo("Enterprise Service Bus", "Connect applications and services",
                    "Design and support service bus patterns that help applications exchange data and work together across your organisation. We assess integration needs, define routing and transformation patterns, and help teams maintain clear connections between systems.", List.of("Integration architecture", "Application connectivity", "Message routing"), List.of("Integration architecture and governance", "Application and service connectivity", "Routing and transformation", "Modernisation and support"))),
            Map.entry("dynatrace", new TechnologyInfo("Dynatrace", "Application performance observability",
                    "Improve the visibility of connected applications and services, and give teams useful insight for troubleshooting and tuning. We help instrument workloads, interpret performance data, and establish observability practices that support faster diagnosis and informed optimisation.", List.of("Application observability", "Distributed tracing", "Performance monitoring"), List.of("Application and service observability", "Performance and trace analysis", "Monitoring and alert design", "Instrumentation and support"))),
            Map.entry("t24", new TechnologyInfo("T24", "Core banking system integration",
                    "Connect core banking environments with surrounding services and data flows through planned, supportable integration. We help map interfaces, coordinate exchange with channels and partner systems, and plan changes around the needs of banking operations.", List.of("Core platform integration", "API connectivity", "Data exchange"), List.of("T24 interface and integration planning", "Channel and partner connectivity", "Data exchange and reconciliation", "Testing and operational support"))),
            Map.entry("finacle", new TechnologyInfo("Finacle", "Banking platform integration",
                    "Plan integrations between banking platforms and the services, channels, and systems around them. We support interface design and data exchange to connect Finacle with digital channels and enterprise applications.", List.of("Core platform integration", "API connectivity", "Data exchange"), List.of("Finacle interface discovery", "Digital channel integration", "API and message flows", "Testing and release support"))),
            Map.entry("kong-api", new TechnologyInfo("Kong API", "API gateway and lifecycle management",
                    "Shape an API gateway approach that supports consistent API access, governance, and delivery across your organisation. We help design gateway policies, manage API lifecycles, and give developers a dependable way to publish and use services.", List.of("API gateway", "API lifecycle", "API governance"), List.of("Gateway architecture and deployment", "Authentication and traffic policies", "API publishing and lifecycle", "Monitoring and platform support"))),
            Map.entry("istio", new TechnologyInfo("Istio", "Service mesh and traffic management",
                    "Plan and support service mesh capabilities that improve how teams manage communication between distributed services. We help configure traffic controls, secure service-to-service communication, and improve visibility across cloud-native workloads.", List.of("Service mesh", "Traffic management", "Service visibility"), List.of("Mesh architecture and rollout", "Traffic management and resilience", "Workload identity and security", "Operations and observability"))),
            Map.entry("grafana", new TechnologyInfo("Grafana", "Dashboards and observability",
                    "Bring operational signals into useful dashboards so teams can understand services and respond with context. We help connect data sources, build dashboards around operational questions, and establish monitoring views teams can use day to day.", List.of("Dashboards", "Metrics and logs", "Observability"), List.of("Data source integration", "Dashboard and alert design", "Observability workflows", "Governance and support"))));

    private static final Map<String, String> TECHNOLOGY_LOGOS = Map.ofEntries(
            Map.entry("wso2", "https://www.google.com/s2/favicons?domain=wso2.com&sz=128"),
            Map.entry("activemq", "https://www.google.com/s2/favicons?domain=activemq.apache.org&sz=128"),
            Map.entry("kafka", "https://cdn.simpleicons.org/apachekafka/231F20"),
            Map.entry("azure-devops", "/technology-logos/azure-devops.svg"),
            Map.entry("red-hat", "https://cdn.simpleicons.org/redhat/EE0000"),
            Map.entry("ibm", "/technology-logos/ibm-cloud-pak-for-integration.svg"),
            Map.entry("ibm-mq", "https://cdn.simpleicons.org/ibm/052FAD"),
            Map.entry("elk-stack", "https://cdn.simpleicons.org/elasticstack/005571"),
            Map.entry("datadog", "https://cdn.simpleicons.org/datadog/632CA6"),
            Map.entry("fiorano", "https://www.google.com/s2/favicons?domain=fiorano.com&sz=128"),
            Map.entry("esb", "/technology-logos/enterprise-service-bus.svg"),
            Map.entry("dynatrace", "https://cdn.simpleicons.org/dynatrace/1496FF"),
            Map.entry("t24", "https://www.google.com/s2/favicons?domain=temenos.com&sz=128"),
            Map.entry("finacle", "https://www.google.com/s2/favicons?domain=finacle.com&sz=128"),
            Map.entry("kong-api", "https://cdn.simpleicons.org/kong/003459"),
            Map.entry("istio", "https://cdn.simpleicons.org/istio/466BB0"),
            Map.entry("grafana", "https://cdn.simpleicons.org/grafana/F46800"));

    private static final Map<String, List<String>> TECHNOLOGY_USE_CASES = Map.ofEntries(
            Map.entry("wso2", List.of("Connect on-premises and cloud applications through managed integrations.", "Publish secure APIs for internal teams, partners, and digital channels.", "Provide identity, access, and federation capabilities across applications.")),
            Map.entry("activemq", List.of("Buffer work between applications that operate at different speeds.", "Deliver messages reliably when a receiving service is temporarily unavailable.", "Connect legacy and modern systems with established broker-based messaging.")),
            Map.entry("kafka", List.of("Stream business events between services and data platforms.", "Build event-driven services that need durable, replayable event feeds.", "Feed real-time analytics and operational workflows from multiple producers.")),
            Map.entry("azure-devops", List.of("Coordinate work items, source code, builds, and releases in one delivery workflow.", "Automate testing and deployments across development, staging, and production.", "Improve repeatability and release visibility across engineering teams.")),
            Map.entry("red-hat", List.of("Run enterprise integration and application workloads on supported platforms.", "Automate configuration and operations across hybrid environments.", "Build a consistent foundation for containerised and cloud-native services.")),
            Map.entry("ibm", List.of("Connect IBM workloads with digital channels and surrounding enterprise applications.", "Modernise interfaces and data exchange around established business platforms.", "Coordinate integration and platform changes across complex system estates.")),
            Map.entry("ibm-mq", List.of("Move transactional messages between applications with explicit delivery behaviour.", "Connect distributed systems across network and environment boundaries.", "Provide resilient queues for systems that cannot always be online together.")),
            Map.entry("elk-stack", List.of("Search application and infrastructure logs from a shared operational view.", "Investigate incidents by correlating events across connected services.", "Build dashboards and alerts around logs that help support teams act.")),
            Map.entry("datadog", List.of("Monitor service and infrastructure health across distributed environments.", "Trace requests through dependencies to find latency and error sources.", "Correlate metrics, logs, and traces for faster operational investigations.")),
            Map.entry("fiorano", List.of("Integrate business applications through reusable service and message flows.", "Expose APIs and connect systems with different protocols or data formats.", "Orchestrate information exchange across enterprise workflows.")),
            Map.entry("esb", List.of("Connect applications that need shared routing and transformation patterns.", "Introduce consistent interfaces between systems with different protocols.", "Manage integration flows across legacy and newer applications.")),
            Map.entry("dynatrace", List.of("Understand application dependencies and end-to-end service performance.", "Investigate response time and errors across distributed transactions.", "Give operations teams actionable visibility into service health.")),
            Map.entry("t24", List.of("Connect core banking processes with digital channels and partner services.", "Exchange transaction and customer data with surrounding platforms.", "Plan integration changes while protecting critical banking operations.")),
            Map.entry("finacle", List.of("Connect core banking capabilities with mobile, web, and partner channels.", "Coordinate data exchange between Finacle and enterprise applications.", "Support integration delivery across banking processes and operations.")),
            Map.entry("kong-api", List.of("Provide managed entry points for internal and external APIs.", "Apply consistent security, routing, and traffic policies to API services.", "Give API teams a governed process for publishing and evolving APIs.")),
            Map.entry("istio", List.of("Manage traffic between services running in distributed environments.", "Apply consistent workload identity and service-to-service security.", "Observe and control service communication in Kubernetes-based platforms.")),
            Map.entry("grafana", List.of("Create dashboards that give teams a shared view of service health.", "Bring metrics and operational data from multiple sources into one workflow.", "Alert on meaningful changes and help teams investigate incidents.")));

    private static final Map<String, TechnologyPageData> TECHNOLOGY_PAGE_DATA = Map.ofEntries(
            Map.entry("wso2", new TechnologyPageData(
                    "We help organisations plan and deliver WSO2 around real integration needs: connect systems, expose and govern APIs, and manage identity across applications. Work can cover architecture, product configuration, custom integrations, migration, delivery automation, and ongoing support.",
                    List.of("Design API products, policies, developer access, and lifecycle governance with API Manager.", "Build integrations and orchestrations that connect applications, data, and services through Enterprise Integrator.", "Plan authentication, federation, access control, and identity lifecycle needs with Identity Server.", "Assess Choreo for teams that want a managed platform to build, deploy, and operate digital services."),
                    List.of("Map the APIs, integrations, identity journeys, and non-functional needs the platform must support.", "Choose a deployment model and environments that fit security, scaling, resilience, and operational ownership.", "Plan subscriptions, support arrangements, upgrades, and product versions for business-critical workloads.", "Build CI/CD, configuration management, monitoring, and recovery practices into the implementation from the start."))),
            Map.entry("activemq", new TechnologyPageData(
                    "We help teams use ActiveMQ to move messages between applications with clear delivery, retry, and recovery behaviour. The work can include broker topology, application connectivity, migration planning, and operational runbooks.",
                    List.of("Define queues and topics around the message flows and ownership boundaries between applications.", "Plan broker topology and persistence to match throughput, availability, and recovery requirements.", "Connect producers and consumers with agreed message formats, delivery guarantees, and error handling."),
                    List.of("Document message volume, peak loads, payload sizes, ordering, and delivery expectations.", "Plan dead-letter handling, retries, duplicate processing, and recovery for failed consumers.", "Review broker security, credentials, network boundaries, monitoring, backups, and patching."))),
            Map.entry("kafka", new TechnologyPageData(
                    "We help organisations establish Kafka as a dependable event-streaming foundation, from topic design and producer integration through consumer operations. The goal is to make event flows understandable, resilient, and useful to the teams that build on them.",
                    List.of("Model event topics, keys, retention, and schemas around business events and consuming applications.", "Connect source and destination systems through event producers, consumers, and integration pipelines.", "Define monitoring and operational ownership for brokers, consumer groups, and data flows."),
                    List.of("Agree event ownership, schema evolution, retention, ordering, and replay requirements.", "Plan capacity, replication, access controls, encryption, and disaster recovery for expected workloads.", "Make consumer lag, failed processing, data quality, and incident response visible to operators."))),
            Map.entry("azure-devops", new TechnologyPageData(
                    "We help teams organise software delivery in Azure DevOps, connecting work planning with repositories, builds, testing, and releases. We shape pipelines and team practices around your environments, controls, and delivery goals.",
                    List.of("Structure projects, repositories, boards, and permissions to match team responsibilities.", "Automate build, test, and deployment workflows with reusable pipeline patterns.", "Connect release approvals, environment controls, and delivery evidence to operational requirements."),
                    List.of("Agree branching, code review, artifact, and environment promotion practices across teams.", "Protect service connections and secrets, and apply least-privilege access to pipeline resources.", "Plan rollback, approvals, audit needs, and ownership for production deployments."))),
            Map.entry("red-hat", new TechnologyPageData(
                    "We help organisations plan Red Hat platforms for application integration, automation, and hybrid infrastructure. Engagements can span architecture, deployment, migration, configuration, and the operational practices needed to run platforms consistently.",
                    List.of("Select middleware and integration components to support application and API workloads.", "Use automation to make configuration and repeatable operational tasks consistent.", "Plan hybrid cloud and container platform foundations around workload and governance needs."),
                    List.of("Map platform dependencies, subscriptions, support responsibilities, and lifecycle requirements.", "Design identity, network, secrets, patching, backup, and recovery controls for each environment.", "Set capacity, observability, automation, and upgrade practices before moving critical workloads."))),
            Map.entry("ibm", new TechnologyPageData(
                    "We help teams connect IBM platforms with the applications and services around them, taking existing architecture and operating requirements into account. Work can include integration design, messaging, interface modernisation, migration, and support planning.",
                    List.of("Connect enterprise applications through consistent integration patterns and interfaces.", "Coordinate messaging and transaction flows between IBM systems and connected platforms.", "Plan platform changes and modernisation while preserving required business processes."),
                    List.of("Inventory platform versions, interfaces, customisations, and upstream and downstream dependencies.", "Define transaction, availability, security, and data handling requirements for each integration.", "Plan testing, cutover, rollback, and operational ownership for changes to established systems."))),
            Map.entry("ibm-mq", new TechnologyPageData(
                    "We help design and operate IBM MQ environments that carry important messages between applications. This includes queue and channel design, connectivity, migration, resilience, security, and operational support planning.",
                    List.of("Design queues, channels, and naming conventions around application ownership and message flows.", "Connect distributed applications with security and routing appropriate to each environment.", "Plan availability, recovery, and administration for queue managers and connected workloads."),
                    List.of("Confirm delivery, ordering, persistence, transaction, and expiry needs for each flow.", "Plan queue depth alerts, dead-letter processing, backups, recovery, and capacity management.", "Coordinate certificates, identities, network paths, change windows, and compatibility across endpoints."))),
            Map.entry("elk-stack", new TechnologyPageData(
                    "We help teams make operational logs searchable and useful by planning collection, parsing, indexing, and dashboards around real support questions. The implementation can include data pipelines, access controls, retention, alerting, and operational handover.",
                    List.of("Collect and enrich logs from applications, infrastructure, and integration platforms.", "Structure indexes and searches so teams can investigate events across services.", "Create dashboards and alerts that surface operational patterns and actionable signals."),
                    List.of("Define log sources, useful fields, sensitive data handling, and retention periods.", "Estimate ingestion volume, storage growth, query patterns, and the cost of keeping data.", "Set access controls, index lifecycle policies, backup needs, and alert ownership."))),
            Map.entry("datadog", new TechnologyPageData(
                    "We help teams bring metrics, logs, traces, and service context together in Datadog to improve operational visibility. Work can cover instrumentation, integrations, dashboards, alert design, and making monitoring useful to engineering and support teams.",
                    List.of("Connect infrastructure and application telemetry to the services teams operate.", "Trace requests across dependencies to understand latency and errors along a transaction path.", "Build monitors and dashboards around service health, user impact, and operational response."),
                    List.of("Choose the signals and service ownership labels needed for useful, actionable views.", "Set alert thresholds and routing to reduce noise and clarify who responds.", "Plan agent deployment, data access, retention, sensitive fields, and usage governance."))),
            Map.entry("fiorano", new TechnologyPageData(
                    "We help organisations use Fiorano to connect applications, APIs, and messaging in line with their integration architecture. Work can cover solution design, flow development, environment configuration, migration, and practical support for production operations.",
                    List.of("Design integration flows and service interfaces around business processes and system boundaries.", "Connect APIs and messaging endpoints with appropriate transformation and routing.", "Organise development, testing, deployment, and monitoring across environments."),
                    List.of("Inventory endpoints, protocols, payload formats, throughput, and service dependencies.", "Plan error handling, retries, duplicate prevention, and operational alerts for each flow.", "Agree environment promotion, access controls, versioning, and ownership for integrations."))),
            Map.entry("esb", new TechnologyPageData(
                    "We help organisations plan service bus patterns that let applications exchange information through managed interfaces. The work begins with integration needs and boundaries, then defines routing, transformation, reliability, and governance suited to the estate.",
                    List.of("Connect systems through explicit service interfaces and managed message flows.", "Apply routing and transformation where they support clear, reusable integration boundaries.", "Coordinate shared integration capabilities, monitoring, and operational ownership."),
                    List.of("Avoid turning the bus into an unclear central dependency; set service and ownership boundaries.", "Document payload contracts, error paths, retries, throughput, and availability needs.", "Plan security, observability, change management, and a path for evolving legacy integrations."))),
            Map.entry("dynatrace", new TechnologyPageData(
                    "We help teams apply Dynatrace to understand application behaviour and service performance across connected environments. Work includes instrumentation planning, service views, alerting, and using observability data to guide investigation and improvement.",
                    List.of("Map application dependencies and user transactions across distributed services.", "Instrument workloads and define service health indicators relevant to teams.", "Use traces, logs, and performance data to investigate errors and latency."),
                    List.of("Select key services, user journeys, and service-level indicators before configuring alerts.", "Plan agent coverage, data access, retention, and any sensitive information captured.", "Assign ownership for alert response and connect findings to incident and change practices."))),
            Map.entry("t24", new TechnologyPageData(
                    "We help plan integration around T24 core banking environments, connecting core processes with channels, payments, partners, and enterprise systems. The approach focuses on well-defined interfaces, controlled change, and reliable operational handover.",
                    List.of("Map T24 interfaces and the systems that provide or consume banking data.", "Design API and messaging connections for channels, payments, and partner services.", "Coordinate data exchange and integration changes with core banking operations."),
                    List.of("Confirm product version, interface patterns, customisations, and vendor constraints.", "Protect transaction integrity, security, audit needs, and reconciliation across connected systems.", "Plan end-to-end testing, cutover sequencing, rollback, and business operations support."))),
            Map.entry("finacle", new TechnologyPageData(
                    "We help connect Finacle banking platforms to digital channels and enterprise applications through planned, supportable integration. Work can include interface design, API and messaging patterns, data exchange, and coordinated delivery with banking teams.",
                    List.of("Identify Finacle interfaces and the channel, payment, and enterprise systems around them.", "Design API and message flows with clear validation and error handling.", "Coordinate integration delivery with business processes and operational teams."),
                    List.of("Understand Finacle version, enabled modules, customisations, and existing integration contracts.", "Plan data privacy, transaction controls, reconciliation, and audit requirements.", "Coordinate test data, end-to-end validation, release windows, and rollback responsibilities."))),
            Map.entry("kong-api", new TechnologyPageData(
                    "We help teams use Kong to publish and manage APIs with consistent routing, security, and lifecycle controls. Work can cover gateway architecture, policy configuration, developer access, migration, and operational monitoring.",
                    List.of("Route API traffic through managed gateway services and environment boundaries.", "Apply authentication, rate limits, and policy controls consistently across APIs.", "Organise API publication, developer access, versioning, and lifecycle governance."),
                    List.of("Choose gateway deployment topology and availability for expected traffic and failure modes.", "Define identity, secrets, certificate renewal, policy ownership, and access review practices.", "Plan API versioning, analytics, rate limits, and incident response with API owners."))),
            Map.entry("istio", new TechnologyPageData(
                    "We help platform teams introduce Istio service mesh capabilities where they solve real service communication needs. Work includes mesh architecture, traffic policy, security, observability, rollout planning, and clear operational ownership.",
                    List.of("Manage service-to-service traffic with routing and resilience policies.", "Apply workload identity and communication security across mesh-connected services.", "Observe service dependencies and traffic behaviour to support troubleshooting."),
                    List.of("Confirm Kubernetes and workload compatibility, resource impact, and mesh boundaries.", "Plan certificates, identity, policy ownership, and safe rollout across services.", "Prepare teams for upgrades, troubleshooting, telemetry volume, and mesh control-plane operations."))),
            Map.entry("grafana", new TechnologyPageData(
                    "We help teams turn metrics and operational data into Grafana dashboards that answer useful questions. Work can cover data source integration, dashboard design, alerting, access, and the conventions that keep monitoring understandable as systems grow.",
                    List.of("Connect metrics, logs, and traces through the data sources teams already operate.", "Build dashboards around service health, business signals, and operational workflows.", "Define alerts and shared views that help teams detect and investigate issues."),
                    List.of("Agree naming, labels, dashboard ownership, and conventions to support reuse.", "Set sensible alert thresholds and notification paths so signals stay actionable.", "Plan access controls, data source credentials, retention, and dashboard maintenance."))));

    private static List<String> standardServices() {
        return List.of("Technical support", "Consulting and advisory", "Implementation", "Migration and optimisation");
    }

    private final ServiceController serviceController;

    public HomeController(ServiceController serviceController) {
        this.serviceController = serviceController;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("services", serviceController.services());
        model.addAttribute("currentYear", Year.now().getValue());
        return "index";
    }

    @GetMapping("/services")
    public String services(Model model) {
        model.addAttribute("services", serviceController.services());
        model.addAttribute("currentYear", Year.now().getValue());
        return "services";
    }

    @GetMapping("/solutions/software-platforms")
    public String softwarePlatforms(Model model) {
        model.addAttribute("currentYear", Year.now().getValue());
        return "software-platforms";
    }

    @GetMapping("/technologies")
    public String technologies(Model model) {
        model.addAttribute("technologies", TECHNOLOGIES.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .toList());
        model.addAttribute("technologyLogos", TECHNOLOGY_LOGOS);
        model.addAttribute("currentYear", Year.now().getValue());
        return "technologies";
    }

    @GetMapping("/company")
    public String company(Model model) {
        model.addAttribute("currentYear", Year.now().getValue());
        return "company";
    }

    @GetMapping("/services/api-integrations")
    public String apiIntegrations(Model model) {
        model.addAttribute("currentYear", Year.now().getValue());
        return "api-integrations";
    }

    @GetMapping({"/technologies/{slug}", "/technologies/{slug}/"})
    public String technology(@PathVariable("slug") String slug, Model model) {
        TechnologyInfo technology = TECHNOLOGIES.get(slug);
        if (technology == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("technology", technology);
        model.addAttribute("technologyDetail", TECHNOLOGY_PAGE_DATA.get(slug));
        model.addAttribute("technologyCapabilities", technologyCapabilities(technology, TECHNOLOGY_PAGE_DATA.get(slug)));
        model.addAttribute("technologyLogo", TECHNOLOGY_LOGOS.get(slug));
        model.addAttribute("technologyUseCases", TECHNOLOGY_USE_CASES.get(slug));
        model.addAttribute("currentYear", Year.now().getValue());
        if ("wso2".equals(slug)) {
            return "technology-wso2";
        }
        if ("red-hat".equals(slug)) {
            return "technology-red-hat";
        }
        if ("activemq".equals(slug)) {
            return "technology-activemq";
        }
        if ("ibm".equals(slug)) {
            return "technology-ibm";
        }
        if ("azure-devops".equals(slug)) {
            return "technology-platform";
        }
        if ("kafka".equals(slug)) {
            return "technology-platform";
        }
        return "technology-catalog-detail";
    }

    private List<TechnologyCapability> technologyCapabilities(TechnologyInfo technology, TechnologyPageData detail) {
        List<TechnologyCapability> capabilities = new java.util.ArrayList<>();
        for (int index = 0; index < technology.getCapabilities().size(); index++) {
            String description = detail != null && index < detail.getCapabilityDetails().size()
                    ? detail.getCapabilityDetails().get(index)
                    : technology.getDescription();
            capabilities.add(new TechnologyCapability(technology.getCapabilities().get(index), description));
        }
        return List.copyOf(capabilities);
    }

    public static class TechnologyCapability {
        private final String name;
        private final String description;

        public TechnologyCapability(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public String getName() { return name; }
        public String getDescription() { return description; }
    }

    public static class TechnologyInfo {
        private final String name;
        private final String tagline;
        private final String description;
        private final List<String> capabilities;
        private final List<String> services;

        public TechnologyInfo(String name, String tagline, String description, List<String> capabilities, List<String> services) {
            this.name = name;
            this.tagline = tagline;
            this.description = description;
            this.capabilities = capabilities;
            this.services = services;
        }

        public String getName() { return name; }
        public String getInitial() { return name.substring(0, 1); }
        public String getTagline() { return tagline; }
        public String getDescription() { return description; }
        public List<String> getCapabilities() { return capabilities; }
        public List<String> getServices() { return services; }
    }

    public static class TechnologyPageData {
        private final String approach;
        private final List<String> capabilityDetails;
        private final List<String> considerations;

        public TechnologyPageData(String approach, List<String> capabilityDetails, List<String> considerations) {
            this.approach = approach;
            this.capabilityDetails = capabilityDetails;
            this.considerations = considerations;
        }

        public String getApproach() { return approach; }
        public List<String> getCapabilityDetails() { return capabilityDetails; }
        public List<String> getConsiderations() { return considerations; }
    }
}
