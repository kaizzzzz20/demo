package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/***
 *@Descroption:
 *@Author: zhang.kai
 *@Date: 2020/6/24
 ***/
@Data
@AllArgsConstructor
public class User {
//public class User implements Serializable {

    private static final long serialVersionUID = -8065507606719393950L;

    private String userName;

    private String password;

    transient  String phoneNum;





}
