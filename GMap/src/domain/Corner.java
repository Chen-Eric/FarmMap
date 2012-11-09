package domain;
// default package

/**
 * Corner entity. @author MyEclipse Persistence Tools
 */

public class Corner implements java.io.Serializable {

	// Fields

	private CornerId id;
	private Double CLat;
	private Double CLon;
	private Float CEle;

	// Constructors

	/** default constructor */
	public Corner() {
	}

	/** minimal constructor */
	public Corner(CornerId id) {
		this.id = id;
	}

	/** full constructor */
	public Corner(CornerId id, Double CLat, Double CLon, Float CEle) {
		this.id = id;
		this.CLat = CLat;
		this.CLon = CLon;
		this.CEle = CEle;
	}

	// Property accessors

	public CornerId getId() {
		return this.id;
	}

	public void setId(CornerId id) {
		this.id = id;
	}

	public Double getCLat() {
		return this.CLat;
	}

	public void setCLat(Double CLat) {
		this.CLat = CLat;
	}

	public Double getCLon() {
		return this.CLon;
	}

	public void setCLon(Double CLon) {
		this.CLon = CLon;
	}

	public Float getCEle() {
		return this.CEle;
	}

	public void setCEle(Float CEle) {
		this.CEle = CEle;
	}

}