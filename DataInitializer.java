package com.example.hospital.config;

import com.example.hospital.entity.*;
import com.example.hospital.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

/** Seeds demo users and sample data on first start. */
@Component
public class DataInitializer implements CommandLineRunner {

    private final AppUserRepository users;
    private final PatientRepository patients;
    private final DoctorRepository doctors;
    private final AppointmentRepository appointments;
    private final PasswordEncoder encoder;

    public DataInitializer(AppUserRepository users, PatientRepository patients, DoctorRepository doctors,
                           AppointmentRepository appointments, PasswordEncoder encoder) {
        this.users = users;
        this.patients = patients;
        this.doctors = doctors;
        this.appointments = appointments;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) {
        if (users.count() == 0) {
            users.save(new AppUser("admin", encoder.encode("admin123"), Role.ADMIN));
            users.save(new AppUser("staff", encoder.encode("staff123"), Role.STAFF));
        }
        if (doctors.count() == 0 && patients.count() == 0) {
            Doctor d1 = doctors.save(new Doctor("Dr. Meera Sharma", "Cardiology", "meera.sharma@hospital.test"));
            doctors.save(new Doctor("Dr. Arjun Verma", "Neurology", "arjun.verma@hospital.test"));
            doctors.save(new Doctor("Dr. Priya Nair", "Pediatrics", "priya.nair@hospital.test"));
            Patient p1 = patients.save(new Patient("Asha", "Rawat", "asha.rawat@example.com", "9876543210", LocalDate.of(1994, 5, 12)));
            patients.save(new Patient("Rohan", "Mehta", "rohan.mehta@example.com", "9123456780", LocalDate.of(1988, 11, 3)));
            LocalDateTime tomorrow = LocalDateTime.now().plusDays(1).withHour(10).withMinute(0).withSecond(0).withNano(0);
            appointments.save(new Appointment(p1, d1, tomorrow, "Routine heart check-up", AppointmentStatus.SCHEDULED));
        }
    }
}
