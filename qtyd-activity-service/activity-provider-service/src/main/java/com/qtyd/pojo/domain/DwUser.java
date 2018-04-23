package com.qtyd.pojo.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class DwUser {
    private Integer userId;

    private Integer typeId;

    private Integer order;

    private String username;

    private String password;

    private String paypassword;

    private Integer islock;

    private String inviteUserid;

    private BigDecimal inviteMoney;

    private Byte realStatus;

    private String cardType;

    private String cardId;

    private String cardPic1;

    private String cardPic2;

    private String nation;

    private String realname;

    private Integer investIntegral;

    private Integer integral;

    private Integer status;

    private Integer avatarStatus;

    private Byte emailStatus;

    private Byte phoneStatus;

    private Integer videoStatus;

    private Integer sceneStatus;

    private String email;

    private Byte sex;

    private String litpic;

    private String tel;

    private String phone;

    private String qq;

    private String wangwang;

    private String emailTemp;

    private Boolean emailStatusTemp;

    private Date birthday;

    private String province;

    private String city;

    private Integer area;

    private String address;

    private Integer logintime;

    private Integer addtime;

    private String addip;

    private Integer uptime;

    private String upip;

    private Integer lasttime;

    private String lastip;

    private Integer chongzuId;

    private BigDecimal czMoney;

    private BigDecimal czCash;

    private Integer chongzuNewId;

    private Integer idcardpic;

    private String job;

    private Byte isCompany;

    private String reginvitename;

    private Byte regSource;

    private String trackid;

    private Byte sinaStatus;

    private String sinaUid;

    private String nickName;

    private Integer realnameTime;

    private String regPort;

    private String realPort;

    private String realPage;

    private String addipProvince;

    private String phoneProvince;

    private Byte isBorrowTender;

    private Byte isAccountRecharge;

    private Byte isPaymentPassword;

    private Byte withhold;

    private Byte isBirthdayRemind;

    private Integer tracktypeId;

    private Byte isLazyTender;

    private Byte deviceStatus;

    private String taskMarker;

    private String platcust;

    private Byte xiamenStatus;

    private Byte isPaymentPasswordSina;

    private Byte logoutStatus;

    private String purview;

    private String remind;

    private String privacy;

}