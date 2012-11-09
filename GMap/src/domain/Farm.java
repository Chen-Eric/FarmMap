package domain;
// default package

/**
 * Farm entity. @author MyEclipse Persistence Tools
 */

public class Farm implements java.io.Serializable {

	// Fields

	private Short FId;
	private String FName;
	private String FDescription;

	// Constructors

	/** default constructor */
	public Farm() {
	}

	/** minimal constructor */
	public Farm(String FName) {
		this.FName = FName;
	}

	/** full constructor */
	public Farm(String FName, String FDescription) {
		this.FName = FName;
		this.FDescription = FDescription;
	}

	// Property accessors

	public Short getFId() {
		return this.FId;
	}

	public void setFId(Short FId) {
		this.FId = FId;
	}

	public String getFName() {
		return this.FName;
	}

	public void setFName(String FName) {
		this.FName = FName;
	}

	public String getFDescription() {
		return this.FDescription;
	}

	public void setFDescription(String FDescription) {
		this.FDescription = FDescription;
	}

}