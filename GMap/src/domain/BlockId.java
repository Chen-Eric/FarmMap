package domain;
// default package

/**
 * BlockId entity. @author MyEclipse Persistence Tools
 */

public class BlockId implements java.io.Serializable {

	// Fields

	private Short BId;
	private Short farmFId;

	// Constructors

	/** default constructor */
	public BlockId() {
	}

	/** full constructor */
	public BlockId(Short BId, Short farmFId) {
		this.BId = BId;
		this.farmFId = farmFId;
	}

	// Property accessors

	public Short getBId() {
		return this.BId;
	}

	public void setBId(Short BId) {
		this.BId = BId;
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
		if (!(other instanceof BlockId))
			return false;
		BlockId castOther = (BlockId) other;

		return ((this.getBId() == castOther.getBId()) || (this.getBId() != null
				&& castOther.getBId() != null && this.getBId().equals(
				castOther.getBId())))
				&& ((this.getFarmFId() == castOther.getFarmFId()) || (this
						.getFarmFId() != null && castOther.getFarmFId() != null && this
						.getFarmFId().equals(castOther.getFarmFId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getBId() == null ? 0 : this.getBId().hashCode());
		result = 37 * result
				+ (getFarmFId() == null ? 0 : this.getFarmFId().hashCode());
		return result;
	}

}