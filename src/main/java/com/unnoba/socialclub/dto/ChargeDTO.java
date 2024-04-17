package com.unnoba.socialclub.dto;

import java.util.Date;
import com.unnoba.socialclub.entities.Member;

public class ChargeDTO {
	private int id;
	private String value;
	private Date date;
	private Member member_id;

	public ChargeDTO() {
		super();
	}

	public ChargeDTO getCharge() {
		return this;
	}

	public ChargeDTO(Member member_id) {
		super();
		this.member_id = member_id;
	}

	public ChargeDTO(String value, Date date, Member member_id) {
		super();
		this.value = value;
		this.date = date;
		this.member_id = member_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Member getMember() {
		return this.member_id;
	}

	public Member getMember_id() {
		return member_id;
	}

	public void setMember_id(Member member_id) {
		this.member_id = member_id;
	}
}
