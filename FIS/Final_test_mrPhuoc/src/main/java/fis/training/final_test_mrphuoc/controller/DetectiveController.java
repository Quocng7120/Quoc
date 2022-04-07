package fis.training.final_test_mrphuoc.controller;

import fis.training.final_test_mrphuoc.entity.Detective;
import fis.training.final_test_mrphuoc.form.CriminalCaseFormForUpdate;
import fis.training.final_test_mrphuoc.form.DetectiveFormForUpdate;
import fis.training.final_test_mrphuoc.service.DetectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detective")
public class DetectiveController {

    @Autowired
    DetectiveService detectiveService;

    @GetMapping()
    public ResponseEntity<?> getAllDetective() {
        return new ResponseEntity<>(detectiveService.getAllDetective(), HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> add(@RequestBody Detective detective){

            return  ResponseEntity.ok(detectiveService.addDetective(detective));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateDetective(@PathVariable(name = "id") Long id, @RequestBody DetectiveFormForUpdate form) {
        detectiveService.updateDetective(id, form);
        return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id){
        detectiveService.deleteDetective(id);
        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);

    }
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> findById(@PathVariable Long id){

        try {
            return ResponseEntity.ok(detectiveService.findDetectiveById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.ok("tim kiem that bai");
        }

    }
}
