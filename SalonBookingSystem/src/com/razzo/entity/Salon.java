package com.razzo.entity;

public class Salon {

	private int salonId;
	private String salonName;
	private String salonAddress;
	private float salonRating;

	public Salon() {
	}

	public Salon(int salonId, String salonName, String salonAddress, float salonRating) {
		super();
		this.salonId = salonId;
		this.salonName = salonName;
		this.salonAddress = salonAddress;
		this.salonRating = salonRating;
	}

	public Salon(String salonName, String salonAddress, float salonRating) {
		super();
		this.salonName = salonName;
		this.salonAddress = salonAddress;
		this.salonRating = salonRating;
	}

	public int getSalonId() {
		return salonId;
	}

	public void setSalonId(int salonId) {
		this.salonId = salonId;
	}

	public String getSalonName() {
		return salonName;
	}

	public void setSalonName(String salonName) {
		this.salonName = salonName;
	}

	public String getSalonAddress() {
		return salonAddress;
	}

	public void setSalonAddress(String salonAddress) {
		this.salonAddress = salonAddress;
	}

	public float getSalonRating() {
		return salonRating;
	}

	public void setSalonRating(float salonRating) {
		this.salonRating = salonRating;
	}

	@Override
	public String toString() {
		return "Salon [salonId=" + salonId + ", salonName=" + salonName + ", salonAddress=" + salonAddress
				+ ", salonRating=" + salonRating + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((salonAddress == null) ? 0 : salonAddress.hashCode());
		result = prime * result + salonId;
		result = prime * result + ((salonName == null) ? 0 : salonName.hashCode());
		result = prime * result + Float.floatToIntBits(salonRating);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salon other = (Salon) obj;
		if (salonAddress == null) {
			if (other.salonAddress != null)
				return false;
		} else if (!salonAddress.equals(other.salonAddress))
			return false;
		if (salonId != other.salonId)
			return false;
		if (salonName == null) {
			if (other.salonName != null)
				return false;
		} else if (!salonName.equals(other.salonName))
			return false;
		if (Float.floatToIntBits(salonRating) != Float.floatToIntBits(other.salonRating))
			return false;
		return true;
	}

}
