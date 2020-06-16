package guru.springframework.sfgpetclinic.services;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Owner;

public interface OwnerServcice extends CrudService <Owner,Long> {
	Owner findByLastName(String lastName);
}
