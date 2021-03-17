package employeeApp_JPA.entities;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "sid")
//@DiscriminatorValue(value = "NTS")
public class NonTeachingStaff extends Staff {
	
	@Basic
	private String areaExpertise;
	
	
	//constructors
	public NonTeachingStaff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NonTeachingStaff(int sid, String sname, String areaExpertise) {
		super(sid, sname);
		this.areaExpertise = areaExpertise;
	}
	
	//getters and setters
	public String getAreaExpertise() {
		return areaExpertise;
	}
	public void setAreaExpertise(String areaExpertise) {
		this.areaExpertise = areaExpertise;
	}
	
	@Override
	public String toString() {
		return "NonTeachingStaff [areaExpertise=" + areaExpertise + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((areaExpertise == null) ? 0 : areaExpertise.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		NonTeachingStaff other = (NonTeachingStaff) obj;
		if (areaExpertise == null) {
			if (other.areaExpertise != null)
				return false;
		} else if (!areaExpertise.equals(other.areaExpertise))
			return false;
		return true;
	}
	
	
}//public class NonTeachingStaff
