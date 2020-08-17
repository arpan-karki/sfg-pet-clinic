package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.VisitService;
import guru.springframework.sfgpetclinic.services.map.OwnerMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialityService specialityService, VisitService visitService) {
		super();
		this.specialityService = specialityService;
		this.petTypeService = petTypeService;
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();

		if (count == 0) {
			loadData();
		}

	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("dog");
		PetType savedDogType = petTypeService.save(dog);

		PetType cat = new PetType();
		dog.setName("cat");
		PetType savedCatType = petTypeService.save(cat);

		Owner owner1 = new Owner();

		owner1.setFirstName("Arpan");
		owner1.setLastName("Karki");
		owner1.setAddress("addr");
		owner1.setCity("city");
		owner1.setTelephone("Telephone");

		Pet arpansPet = new Pet();
		arpansPet.setPetName("Arpans Pet");
		arpansPet.setPetType(dog);
		arpansPet.setOwner(owner1);
		arpansPet.setBirthDate(LocalDate.now());

		owner1.getPets().add(arpansPet);

		Owner owner2 = new Owner();

		owner2.setFirstName("Sam");
		owner2.setLastName("Witwicky");
		owner2.setAddress("addr");
		owner2.setCity("city");
		owner2.setTelephone("Telephone");

		Pet samsPet = new Pet();
		samsPet.setPetName("Sams Pet");
		samsPet.setPetType(cat);
		samsPet.setOwner(owner1);
		samsPet.setBirthDate(LocalDate.now());

		
		
		owner2.getPets().add(samsPet);
		ownerService.save(owner1);
		ownerService.save(owner2);
		
		Visit catVisit = new Visit();
		catVisit.setDescription("Sneezy Kitty");
		catVisit.setDate(LocalDate.now());
		catVisit.setPet(samsPet);
		visitService.save(catVisit);
		System.out.println("Loaded Visits ...");

		System.out.println("Loaded Owners ...");
		ownerService.findAll().forEach(owner -> System.out.println(owner));

		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");

		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");

		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");

		Speciality savedSurgery = specialityService.save(surgery);
		Speciality savedDentistry = specialityService.save(dentistry);
		Speciality savedRadiology = specialityService.save(radiology);

		Vet vet1 = new Vet();
		vet1.setFirstName("Ram");
		vet1.setLastName("Bahadur");
		vet1.getSpecialities().add(savedRadiology);

		Vet vet2 = new Vet();
		vet2.setFirstName("Sam");
		vet2.setLastName("Bahadur");
		vet2.getSpecialities().add(savedDentistry);

		vetService.save(vet1);
		vetService.save(vet2);
		System.out.println("Loaded Vets ...");

	}

}
