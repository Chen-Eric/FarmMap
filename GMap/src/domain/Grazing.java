package domain;

import java.util.Date;

/**
 * Grazing entity. @author MyEclipse Persistence Tools
 */

public class Grazing implements java.io.Serializable {

	// Fields

	private Integer GId;
	private Short paddockPId;
	private Short paddockFarmFId;
	private Date GDateIn;
	private Date GDateOut;
	private String GNote;

	// Constructors

	/** default constructor */
	public Grazing() {
	}

	/** minimal constructor */
	public Grazing(Short paddockPId, Short paddockFarmFId, Date GDateIn) {
		this.paddockPId = paddockPId;
		this.paddockFarmFId = paddockFarmFId;
		this.GDateIn = GDateIn;
	}

	/** full constructor */
	public Grazing(Short paddockPId, Short paddockFarmFId, Date GDateIn,
			Date GDateOut, String GNote) {
		this.paddockPId = paddockPId;
		this.paddockFarmFId = paddockFarmFId;
		this.GDateIn = GDateIn;
		this.GDateOut = GDateOut;
		this.GNote = GNote;
	}

	// Property accessors

	public Integer getGId() {
		return this.GId;
	}

	public void setGId(Integer GId) {
		this.GId = GId;
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

	public Date getGDateIn() {
		return this.GDateIn;
	}

	public void setGDateIn(Date GDateIn) {
		this.GDateIn = GDateIn;
	}

	public Date getGDateOut() {
		return this.GDateOut;
	}

	public void setGDateOut(Date GDateOut) {
		this.GDateOut = GDateOut;
	}

	public String getGNote() {
		return this.GNote;
	}

	public void setGNote(String GNote) {
		this.GNote = GNote;
	}

}