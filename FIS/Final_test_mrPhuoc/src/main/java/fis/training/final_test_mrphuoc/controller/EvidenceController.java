package fis.training.final_test_mrphuoc.controller;

import fis.training.final_test_mrphuoc.entity.Evidence;
import fis.training.final_test_mrphuoc.service.EvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/evidence")
@Validated
public class EvidenceController {

    @Autowired
    private EvidenceService evidenceService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getEvidenceByID(@PathVariable(name = "id") Long id) {

        return new ResponseEntity<Evidence>(evidenceService.getEvidenceById(id), HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<?> createEvidence(@RequestBody Evidence evidence) {

        return ResponseEntity.ok(evidenceService.createEvidence(evidence));
    }

    @PutMapping()
    public ResponseEntity<?> updateEvidence(@RequestBody Evidence evidence) {

        return ResponseEntity.ok(evidenceService.updateEvidence(evidence));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteEvidence(@PathVariable(name = "id") Long id) {

        evidenceService.deleteEvidenceById(id);
        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
    }
}
