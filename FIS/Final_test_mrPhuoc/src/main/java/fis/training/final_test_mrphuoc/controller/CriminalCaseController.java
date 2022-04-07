package fis.training.final_test_mrphuoc.controller;

import fis.training.final_test_mrphuoc.entity.CriminalCase;
import fis.training.final_test_mrphuoc.form.CriminalCaseFormForUpdate;
import fis.training.final_test_mrphuoc.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/criminalCase")
public class CriminalCaseController {

    @Autowired
    CriminalCaseService criminalCaseService;

    @GetMapping()
    public ResponseEntity<?> getAllCriminalCase() {
        return new ResponseEntity<>(criminalCaseService.getAllCriminalCase(), HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> add(@RequestBody CriminalCase criminalCase){
        return ResponseEntity.ok(criminalCaseService.addCriminalCase(criminalCase));
//        try {
//            return  ResponseEntity.ok(criminalCaseService.add(criminalCase));
//        } catch (AppException e) {
//            return ResponseEntity.ok(new ExceptionDTO(e.getTimestamp(), e.getMessage(),e.getCode()));
//        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateCriminalCase(@PathVariable(name = "id") Long id, @RequestBody CriminalCaseFormForUpdate form) {
        criminalCaseService.updateCriminalCase(id, form);
        return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id){
        criminalCaseService.deleteCriminalCase(id);
        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);

    }
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> findById(@PathVariable Long id){

        try {
            return ResponseEntity.ok(criminalCaseService.findCriminalCaseById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.ok("tim kiem that bai");
        }

    }
}
