package model;
import java.sql.Timestamp;

public class Appointment {
    private int id, patientId, staffId;
    private Timestamp dateTime;
    private String status;

    public Appointment() {}

	public Appointment(int id, int patientId, int staffId, Timestamp dateTime, String status) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.staffId = staffId;
		this.dateTime = dateTime;
		this.status = status;
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

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
