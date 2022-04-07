package fis.training.final_test_mrphuoc.service.impl;

import fis.training.final_test_mrphuoc.entity.CriminalCase;
import fis.training.final_test_mrphuoc.entity.Detective;
import fis.training.final_test_mrphuoc.entity.Working_Detective_Case;
import fis.training.final_test_mrphuoc.form.CriminalCaseFormForUpdate;
import fis.training.final_test_mrphuoc.repository.CriminalCaseRepo;
import fis.training.final_test_mrphuoc.repository.DetectiveRepo;
import fis.training.final_test_mrphuoc.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CriminalCaseServiceImpl implements CriminalCaseService {



    @Autowired
    CriminalCaseRepo criminalCaseRepo;

    @Override
    public List<CriminalCase> getAllCriminalCase() {
        return criminalCaseRepo.findAll();
    }

    @Autowired
    DetectiveRepo detectiveRepo;

    @Override
    public CriminalCase addCriminalCase(CriminalCase criminalCase) {
        CriminalCase c = criminalCaseRepo.findByNumber(criminalCase.getNumber());
        if(c != null)
            return null;
        Set<Working_Detective_Case> list = criminalCase.getWorkingSet();
        if(list != null)
            for(Working_Detective_Case w : list) {
                Detective detective=detectiveRepo.findByBadgeNumber(w.getDetective().getBadgeNumber());
                if(detective==null)
                    return null;
                w.setDetective(detective);
            }
        criminalCase.setWorkingSet(list);
        criminalCase.setCreateAt(LocalDateTime.now());
        criminalCase.setModifiedAt(LocalDateTime.now());
        return criminalCaseRepo.save(criminalCase);
    }

    @Override
    public void updateCriminalCase(Long id, CriminalCaseFormForUpdate form) {
        CriminalCase criminalCase = findCriminalCaseById(id);
        criminalCase.setVersion(form.getVersion());
        criminalCase.setNumber(form.getNumber());
        criminalCase.setShortDescription(form.getShortDescription());
        criminalCase.setDetailedDescription(form.getDetailDescription());
        criminalCase.setNotes(form.getNotes());
        criminalCaseRepo.save(criminalCase);
    }


    @Override
    public void deleteCriminalCase(Long id) {
        CriminalCase kq = criminalCaseRepo.findById(id).orElse(null);
        if(kq!=null)
        criminalCaseRepo.deleteById(id);
    }

    @Override
    public CriminalCase findCriminalCaseById(Long id) {
        CriminalCase c = criminalCaseRepo.findById(id).orElse(null);
        if(c.equals(null))
            return null;
        return c;
    }
}
