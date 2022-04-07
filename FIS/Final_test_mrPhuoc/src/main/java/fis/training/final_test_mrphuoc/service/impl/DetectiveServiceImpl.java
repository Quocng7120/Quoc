package fis.training.final_test_mrphuoc.service.impl;


import fis.training.final_test_mrphuoc.entity.CriminalCase;
import fis.training.final_test_mrphuoc.entity.Detective;
import fis.training.final_test_mrphuoc.entity.Person;
import fis.training.final_test_mrphuoc.form.DetectiveFormForUpdate;
import fis.training.final_test_mrphuoc.repository.DetectiveRepo;
import fis.training.final_test_mrphuoc.service.DetectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class DetectiveServiceImpl implements DetectiveService {

    @Autowired
    DetectiveRepo detectiveRepo;

    @Override
    public Detective addDetective(Detective detective) {

        detective.setCreateAt(LocalDateTime.now());
        detective.setModifiedAt(LocalDateTime.now());
        return detectiveRepo.save(detective);
    }

    @Override
    public void updateDetective(Long id, DetectiveFormForUpdate form) {
        Detective detective = findDetectiveById(id);
        detective.setVersion(form.getVersion());
        detective.setArmed(form.getArmed());
        detective.setBadgeNumber(form.getBadgeNumber());
        detective.setPerson(form.getPerson());
        detectiveRepo.save(detective);
    }

    @Override
    public void deleteDetective(Long id) {
        Detective d = detectiveRepo.findById(id).orElse(null);
        if(d != null)
            detectiveRepo.deleteById(id);
    }

    @Override
    public Detective findDetectiveById(Long id) {
        Detective d = detectiveRepo.findById(id).orElse(null);
        if(d.equals(null))
            return null;
        return d;
    }

    @Override
    public List<Detective> getAllDetective() {
        return detectiveRepo.findAll();
    }
}
