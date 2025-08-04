package model;

public class Bill {
    private int id;
    private int patientId;
    private double amount;
    private String status;

    public Bill() {}

	public Bill(int id, int patientId, double amount, String status) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.amount = amount;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
