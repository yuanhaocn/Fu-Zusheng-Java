package com.syc.oa.domain;

import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class TbEmployee {

	private Integer id;

	private String address;// 地址

	private Date birthday;// 出生日期

	private String cardId;// 身份证号

	private Date createDate;// 该记录的创建日期

	private String education;// 教育程度

	private String email;// 邮箱

	private Integer gender;// 性别

	private String hobby;// 爱好

	private String name;// 姓名

	private String party;// 政治面貌

	private String phone;// 电话

	private String qqNum;// qq号码

	private String race;// 民族

	private String remark;// 简介

	private String speciality;// 特长

	private Integer did;// 部门id

	private Integer jid;// 职位id

	private Integer uid;// 员工id

	@ManyToOne(targetEntity = TbJob.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "jid")
	private TbJob job;// 员工职位

	@ManyToOne(targetEntity = TbDept.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "did")
	private TbDept dept;// 员工部门

	@OneToOne(targetEntity = TbUser.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "uid")
	private TbUser user;// 员工

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education == null ? null : education.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby == null ? null : hobby.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party == null ? null : party.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getQqNum() {
		return qqNum;
	}

	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race == null ? null : race.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality == null ? null : speciality.trim();
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Integer getJid() {
		return jid;
	}

	public void setJid(Integer jid) {
		this.jid = jid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public TbJob getJob() {
		return job;
	}

	public void setJob(TbJob job) {
		this.job = job;
	}

	public TbDept getDept() {
		return dept;
	}

	public void setDept(TbDept dept) {
		this.dept = dept;
	}

	public TbUser getUser() {
		return user;
	}

	public void setUser(TbUser user) {
		this.user = user;
	}

}