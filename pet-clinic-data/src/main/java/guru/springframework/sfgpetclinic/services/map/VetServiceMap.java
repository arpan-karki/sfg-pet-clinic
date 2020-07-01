package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.CrudService;
import guru.springframework.sfgpetclinic.services.VetService;

public class VetServiceMap extends AbstractMapServices<Vet, Long> implements VetService {

	@Override
	public Vet save(Vet obj) {
		// TODO Auto-generated method stub
		return super.save(obj.getId(),obj);
	}

	@Override
	public Set<Vet> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Vet save(Long id, Vet obj) {
		// TODO Auto-generated method stub
		return super.save(id, obj);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Vet obj) {
		// TODO Auto-generated method stub
		super.delete(obj);
	}

	

}
