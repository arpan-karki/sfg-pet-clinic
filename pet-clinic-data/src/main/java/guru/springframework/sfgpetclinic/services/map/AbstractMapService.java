package guru.springframework.sfgpetclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import guru.springframework.sfgpetclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

		protected Map<Long,T> map =new HashMap();
		
		Set<T> findAll(){
			return new HashSet<>(map.values());	
		}
		
		T findById(ID id) {
			return map.get(id);
		}
		T save(T obj) {
			if(obj != null) {
				if(obj.getId() == null) {
					obj.setId(getNextId());
				}
			}
			map.put(obj.getId(), obj);
			return obj;
		}
		
		void deleteById(ID id) {
			map.remove(id);
		}
		void delete(T obj) {
			map.entrySet().removeIf(entry -> entry.getValue().equals(obj));
		}
		private Long getNextId() {
			Long nextId=null;
			try {
				nextId = Collections.max(map.keySet()) + 1;
			}catch(NoSuchElementException e) {
				nextId = 1L;
			}
			return nextId;
		}
}
