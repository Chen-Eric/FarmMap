package domain;

/**
 * Paddock entity. @author MyEclipse Persistence Tools
 */

public class Paddock implements java.io.Serializable {

	// Fields

	private PaddockId id;
	private Short blockBId;
	private Short blockFarmFId;
	private String PName;
	private Double PCenterLat;
	private Double PCenterLon;
	private String PDescription;
	private Short PFeedCapacity;

	// Constructors

	/** default constructor */
	public Paddock() {
	}

	/** minimal constructor */
	public Paddock(PaddockId id, String PName) {
		this.id = id;
		this.PName = PName;
	}

	/** full constructor */
	public Paddock(PaddockId id, Short blockBId, Short blockFarmFId,
			String PName, Double PCenterLat, Double PCenterLon,
			String PDescription, Short PFeedCapacity) {
		this.id = id;
		this.blockBId = blockBId;
		this.blockFarmFId = blockFarmFId;
		this.PName = PName;
		this.PCenterLat = PCenterLat;
		this.PCenterLon = PCenterLon;
		this.PDescription = PDescription;
		this.PFeedCapacity = PFeedCapacity;
	}

	// Property accessors

	public PaddockId getId() {
		return this.id;
	}

	public void setId(PaddockId id) {
		this.id = id;
	}

	public Short getBlockBId() {
		return this.blockBId;
	}

	public void setBlockBId(Short blockBId) {
		this.blockBId = blockBId;
	}

	public Short getBlockFarmFId() {
		return this.blockFarmFId;
	}

	public void setBlockFarmFId(Short blockFarmFId) {
		this.blockFarmFId = blockFarmFId;
	}

	public String getPName() {
		return this.PName;
	}

	public void setPName(String PName) {
		this.PName = PName;
	}

	public Double getPCenterLat() {
		return this.PCenterLat;
	}

	public void setPCenterLat(Double PCenterLat) {
		this.PCenterLat = PCenterLat;
	}

	public Double getPCenterLon() {
		return this.PCenterLon;
	}

	public void setPCenterLon(Double PCenterLon) {
		this.PCenterLon = PCenterLon;
	}

	public String getPDescription() {
		return this.PDescription;
	}

	public void setPDescription(String PDescription) {
		this.PDescription = PDescription;
	}

	public Short getPFeedCapacity() {
		return this.PFeedCapacity;
	}

	public void setPFeedCapacity(Short PFeedCapacity) {
		this.PFeedCapacity = PFeedCapacity;
	}

}