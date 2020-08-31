package guru.springframework.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.PetService;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
class OwnerMapServiceTest {

	OwnerMapService ownerMapService;
	final Long ownerId = 2L;
	final String lastName = "Smith";

	@BeforeEach
	void setUp() throws Exception {
		ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
		ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
	}

	@Test
	void testFindAll() {
		Set<Owner> owners = ownerMapService.findAll();
		System.out.println(owners);
		assertEquals(1, owners.size());
	}

	@Test
	void testFindByIdLong() {
		Owner owner = ownerMapService.findById(ownerId);
		assertEquals(ownerId, owner.getId());
	}

	@Test
	void testSaveOwner() {
		Long id = 2L;
		Owner owner = ownerMapService.save(Owner.builder().id(id).build());
		assertEquals(id, owner.getId());
	}

	@Test
	void testFindByLastName() {
		Owner smith = ownerMapService.findByLastName(lastName);
		assertNotNull(smith);
		assertEquals(ownerId, smith.getId());

	}

	@Test
	void testSaveOwnerAgain() {
		Long id = 2L;
		Owner owner1 = ownerMapService.save(Owner.builder().id(id).build());
		assertEquals(id, owner1.getId());
	}

	@Test
	void testDeleteByIdLong() {
		ownerMapService.delete(ownerMapService.findById(ownerId));
		assertEquals(1, ownerMapService.findAll().size());
	}

	@Test
	void testDeleteOwner() {
		ownerMapService.delete(ownerMapService.findById(ownerId));
		assertEquals(0, ownerMapService.findAll().size());
	}
}
