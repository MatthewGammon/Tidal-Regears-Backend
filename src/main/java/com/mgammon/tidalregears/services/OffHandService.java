package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.exceptions.NotFoundByIdException;
import com.mgammon.tidalregears.models.OffHand;
import com.mgammon.tidalregears.repositories.OffHandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffHandService {
    private final OffHandRepository offHandRepository;

    @Autowired
    public OffHandService(OffHandRepository offHandRepository) {
        this.offHandRepository = offHandRepository;
    }

    public List<OffHand> getOffHand() {
        return offHandRepository.findAll();
    }

    public void addNewOffHand(OffHand offHand) {
        offHandRepository.save(offHand);
    }

    public Optional<OffHand> getOffHandById(Long offHandId) {
        if (offHandRepository.findById(offHandId).isEmpty()) {
            String entityName = "off hand";
            throw new NotFoundByIdException(offHandId, entityName);
        }
        return offHandRepository.findById(offHandId);
    }
}
