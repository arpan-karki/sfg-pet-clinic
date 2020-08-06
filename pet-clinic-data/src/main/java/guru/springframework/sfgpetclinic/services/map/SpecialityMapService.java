package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.services.SpecialityService;

@Service
public class SpecialityMapService extends AbstractMapServices<Speciality, Long> implements SpecialityService {

	@Override
	public Set<Speciality> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Speciality findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Speciality save(Speciality obj) {
		// TODO Auto-generated method stub
		return super.save(obj);
	}

	@Override
	public void delete(Speciality obj) {
		// TODO Auto-generated method stub
		super.delete(obj);

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);

	}

}
