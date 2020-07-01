package guru.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService; 
	private final VetService vetService;
	
	
	public DataLoader(OwnerService ownerService, VetService vetService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1= new Owner();
		
		owner1.setFirstName("Arpan");
		owner1.setLastName("Karki");
		
		Owner owner2= new Owner();
		
		owner2.setFirstName("Sam");
		owner2.setLastName("Witwicky");
		
		ownerService.save(owner1);
		ownerService.save(owner2);
		
		System.out.println("Loaded Owners ...");
		ownerService.findAll().forEach(owner -> System.out.println(owner)); 
		
		Vet vet1= new Vet();
		vet1.setFirstName("Ram");
		vet1.setLastName("Bahadur");
		
		
		Vet vet2= new Vet();
		vet2.setFirstName("Sam");
		vet2.setLastName("Bahadur");
		
		
		
		vetService.save(vet1);
		vetService.save(vet2);
		System.out.println("Loaded Vets ...");
		vetService.findAll().forEach(vet -> System.out.println(vet)); 
	}

}
