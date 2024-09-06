package com.rupp.finalprojectlms.features.enrollment;




import com.rupp.finalprojectlms.domain.Enrollment;
import com.rupp.finalprojectlms.features.enrollment.dto.CreateEnrollment;
import com.rupp.finalprojectlms.features.enrollment.dto.EnrollmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;



    @GetMapping
    public ResponseEntity<List<EnrollmentResponse>> getAllEnrollments() {
        List<EnrollmentResponse> enrollments = enrollmentService.getAllEnrollments();
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentResponse> getEnrollmentById(@PathVariable Long id) {
        EnrollmentResponse enrollmentResponse = enrollmentService.getEnrollmentById(id);
        return ResponseEntity.ok(enrollmentResponse);
    }

    @PostMapping
    public ResponseEntity<EnrollmentResponse> createEnrollment(@RequestBody CreateEnrollment createEnrollment) {
        EnrollmentResponse enrollmentResponse = enrollmentService.createEnrollment(createEnrollment);
        return new ResponseEntity<>(enrollmentResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentResponse> updateEnrollment(@PathVariable Long id, @RequestBody CreateEnrollment createEnrollment) {
        EnrollmentResponse enrollmentResponse = enrollmentService.updateEnrollment(id, createEnrollment);
        return ResponseEntity.ok(enrollmentResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }
}

