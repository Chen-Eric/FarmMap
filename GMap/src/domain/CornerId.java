package domain;
// default package

/**
 * CornerId entity. @author MyEclipse Persistence Tools
 */

public class CornerId implements java.io.Serializable {

	// Fields

	private Integer CId;
	private Short paddockPId;
	private Short paddockFarmFId;

	// Constructors

	/** default constructor */
	public CornerId() {
	}

	/** full constructor */
	public CornerId(Integer CId, Short paddockPId, Short paddockFarmFId) {
		this.CId = CId;
		this.paddockPId = paddockPId;
		this.paddockFarmFId = paddockFarmFId;
	}

	// Property accessors

	public Integer getCId() {
		return this.CId;
	}

	public void setCId(Integer CId) {
		this.CId = CId;
	}

	public Short getPaddockPId() {
		return this.paddockPId;
	}

	public void setPaddockPId(Short paddockPId) {
		this.paddockPId = paddockPId;
	}

	public Short getPaddockFarmFId() {
		return this.paddockFarmFId;
	}

	public void setPaddockFarmFId(Short paddockFarmFId) {
		this.paddockFarmFId = paddockFarmFId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CornerId))
			return false;
		CornerId castOther = (CornerId) other;

		return ((this.getCId() == castOther.getCId()) || (this.getCId() != null
				&& castOther.getCId() != null && this.getCId().equals(
				castOther.getCId())))
				&& ((this.getPaddockPId() == castOther.getPaddockPId()) || (this
						.getPaddockPId() != null
						&& castOther.getPaddockPId() != null && this
						.getPaddockPId().equals(castOther.getPaddockPId())))
				&& ((this.getPaddockFarmFId() == castOther.getPaddockFarmFId()) || (this
						.getPaddockFarmFId() != null
						&& castOther.getPaddockFarmFId() != null && this
						.getPaddockFarmFId().equals(
								castOther.getPaddockFarmFId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCId() == null ? 0 : this.getCId().hashCode());
		result = 37
				* result
				+ (getPaddockPId() == null ? 0 : this.getPaddockPId()
						.hashCode());
		result = 37
				* result
				+ (getPaddockFarmFId() == null ? 0 : this.getPaddockFarmFId()
						.hashCode());
		return result;
	}

}