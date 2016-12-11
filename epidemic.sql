CREATE TABLE district(
  district_id VARCHAR(5),
  district_name VARCHAR(20) NOT NULL,
  PRIMARY KEY(district_id)
);
CREATE TABLE province(
  province_id VARCHAR(5),
  province_name VARCHAR(20) NOT NULL,
  PRIMARY KEY(province_id)
);
CREATE TABLE disease(
  disease_id VARCHAR(5),
  disease_name VARCHAR(10),
  description VARCHAR(20),
  treatment VARCHAR(20),
  PRIMARY KEY(disease_id)
);
CREATE TABLE patient(
  patient_id VARCHAR(5),
  nic VARCHAR(10),
  NAME VARCHAR(20),
  dob DATE,
  district_id VARCHAR(5),
  PRIMARY KEY(patient_id),
  FOREIGN KEY(district_id) REFERENCES district(district_id) ON DELETE SET NULL
);
CREATE TABLE medical_officer(
  med_officer_id VARCHAR(5),
  nic VARCHAR(10),
  NAME VARCHAR(20),
  dob DATE,
  district_id VARCHAR(5),
  specialization VARCHAR(10),
  PRIMARY KEY(med_officer_id),
  FOREIGN KEY(district_id) REFERENCES district(district_id) ON DELETE SET NULL
);
CREATE TABLE health_officer(
  health_officer_id VARCHAR(5),
  nic VARCHAR(10),
  NAME VARCHAR(20),
  dob DATE,
  province_id VARCHAR(5),
  specialization VARCHAR(10),
  PRIMARY KEY(health_officer_id),
  FOREIGN KEY(province_id) REFERENCES province(province_id) ON DELETE SET NULL
);
CREATE TABLE med_report(
  report_date DATE NOT NULL,
  patient_id VARCHAR(5) NOT NULL,
  disease_id VARCHAR(5) NOT NULL,
  med_officer_id VARCHAR(5) NOT NULL,
  PRIMARY KEY(
    patient_id,
    disease_id,
    med_officer_id
  ),
  FOREIGN KEY(patient_id) REFERENCES patient(patient_id) ON DELETE CASCADE,
  FOREIGN KEY(disease_id) REFERENCES disease(disease_id) ON DELETE CASCADE,
  FOREIGN KEY(med_officer_id) REFERENCES medical_officer(med_officer_id) ON DELETE CASCADE
);
CREATE TABLE med_officer_assign(
  med_officer_id VARCHAR(5),
  health_officer_id VARCHAR(5),
  PRIMARY KEY(
    med_officer_id,
    health_officer_id
  ),
  FOREIGN KEY(med_officer_id) REFERENCES medical_officer(med_officer_id) ON DELETE CASCADE,
  FOREIGN KEY(health_officer_id) REFERENCES health_officer(health_officer_id) ON DELETE CASCADE
);
