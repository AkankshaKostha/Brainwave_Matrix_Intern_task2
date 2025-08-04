package model;

import java.util.Date;

public class EHR {
    private int id;      
    private int patientId;
    private String diagnosis;
    private String treatment;
    private String doctorName;
    private Date date;
    private String notes;
	public EHR(int id, String diagnosis, String treatment, String doctorName, Date date, String notes) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.doctorName = doctorName;
		this.date = date;
		this.notes = notes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
    
    

}
