package common;

public class TodoFormatter implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9211685865937045356L;
	private Short TId;
	private Short paddockPId;
	private Short paddockFarmFId;
	private String TDateEntered;
	private String TDateDue;
	private String TDescription;
	private boolean TDone;

	// Constructors

	public Short getTId() {
		return TId;
	}

	public void setTId(Short tId) {
		TId = tId;
	}

	public Short getPaddockPId() {
		return paddockPId;
	}

	public void setPaddockPId(Short paddockPId) {
		this.paddockPId = paddockPId;
	}

	public Short getPaddockFarmFId() {
		return paddockFarmFId;
	}

	public void setPaddockFarmFId(Short paddockFarmFId) {
		this.paddockFarmFId = paddockFarmFId;
	}

	public String getTDateEntered() {
		return TDateEntered;
	}

	public void setTDateEntered(String tDateEntered) {
		TDateEntered = tDateEntered;
	}

	public String getTDateDue() {
		return TDateDue;
	}

	public void setTDateDue(String tDateDue) {
		TDateDue = tDateDue;
	}

	public String getTDescription() {
		return TDescription;
	}

	public void setTDescription(String tDescription) {
		TDescription = tDescription;
	}

	public boolean isTDone() {
		return TDone;
	}

	public void setTDone(boolean tDone) {
		TDone = tDone;
	}

	/** default constructor */
	public TodoFormatter() {
	}

	/** minimal constructor */
	public TodoFormatter(Short paddockPId, Short paddockFarmFId, String TDateEntered, boolean TDone) {
		this.paddockPId = paddockPId;
		this.paddockFarmFId = paddockFarmFId;
		this.TDateEntered = TDateEntered;
		this.TDone = TDone;
	}

	/** full constructor */
	public TodoFormatter(Short paddockPId, Short paddockFarmFId, String TDateEntered,
			String TDateDue, String TDescription, boolean TDone) {
		this.paddockPId = paddockPId;
		this.paddockFarmFId = paddockFarmFId;
		this.TDateEntered = TDateEntered;
		this.TDateDue = TDateDue;
		this.TDescription = TDescription;
		this.TDone = TDone;
	}
}
