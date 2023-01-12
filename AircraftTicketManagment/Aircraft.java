package Calculators;




import java.util.Scanner;

class Aircraft {
	protected String aircraftName;
	protected String source;
	protected String destination;

	public Aircraft(String aircraftName, String source, String destination) {
		this.aircraftName = aircraftName;
		this.source = source;
		this.destination = destination;
	}

	void displayDetails() {
		System.out.println("the Aircraft name is " + aircraftName);
		System.out.println("the source name is " + source);
		System.out.println("the destination name is " + destination);
	}

}

class PublicAircraft extends Aircraft {
	private boolean checkinbeforetwohours;
	private int noOfKgsallowed;
	private float additionalFeeperkg;

	public PublicAircraft(String aircraftName, String source, String destination, boolean checkinbeforetwohours,
			int noOfKgsallowed, float additionalFeeperkg) {
		super(aircraftName, source, destination);
		this.checkinbeforetwohours = checkinbeforetwohours;
		this.noOfKgsallowed = noOfKgsallowed;
		this.additionalFeeperkg = additionalFeeperkg;
	}

	public boolean isCheckinbeforetwohours() {
		return checkinbeforetwohours;
	}

	public void setCheckinbeforetwohours(boolean checkinbeforetwohours) {
		this.checkinbeforetwohours = checkinbeforetwohours;
	}

	public int getNoOfKgsallowed() {
		return noOfKgsallowed;
	}

	public void setNoOfKgsallowed(int noOfKgsallowed) {
		this.noOfKgsallowed = noOfKgsallowed;
	}

	public float getAdditionalFeeperkg() {
		return additionalFeeperkg;
	}

	public void setAdditionalFeeperkg(float additionalFeeperkg) {
		this.additionalFeeperkg = additionalFeeperkg;
	}

	void displayDetails() {
		super.displayDetails();
		System.out.println("checkinbeforetwohours is " + checkinbeforetwohours);
		System.out.println("noOfKgsallowed is " + noOfKgsallowed);
		System.out.println("additionalFeeperkg is " + additionalFeeperkg);

	}

}

class PrivateAircraft extends Aircraft {

	private boolean checkinbeforetwohours;
	private String pilotPreference;
	private String purpose;

	public PrivateAircraft(String aircraftName, String source, String destination, boolean checkinbeforetwohours,
			String pilotPreference, String purpose) {
		super(aircraftName, source, destination);
		this.checkinbeforetwohours = checkinbeforetwohours;
		this.pilotPreference = pilotPreference;
		this.purpose = purpose;
	}

	public boolean isCheckinbeforetwohours() {
		return checkinbeforetwohours;
	}

	public void setCheckinbeforetwohours(boolean checkinbeforetwohours) {
		this.checkinbeforetwohours = checkinbeforetwohours;
	}

	public String getPilotPreference() {
		return pilotPreference;
	}

	public void setPilotPreference(String pilotPreference) {
		this.pilotPreference = pilotPreference;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	void displayDetails() {
		System.out.println("checkin before two hours " + checkinbeforetwohours);
		System.out.println("pilot preference " + pilotPreference);
		System.out.println("purpose " + purpose);
	}

}

