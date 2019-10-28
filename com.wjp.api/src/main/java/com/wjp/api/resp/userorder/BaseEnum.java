package com.wjp.api.resp.userorder;

/**
 * @author : Wuxi
 */
public enum BaseEnum {
    /**
     * 基本异常枚举
     */
    SYS_ERROR("SYS00001", "系统处理异常"),

    SYS_SUCCESS("SYS00000", "操作成功!"),

    API_PARAMS_ERROR("SYS00002", "请求参数不符合规范！"),

    API_PARAMS_TYPE_ERROR("SYS00003", "请求参数类型非法!"),

    API_NOT_AVAILABLE("SYS00004", "服务不可用，请重试!"),

    API_NO_ACCESS("SYS00005", "您没有访问该资源的权限!"),

    API_SIGN_ERROR("SYS00006", "您的token是无效的"),

    LOGIN_NAME_ERROR("L00001", "登录用户名错误!"),

    LOGIN_PASS_WORD_ERROR("L00002", "登录密码错误！"),

    LOGIN_ACCOUNT_STATUS_ERROR("L00003", "登录账号被锁定！"),

    RESET_NEW_OLD_PASSWORD_EQUAL_ERROR("L00004", "您设置的新老密码一样。请重新设置！"),

    RESET_AFFIRM_NEW_NOT_EQUAL_ERROR("L00005", "您设置的确认密码和新密码不一致。请重新设置！"),

    RESET_LOGIN_PASSWORD_PAST_DUE_ERROR("L00006", "您的密码已过期！。请重新设置！"),

    LOGIN_PASSWORD_USERNAME_ERROR("L00007", "您的用户名或密码有误！请重新登录！"),

    LOGIN_REPETITION_ERROR("L00008", "您不要重复登录！"),

    NOT_SUPER_ADMIN_ADD_MENU_ERROR("L00009", "您非超级管理员不能添加菜单"),

    ACCOUNT_LOGIN_ERROR("L00010", "账户已经被登录,不能重复登录"),

    USER_HAS_EXIST("U00001", "用户已存在"),

    USER_NOT_EXIST("U00002", "用户不存在"),

    USER_NOT_IN_GROUP("U00003", "用户不属于任何权限组"),

    GROUP_NOT_EXIST("G00001", "权限组不存在"),

    GROUP_BINDING_ROLE_ERROR("G00002", "权限组一定要绑定角色"),

    GROUP_NAME_HAS_EXIST("G00003", "权限组名已存在,请更换名称"),

    GROUP_NOT_EXIST_USER("G00004", "该权限组不存在用户"),

    MENU_FLAG_HAS_EXIT("M00001", "该权限名已存在，请更换名称"),

    MENU_NAME_HAS_EXIST("M00002", "该菜单名已存在,请更换名称"),

    MENU_PARNET_DONOT_EXIST("M00003", "该父级菜单不存在"),

    BUTTON_CANOT_BE_PARENTMENU("M00004", "按钮不能作为父级菜单"),

    SUPER_ADMIN_CANOT_CHANGE("S00001", "超级管理员不能被更改"),

    SUPER_ADMIN_CANOT_ADD("S00002", "非超级管理员不能够添加超管"),

    ROLE_NOT_EXIST("R00001", "职能不存在"),

    ROLE_NAME_HAS_EXIST("R00002", "该角色名已存在,请更换名称"),

    ROLE_MUST_HAVE_MENU("R00003", "角色必须拥有权限"),

    REMOTE_API_CALL_FAILED("R00004", "远程接口调用失败"),

    CHANNEL_FOCECASE_CONFIRM_PROCESSING("C00001", "该产品当月预提确认正在处理中，请稍后重试"),

    CHANNEL_ADD_ERROR("C00001", "此产品渠道已经存在，不能添加"),

    CHANNEL_NOT_EXIST("C00002", "渠道不存在"),

    CHANNEL_AFFIRM_ERROR("C00003","渠道已经确认不能再次确认"),

    CHANNEL_AFFIRM_RATE_CHANGE_ERROR("C00004","渠道费率发生变化，请先查询一下当前月份的产品对账信息，后再次确认！"),

    CHANNEL_AFFIRM_CONTRACT_NO_NULL("C00005","渠道确认数据中合同号为空！"),

    CHANNEL_RECOUNT_FEE_ERROR("C00006","当前渠道当前月已经生成了对账快照信息，不能做重算了！"),

    CHANNEL_ID_NOT_EXIST_ERROR("C00007","渠道id不存在"),

    CHANNEL_AFFIRM_DATA_NULL_ERROR("C00008","当前月份没有任何预提数据无法确认"),
    ;
    private String code;
    private String message;

    BaseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
