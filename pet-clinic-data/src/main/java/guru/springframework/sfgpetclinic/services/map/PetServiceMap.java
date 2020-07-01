package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.CrudService;
import guru.springframework.sfgpetclinic.services.PetService;
@Service
public class PetServiceMap extends AbstractMapServices<Pet, Long> implements PetService {

	@Override
	public Pet save(Pet obj) {
		// TODO Auto-generated method stub
		return this.save(obj.getId(), obj);
	}

	@Override
	public Set<Pet> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Pet save(Long id, Pet obj) {
		// TODO Auto-generated method stub
		return super.save(id, obj);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Pet obj) {
		// TODO Auto-generated method stub
		super.delete(obj);
	}

}
