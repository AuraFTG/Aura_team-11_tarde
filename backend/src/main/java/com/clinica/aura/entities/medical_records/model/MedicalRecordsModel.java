package com.clinica.aura.entities.medical_records.model;

import com.clinica.aura.entities.patient.model.PatientModel;
import com.clinica.aura.entities.person.model.PersonModel;
import com.clinica.aura.entities.professional.model.ProfessionalModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "medical_records")
public class MedicalRecordsModel {
    //historia clinicas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = PatientModel.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientModel patients;

    @OneToOne(targetEntity = ProfessionalModel.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "professional_id", nullable = false)
    private ProfessionalModel professional;

    private String notes;

    private String allergies;

    private String previousConditions;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;
}
