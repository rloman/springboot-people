package nl.programit.people.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.programit.people.domain.Fiets;

@Service
@Transactional
public class FietsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FietsService.class);
	
	@Autowired
	private FietsRepository fietsRepository;
	
	public Fiets save(Fiets fiets) {
		
		LOGGER.debug("it rocks");
		
		Fiets result = this.fietsRepository.save(fiets);	
		
		return result;

	}
	
	public Iterable<Fiets> findAll() {
		Iterable<Fiets> result = this.fietsRepository.findAll();
		
		return result;
	}

}
