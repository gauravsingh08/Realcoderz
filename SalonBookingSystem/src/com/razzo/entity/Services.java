package com.razzo.entity;

public class Services {

	private int serviceId;
	private String serviceName;
	private String serviceDescription;
	private float servicePrice;

	public Services() {

	}

	public Services(int serviceId, String serviceName, String serviceDescription, float servicePrice) {
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceDescription = serviceDescription;
		this.servicePrice = servicePrice;
	}

	public Services(String serviceName, String serviceDescription, float servicePrice) {
		this.serviceName = serviceName;
		this.serviceDescription = serviceDescription;
		this.servicePrice = servicePrice;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public float getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(float servicePrice) {
		this.servicePrice = servicePrice;
	}

	@Override
	public String toString() {
		return "Services [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceDescription="
				+ serviceDescription + ", servicePrice=" + servicePrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serviceDescription == null) ? 0 : serviceDescription.hashCode());
		result = prime * result + serviceId;
		result = prime * result + ((serviceName == null) ? 0 : serviceName.hashCode());
		result = prime * result + Float.floatToIntBits(servicePrice);
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
		Services other = (Services) obj;
		if (serviceDescription == null) {
			if (other.serviceDescription != null)
				return false;
		} else if (!serviceDescription.equals(other.serviceDescription))
			return false;
		if (serviceId != other.serviceId)
			return false;
		if (serviceName == null) {
			if (other.serviceName != null)
				return false;
		} else if (!serviceName.equals(other.serviceName))
			return false;
		if (Float.floatToIntBits(servicePrice) != Float.floatToIntBits(other.servicePrice))
			return false;
		return true;
	}

}
