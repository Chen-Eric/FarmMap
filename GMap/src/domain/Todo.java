package domain;

import java.util.Date;

/**
 * Todo entity. @author MyEclipse Persistence Tools
 */

public class Todo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1462412136292053369L;
	private Short TId;
	private Short paddockPId;
	private Short paddockFarmFId;
	private Date TDateEntered;
	private Date TDateDue;
	private String TDescription;
	private boolean TDone;

	// Constructors

	/** default constructor */
	public Todo() {
	}

	/** minimal constructor */
	public Todo(Short paddockPId, Short paddockFarmFId, Date TDateEntered, boolean TDone) {
		this.paddockPId = paddockPId;
		this.paddockFarmFId = paddockFarmFId;
		this.TDateEntered = TDateEntered;
		this.TDone = TDone;
	}

	/** full constructor */
	public Todo(Short paddockPId, Short paddockFarmFId, Date TDateEntered,
			Date TDateDue, String TDescription, boolean TDone) {
		this.paddockPId = paddockPId;
		this.paddockFarmFId = paddockFarmFId;
		this.TDateEntered = TDateEntered;
		this.TDateDue = TDateDue;
		this.TDescription = TDescription;
		this.TDone = TDone;
	}

	// Property accessors

	public Short getTId() {
		return this.TId;
	}

	public void setTId(Short TId) {
		this.TId = TId;
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

	public Date getTDateEntered() {
		return this.TDateEntered;
	}

	public void setTDateEntered(Date TDateEntered) {
		this.TDateEntered = TDateEntered;
	}

	public Date getTDateDue() {
		return this.TDateDue;
	}

	public void setTDateDue(Date TDateDue) {
		this.TDateDue = TDateDue;
	}

	public String getTDescription() {
		return this.TDescription;
	}

	public void setTDescription(String TDescription) {
		this.TDescription = TDescription;
	}

	public boolean getTDone() {
		return TDone;
	}

	public void setTDone(boolean tDone) {
		TDone = tDone;
	}

}