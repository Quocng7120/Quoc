package fis.training.final_test_mrphuoc.service.impl;

import fis.training.final_test_mrphuoc.dto.ResponseDto;
import fis.training.final_test_mrphuoc.entity.CaseType;
import fis.training.final_test_mrphuoc.entity.CriminalCase;
import fis.training.final_test_mrphuoc.entity.Evidence;
import fis.training.final_test_mrphuoc.form.EvidenceFormForCreate;
import fis.training.final_test_mrphuoc.repository.CriminalCaseRepo;
import fis.training.final_test_mrphuoc.repository.EvidenceRepo;
import fis.training.final_test_mrphuoc.service.EvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EvidenceServiceImpl implements EvidenceService {

    @Autowired
    EvidenceRepo evidenceRepo;

    @Autowired
    CriminalCaseRepo criminalCaseRepo;


    @Override
    public Evidence getEvidenceById(Long Id) {
        return evidenceRepo.findById(Id).get();
    }

    @Override
    public ResponseDto createEvidence(Evidence evidence) {
        ResponseDto respo = new ResponseDto();
        String message = "Number đã tồn tại";
        if (evidenceRepo.existsByNumber(evidence.getNumber())) {
            respo.setCode("error");
            respo.setMassage(message);
            return respo;

        }
        Evidence e = evidenceRepo.save(evidence);
        respo.setCode("successfully!");
        respo.setMassage("thành công");
        respo.setData(e);

        return respo;
    }

    @Override
    public ResponseDto updateEvidence(Evidence evidence) {
        ResponseDto respo = new ResponseDto();
        String message = "Id không tồn tại!";
        if (evidenceRepo.findById(evidence.getId()).equals(null)) {
            respo.setCode("error");
            respo.setMassage(message);
            return respo;

        }
        evidence.setNumber(evidence.getNumber());
        evidence.setItemName(evidence.getItemName());
        evidence.setNotes(evidence.getNotes());
        evidence.setArchived(evidence.getArchived());
        respo.setCode("successfully");
        respo.setMassage("thành công!");
        respo.setData(evidenceRepo.save(evidence));

        return respo;
    }

    @Override
    public void deleteEvidenceById(Long Id) {
        evidenceRepo.deleteById(Id);
    }

    @Override
    public List<Evidence> findByEvidencesType(CaseType type) {
        List<CriminalCase> listCriminal = criminalCaseRepo.findByType(type);
        List<Evidence> listEvi1 = new ArrayList<>();
        for (CriminalCase criminalCase : listCriminal) {
            List<Evidence> listEvi = evidenceRepo.findByCriminalCase(criminalCase);
            listEvi1.addAll(listEvi);
        }
        return listEvi1;
    }
}
