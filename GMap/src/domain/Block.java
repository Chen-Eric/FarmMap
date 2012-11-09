package domain;
// default package

/**
 * Block entity. @author MyEclipse Persistence Tools
 */

public class Block implements java.io.Serializable {

	// Fields

	private BlockId id;
	private String BName;
	private String BType;
	private String BDescription;
	private String BData;

	// Constructors

	/** default constructor */
	public Block() {
	}

	/** minimal constructor */
	public Block(BlockId id, String BName, String BType) {
		this.id = id;
		this.BName = BName;
		this.BType = BType;
	}

	/** full constructor */
	public Block(BlockId id, String BName, String BType, String BDescription,
			String BData) {
		this.id = id;
		this.BName = BName;
		this.BType = BType;
		this.BDescription = BDescription;
		this.BData = BData;
	}

	// Property accessors

	public BlockId getId() {
		return this.id;
	}

	public void setId(BlockId id) {
		this.id = id;
	}

	public String getBName() {
		return this.BName;
	}

	public void setBName(String BName) {
		this.BName = BName;
	}

	public String getBType() {
		return this.BType;
	}

	public void setBType(String BType) {
		this.BType = BType;
	}

	public String getBDescription() {
		return this.BDescription;
	}

	public void setBDescription(String BDescription) {
		this.BDescription = BDescription;
	}

	public String getBData() {
		return this.BData;
	}

	public void setBData(String BData) {
		this.BData = BData;
	}

}