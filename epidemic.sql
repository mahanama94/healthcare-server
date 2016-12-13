CREATE TABLE district(
  district_id int NOT NULL AUTO_INCREMENT,
  district_name VARCHAR(20) NOT NULL,
  PRIMARY KEY(district_id),
  UNIQUE (district_name)
);
CREATE TABLE province(
  province_id int NOT NULL AUTO_INCREMENT,
  province_name VARCHAR(20) NOT NULL,
  PRIMARY KEY(province_id),
  UNIQUE (province_name)
);
CREATE TABLE disease(
  disease_id int NOT NULL AUTO_INCREMENT,
  disease_name VARCHAR(10) NOT NULL,
  description VARCHAR(20) NOT NULL,
  treatment VARCHAR(20) NOT NULL,
  PRIMARY KEY(disease_id),
  UNIQUE (disease_name)
);
CREATE TABLE patient(
  patient_id int NOT NULL AUTO_INCREMENT,
  nic VARCHAR(10),
  NAME VARCHAR(20),
  dob DATE,
  district_id int,
  PRIMARY KEY(patient_id),
  FOREIGN KEY(district_id) REFERENCES district(district_id) ON DELETE SET NULL,
  UNIQUE (nic)
);
CREATE TABLE medical_officer(
  med_officer_id int NOT NULL AUTO_INCREMENT,
  nic VARCHAR(10) NOT NULL,
  NAME VARCHAR(20) NOT NULL,
  dob DATE NOT NULL,
  district_id int,
  specialization VARCHAR(10) NOT NULL,
  PRIMARY KEY(med_officer_id),
  FOREIGN KEY(district_id) REFERENCES district(district_id) ON DELETE SET NULL,
  UNIQUE (nic)
);
CREATE TABLE health_officer(
  health_officer_id int NOT NULL AUTO_INCREMENT,
  nic VARCHAR(10) NOT NULL,
  NAME VARCHAR(20) NOT NULL,
  dob DATE NOT NULL,
  province_id int,
  specialization VARCHAR(10) NOT NULL,
  PRIMARY KEY(health_officer_id),
  FOREIGN KEY(province_id) REFERENCES province(province_id) ON DELETE SET NULL,
  UNIQUE (nic)
);
CREATE TABLE med_report(
  report_date DATE NOT NULL,
  patient_id int NOT NULL,
  disease_id int NOT NULL,
  med_officer_id int NOT NULL,
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
  med_officer_id int NOT NULL,
  health_officer_id int NOT NULL,
  PRIMARY KEY(
    med_officer_id
  ),
  FOREIGN KEY(med_officer_id) REFERENCES medical_officer(med_officer_id) ON DELETE CASCADE,
  FOREIGN KEY(health_officer_id) REFERENCES health_officer(health_officer_id) ON DELETE CASCADE
);


CREATE FUNCTION `get_age`(
  `date_of_birth` DATE,
  `current_time` DATETIME
) RETURNS INT(11) UNSIGNED COMMENT 'Age Calculation' DETERMINISTIC NO SQL SQL SECURITY DEFINER RETURN(
  (
    YEAR(CURRENT_TIME) - YEAR(date_of_birth)
  ) -(
    (
      DATE_FORMAT(CURRENT_TIME, '00-%m-%d') < DATE_FORMAT(date_of_birth, '00-%m-%d')
    )
  )
);



/*

To use the get_age function:

SELECT get_age(date_of_birth, NOW()) AS age FROM person WHERE patient_id = 1


To add a insert to a auto increment table:

INSERT INTO disease VALUES(NULL,'desease1','discription1','treatment1');

*/