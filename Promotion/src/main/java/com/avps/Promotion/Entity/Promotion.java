package com.avps.Promotion.Entity;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rcclpromotions")
public class Promotion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "promotionname")
	private String promotionName;
	@Column(name = "promotionstate")
	private String promotionState;
	@Column(name = "startdate")
	private Date startDate;
	@Column(name = "enddate")
	private Date endDate;
	@Column(name = "discountamount")
	private double discountAmount;

	public Promotion() {
	
	}
	
	public Promotion(Integer id, String promotionName, String promotionState, Date startDate, Date endDate,
			double discountAmount) {
		super();
		this.id = id;
		this.promotionName = promotionName;
		this.promotionState = promotionState;
		this.startDate = startDate;
		this.endDate = endDate;
		this.discountAmount = discountAmount;
	}



	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public String getPromotionState() {
		return promotionState;
	}

	public void setPromotionState(String promotionState) {
		this.promotionState = promotionState;
	}

	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Override
	public String toString() {
		return "Promotion [id=" + id + ", promotionName=" + promotionName + ", promotionState=" + promotionState
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", discountAmount=" + discountAmount + "]";
	}

}
