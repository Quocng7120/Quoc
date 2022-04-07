package fis.training.final_test_mrphuoc.service;

import fis.training.final_test_mrphuoc.dto.ResponseDto;
import fis.training.final_test_mrphuoc.entity.CaseType;
import fis.training.final_test_mrphuoc.entity.Evidence;
import fis.training.final_test_mrphuoc.form.EvidenceFormForCreate;

import java.util.List;

public interface EvidenceService {
    Evidence getEvidenceById(Long Id);

    ResponseDto createEvidence(Evidence evidence);

    ResponseDto updateEvidence(Evidence evidence);

    void deleteEvidenceById(Long Id);

    List<Evidence> findByEvidencesType(CaseType type);

}
