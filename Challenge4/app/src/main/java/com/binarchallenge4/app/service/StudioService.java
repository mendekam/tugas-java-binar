package com.binarchallenge4.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binarchallenge4.app.model.Studios;
import com.binarchallenge4.app.repository.StudioRepository;

@Service
public class StudioService {
    
    @Autowired
    StudioRepository studioRepository;

    public Studios createStudio(Studios studio) {
        return studioRepository.save(studio);
    }

    public List<Studios> getAllStudio(){
        return studioRepository.findAll();
    }
    
    public Studios getStudioById(Long id){
        return studioRepository.findById(id).orElseThrow(() -> new RuntimeException("Studio not found"));
    }

    public Studios updateStudio(Long id, Studios studio){
        Studios existingStudio = studioRepository.findById(id).orElseThrow(() -> new RuntimeException("Studio not found"));
        try {
            if(studio.getName() != null && !studio.getName().equals(""))
                existingStudio.setName(studio.getName());
            if(studio.getCapacity() != null && !studio.getCapacity().equals(""))
                existingStudio.setCapacity(studio.getCapacity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studioRepository.save(existingStudio);
    }

    public Studios deleteStudio(Long id){
        Studios existingStudio = studioRepository.findById(id).orElseThrow(() -> new RuntimeException("Studio not found"));
        studioRepository.delete(existingStudio);
        return existingStudio;
    }

}
