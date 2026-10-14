const technologyProfiles = {
  wso2: {
    title: 'WSO2', overview: 'Integration, API and identity management technology.',
    expertise: ['Overview', 'API Manager', 'Enterprise Integrator', 'Identity Server', 'Choreo'],
    industries: ['Banking and Finance', 'Fintech', 'Telecommunications', 'Public sector and media'],
    resources: ['API Manager implementation', 'Integration services', 'Talk to our team']
  },
  activemq: {
    title: 'Apache ActiveMQÂ®', overview: 'Messaging platforms and application connectivity.',
    expertise: ['Overview', 'Apache ActiveMQÂ®', 'Apache Artemisâ„¢', 'Apache Camelâ„¢'],
    industries: ['Banking and Finance', 'Telecommunications', 'Retail and eCommerce', 'Hospitality and services'],
    resources: ['Messaging implementation', 'Migration services', 'Talk to our team']
  },
  kafka: {
    title: 'Apache KafkaÂ®', overview: 'Event streaming and data flows across connected systems.',
    expertise: ['Overview', 'Kafka platform integration', 'Event streaming', 'Data pipelines'],
    industries: ['Banking and Finance', 'Fintech', 'Retail and eCommerce', 'Technology teams'],
    resources: ['Streaming implementation', 'Integration services', 'Talk to our team']
  },
  'azure-devops': {
    title: 'Azure DevOps', overview: 'Build, release, and delivery workflows for engineering teams.',
    expertise: ['Overview', 'CI/CD pipelines', 'Release automation', 'Team workflows'],
    industries: ['Financial services', 'Technology teams', 'Public sector and media', 'Retail and eCommerce'],
    resources: ['DevOps services', 'Delivery improvement', 'Talk to our team']
  },
  'red-hat': {
    title: 'Red Hat', overview: 'Enterprise middleware, automation, and cloud infrastructure.',
    expertise: ['Overview', 'Middleware', 'Cloud platforms', 'Automation'],
    industries: ['Banking and Finance', 'Telecommunications', 'Public sector and media', 'Technology teams'],
    resources: ['Platform implementation', 'Cloud infrastructure', 'Talk to our team']
  },
  ibm: {
    title: 'IBM', overview: 'Enterprise platforms, application integration, and messaging.',
    expertise: ['Overview', 'IBM platforms', 'Application integration', 'Enterprise messaging'],
    industries: ['Banking and Finance', 'Telecommunications', 'Public sector and media', 'SACCOs and cooperatives'],
    resources: ['Integration services', 'Platform support', 'Talk to our team']
  },
  'ibm-mq': {
    title: 'IBM MQâ„¢', overview: 'Enterprise messaging and application connectivity.',
    expertise: ['Overview', 'Messaging architecture', 'Application connectivity', 'Operations'],
    industries: ['Banking and Finance', 'Telecommunications', 'SACCOs and cooperatives', 'Public sector and media'],
    resources: ['MQ implementation', 'Migration services', 'Talk to our team']
  },
  'elk-stack': {
    title: 'ELK Stack', overview: 'Log collection, search, and operational insight.',
    expertise: ['Overview', 'Log collection', 'Search and analysis', 'Operational dashboards'],
    industries: ['Banking and Finance', 'Retail and eCommerce', 'Technology teams', 'Hospitality and services'],
    resources: ['Observability services', 'Platform support', 'Talk to our team']
  },
  datadog: {
    title: 'DataDog', overview: 'Metrics, logs, traces, and service monitoring.',
    expertise: ['Overview', 'Metrics and monitoring', 'Logs and traces', 'Service visibility'],
    industries: ['Banking and Finance', 'Telecommunications', 'Retail and eCommerce', 'Technology teams'],
    resources: ['Observability services', 'Monitoring setup', 'Talk to our team']
  },
  fiorano: {
    title: 'Fiorano', overview: 'Enterprise integration, APIs, and messaging.',
    expertise: ['Overview', 'Enterprise integration', 'API connectivity', 'Messaging'],
    industries: ['Banking and Finance', 'Telecommunications', 'Retail and eCommerce', 'Technology teams'],
    resources: ['Integration services', 'Platform implementation', 'Talk to our team']
  },
  esb: {
    title: 'Enterprise Service Bus', overview: 'Integration architecture for connected applications and services.',
    expertise: ['Overview', 'Integration architecture', 'Application connectivity', 'Message routing'],
    industries: ['Banking and Finance', 'Telecommunications', 'Public sector and media', 'Technology teams'],
    resources: ['Integration services', 'Architecture advisory', 'Talk to our team']
  },
  dynatrace: {
    title: 'Dynatrace', overview: 'Application performance monitoring and observability.',
    expertise: ['Overview', 'Application observability', 'Distributed tracing', 'Performance monitoring'],
    industries: ['Banking and Finance', 'Telecommunications', 'Retail and eCommerce', 'Technology teams'],
    resources: ['Observability services', 'Monitoring setup', 'Talk to our team']
  },
  t24: {
    title: 'T24', overview: 'Core banking system integration and data exchange.',
    expertise: ['Overview', 'Core platform integration', 'API connectivity', 'Data exchange'],
    industries: ['Banking and Finance', 'Fintech', 'SACCOs and cooperatives', 'Public sector and media'],
    resources: ['Banking integrations', 'Platform support', 'Talk to our team']
  },
  finacle: {
    title: 'Finacle', overview: 'Banking platform integration with surrounding systems and services.',
    expertise: ['Overview', 'Core platform integration', 'API connectivity', 'Data exchange'],
    industries: ['Banking and Finance', 'Fintech', 'SACCOs and cooperatives', 'Public sector and media'],
    resources: ['Banking integrations', 'Platform support', 'Talk to our team']
  },
  'kong-api': {
    title: 'Kong API', overview: 'API gateway, lifecycle management, and governance.',
    expertise: ['Overview', 'API gateway', 'API lifecycle', 'API governance'],
    industries: ['Banking and Finance', 'Telecommunications', 'Retail and eCommerce', 'Fintech'],
    resources: ['API integration services', 'API Manager implementation', 'Talk to our team']
  },
  istio: {
    title: 'Istio', overview: 'Service mesh, traffic management, and service visibility.',
    expertise: ['Overview', 'Service mesh', 'Traffic management', 'Service visibility'],
    industries: ['Banking and Finance', 'Telecommunications', 'Technology teams', 'Public sector and media'],
    resources: ['Cloud infrastructure', 'Platform support', 'Talk to our team']
  },
  grafana: {
    title: 'Grafana', overview: 'Dashboards, metrics, logs, and observability.',
    expertise: ['Overview', 'Dashboards', 'Metrics and logs', 'Observability'],
    industries: ['Banking and Finance', 'Telecommunications', 'Retail and eCommerce', 'Technology teams'],
    resources: ['Observability services', 'Monitoring setup', 'Talk to our team']
  }
};

function setTechnology(menu, choice) {
  const profile = technologyProfiles[choice.dataset.technology];
  if (!profile) return;

  menu.querySelectorAll('.technology-choice').forEach((item) => {
    const selected = item === choice;
    item.classList.toggle('is-active', selected);
    if (selected) item.setAttribute('aria-current', 'true');
    else item.removeAttribute('aria-current');
  });

  menu.querySelector('[data-technology-title]').textContent = profile.title;
  menu.querySelector('[data-technology-overview]').textContent = profile.overview;
  const detailUrl = choice.getAttribute('href');
  const populateLinks = (selector, labels, useDetailUrl = false) => {
    const container = menu.querySelector(selector);
    container.replaceChildren(...labels.map((label) => {
      const link = document.createElement('a');
      link.textContent = label;
      const lowerLabel = label.toLowerCase();
      link.href = useDetailUrl
        ? (label === 'API Manager' && choice.dataset.technology === 'wso2' ? '/services/api-integrations' : detailUrl)
        : lowerLabel.includes('talk') ? '/#contact'
          : lowerLabel.includes('implementation') ? '/services/api-integrations'
            : lowerLabel.includes('services') ? '/services' : '/#industries';
      return link;
    }));
  };

  populateLinks('[data-technology-expertise]', profile.expertise, true);
  populateLinks('[data-technology-industries]', profile.industries);
  populateLinks('[data-technology-resources]', profile.resources);
}

function setSolution(menu, choice) {
  const selectedSolution = choice.dataset.solution;
  if (!selectedSolution) return;

  menu.querySelectorAll('.solutions-choice').forEach((item) => {
    const selected = item === choice;
    item.classList.toggle('is-active', selected);
    item.setAttribute('aria-expanded', selected ? 'true' : 'false');
  });

  menu.querySelectorAll('[data-solution-panel]').forEach((panel) => {
    const selected = panel.dataset.solutionPanel === selectedSolution;
    panel.hidden = !selected;
    panel.classList.toggle('is-active', selected);
  });
}

function setIndustry(menu, choice) {
  const selectedIndustry = choice.dataset.industry;
  if (!selectedIndustry) return;

  menu.querySelectorAll('.industries-choice').forEach((item) => {
    const selected = item === choice;
    item.classList.toggle('is-active', selected);
    item.setAttribute('aria-expanded', selected ? 'true' : 'false');
  });

  menu.querySelectorAll('[data-industry-panel]').forEach((panel) => {
    const selected = panel.dataset.industryPanel === selectedIndustry;
    panel.hidden = !selected;
    panel.classList.toggle('is-active', selected);
  });
}

document.querySelectorAll('.technologies-menu, .solutions-menu, .industries-menu, .company-menu').forEach((menu) => {
  const closeMenu = () => {
    menu.removeAttribute('open');
    if (menu.contains(document.activeElement)) document.activeElement.blur();
  };

  menu.addEventListener('pointerenter', (event) => {
    if (event.pointerType === 'mouse') menu.setAttribute('open', '');
  });
  menu.addEventListener('pointerleave', (event) => {
    if (event.pointerType === 'mouse' && !menu.contains(event.relatedTarget)) closeMenu();
  });
  menu.addEventListener('focusout', (event) => {
    if (!menu.contains(event.relatedTarget)) closeMenu();
  });
  menu.addEventListener('keydown', (event) => {
    if (event.key === 'Escape') closeMenu();
  });

  menu.querySelectorAll('.technology-choice').forEach((choice) => {
    choice.addEventListener('pointerenter', () => setTechnology(menu, choice));
    choice.addEventListener('focus', () => setTechnology(menu, choice));
  });

  menu.querySelectorAll('.solutions-choice').forEach((choice) => {
    choice.addEventListener('pointerenter', () => setSolution(menu, choice));
    choice.addEventListener('focus', () => setSolution(menu, choice));
    choice.addEventListener('click', () => setSolution(menu, choice));
  });

  menu.querySelectorAll('.industries-choice').forEach((choice) => {
    choice.addEventListener('pointerenter', () => setIndustry(menu, choice));
    choice.addEventListener('focus', () => setIndustry(menu, choice));
    choice.addEventListener('click', () => setIndustry(menu, choice));
  });
});

const softwareContactForm = document.querySelector('#softwareContactForm');
softwareContactForm?.addEventListener('submit', (event) => {
  event.preventDefault();
  const formData = new FormData(softwareContactForm);
  const subject = 'Software and platforms project enquiry';
  const message = [
    `Name: ${formData.get('name')}`,
    `Email: ${formData.get('email')}`,
    `Organisation: ${formData.get('organisation') || 'Not provided'}`,
    `Project focus: ${formData.get('need')}`,
    '',
    'Project details:',
    formData.get('message')
  ].join('\n');
  window.location.href = `mailto:wambu2040@gmail.com?subject=${encodeURIComponent(subject)}&body=${encodeURIComponent(message)}`;
});

const consultationForm = document.querySelector('#consultationForm');
consultationForm?.addEventListener('submit', (event) => {
  event.preventDefault();
  const formData = new FormData(consultationForm);
  const subject = 'Consultation request';
  const message = [
    `Name: ${formData.get('name')}`,
    `Email: ${formData.get('email')}`,
    `Phone: ${formData.get('phone') || 'Not provided'}`,
    `Area of interest: ${formData.get('interest')}`,
    '',
    'Project details:',
    formData.get('message')
  ].join('\n');
  window.location.href = `mailto:wambu2040@gmail.com?subject=${encodeURIComponent(subject)}&body=${encodeURIComponent(message)}`;
});

document.querySelectorAll('.technology-contact-form').forEach((form) => {
  form.addEventListener('submit', (event) => {
    event.preventDefault();
    const formData = new FormData(form);
    const technology = form.dataset.technologyName || 'Technology';
    const subject = `${technology} enquiry`;
    const message = [
      `Technology: ${technology}`,
      `Name: ${formData.get('name')}`,
      `Email: ${formData.get('email')}`,
      `Organisation: ${formData.get('organisation') || 'Not provided'}`,
      `Area of support: ${formData.get('area')}`,
      '',
      'What they want to achieve:',
      formData.get('message')
    ].join('\n');
    window.location.href = `mailto:wambu2040@gmail.com?subject=${encodeURIComponent(subject)}&body=${encodeURIComponent(message)}`;
  });
});
