package com.syc.boot;

/**
 * Restful风格url模板类
 */
public class RestfulUrlTemplate {

    public static final String GET_ALL = "/allMsg";

    public static final String FIND_ONE_MSG = "/msg/findOne/{id}";

    public static final String DELETE_MSG = "/msg/delete/{id}";

    public static final String CREATE_MSG = "/msg/create";

    public static final String UPDATE_MSG = "/msg/update/{id}";

    public static final String DELETE_ALL = "/msg/deleteAll";
}
