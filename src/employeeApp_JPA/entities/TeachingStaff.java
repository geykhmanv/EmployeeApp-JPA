package employeeApp_JPA.entities;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "sid")
//@DiscriminatorValue(value = "TS")
public class TeachingStaff extends Staff {
	
	@Basic
	private String qualification;
	@Basic
	private String subjectExpertise;
	
	//constructors
	public TeachingStaff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TeachingStaff(int sid, String sname, String qualification, String subjectExpertise) {
		super(sid, sname);
		this.qualification = qualification;
		this.subjectExpertise = subjectExpertise;
	}
	
	//getters and setters
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSubjectExpertise() {
		return subjectExpertise;
	}
	public void setSubjectExpertise(String subjectExpertise) {
		this.subjectExpertise = subjectExpertise;
	}
	
	@Override
	public String toString() {
		return "TeachingStaff [qualification=" + qualification + ", subjectExpertise=" + subjectExpertise + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((qualification == null) ? 0 : qualification.hashCode());
		result = prime * result + ((subjectExpertise == null) ? 0 : subjectExpertise.hashCode());
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
		TeachingStaff other = (TeachingStaff) obj;
		if (qualification == null) {
			if (other.qualification != null)
				return false;
		} else if (!qualification.equals(other.qualification))
			return false;
		if (subjectExpertise == null) {
			if (other.subjectExpertise != null)
				return false;
		} else if (!subjectExpertise.equals(other.subjectExpertise))
			return false;
		return true;
	}
	
	

}//public class TeachingStaff 
