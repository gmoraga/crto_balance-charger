package cl.gabodev.crto.balger;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
@SpringBootApplication
public class BalanceChargerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BalanceChargerApplication.class, args);
	}

	//	@Bean
	//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	//		return args -> {
	//
	//			System.out.println("Let's inspect the beans provided by Spring Boot:");
	//
	//			String[] beanNames = ctx.getBeanDefinitionNames();
	//			Arrays.sort(beanNames);
	//			for (String beanName : beanNames) {
	//				System.out.println(beanName);
	//			}
	//
	//		};
	//	}

//	@Bean
//	public CommandLineRunner demo(CustomerRepository repository) {
//		return (args) -> {
//			// save a few customers
//			repository.save(new Customer("Jack", "Bauer"));
//			repository.save(new Customer("Chloe", "O'Brian"));
//			repository.save(new Customer("Kim", "Bauer"));
//			repository.save(new Customer("David", "Palmer"));
//			repository.save(new Customer("Michelle", "Dessler"));
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Customer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			Customer customer = repository.findById(1L);
//			log.info("Customer found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByLastName("Bauer").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//			for (Customer bauer : repository.findByLastName("Bauer")) {
//				log.info(bauer.toString());
//			}
//			log.info("");
//		};
//	}
	
//	@Bean
//	CommandLineRunner init(StorageService storageService) {
//		return (args) -> {
//			storageService.deleteAll();
//			storageService.init();
//		};
//	}

}
