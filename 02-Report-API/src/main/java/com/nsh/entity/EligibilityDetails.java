package com.nsh.entity;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data 
@Table(name="ELIGIBILITY_DETAILS")
public class EligibilityDetails {
	
	@Id
	private Integer eligId;
	private String name;
	private  Long mobileNo;
	private String emailId;
	private Character gender;
	private Long ssn;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate ;
	private LocalDate createDate ;
	private LocalDate updateDate ;
	private String createdBy;
	private String updatedBy ;

}
