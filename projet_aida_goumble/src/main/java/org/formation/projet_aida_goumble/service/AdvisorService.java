package org.formation.projet_aida_goumble.service;

import org.formation.projet_aida_goumble.entity.Advisor;
import org.formation.projet_aida_goumble.repository.AdvisorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvisorService {
    private final AdvisorRepository advisorRepository;
    public AdvisorService(AdvisorRepository advisorRepository) {
        this.advisorRepository = advisorRepository;
    }
    public List<Advisor> getAdvisors(){
        return advisorRepository.findAll();
    }

    public Optional<Advisor> getAdvisorsById(Long id){
        return advisorRepository.findById(id);
    }

    public void saveAdvisor(Advisor advisor){
        advisorRepository.save(advisor);
    }

    public void deleteAdvisor(Long id){
        advisorRepository.deleteById(id);
    }
}
