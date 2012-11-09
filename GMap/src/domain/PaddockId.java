package domain;

/**
 * PaddockId entity. @author MyEclipse Persistence Tools
 */

public class PaddockId implements java.io.Serializable {

	// Fields

	private Short PId;
	private Short farmFId;

	// Constructors

	/** default constructor */
	public PaddockId() {
	}

	/** full constructor */
	public PaddockId(Short PId, Short farmFId) {
		this.PId = PId;
		this.farmFId = farmFId;
	}

	// Property accessors

	public Short getPId() {
		return this.PId;
	}

	public void setPId(Short PId) {
		this.PId = PId;
	}

	public Short getFarmFId() {
		return this.farmFId;
	}

	public void setFarmFId(Short farmFId) {
		this.farmFId = farmFId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PaddockId))
			return false;
		PaddockId castOther = (PaddockId) other;

		return ((this.getPId() == castOther.getPId()) || (this.getPId() != null
				&& castOther.getPId() != null && this.getPId().equals(
				castOther.getPId())))
				&& ((this.getFarmFId() == castOther.getFarmFId()) || (this
						.getFarmFId() != null && castOther.getFarmFId() != null && this
						.getFarmFId().equals(castOther.getFarmFId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPId() == null ? 0 : this.getPId().hashCode());
		result = 37 * result
				+ (getFarmFId() == null ? 0 : this.getFarmFId().hashCode());
		return result;
	}

}