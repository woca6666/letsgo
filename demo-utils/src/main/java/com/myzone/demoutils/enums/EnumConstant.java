package com.myzone.demoutils.enums;

/**
 * 生活缴费常量
 *
 */
public class EnumConstant {

    //缴费公司类型
    public static final String LIFE_TYPE_WATER = "WATER";
    public static final String LIFE_TYPE_ELECTRICITY = "ELEC";
    public static final String LIFE_TYPE_GAS = "GAS";
    public static final String LIFE_TYPE_HEAT = "HEAT";

    //订单状态
    public static final String ORDER_STATUS_CREATE = "CREATE";//新建
    public static final String ORDER_STATUS_SUCCESS = "SUCCESS";//成功
    public static final String ORDER_STATUS_FAILED = "FAILED";//失败

    //缴费公司代码
    public static final String COMPANY_ID_1 = "0001";//峄城区城市供排水公司
    public static final String COMPANY_ID_2 = "0002";//枣庄市热力总公司
    public static final String COMPANY_ID_3 = "0003";//山亭自来水（上善）

    //查询账单
    public static final String SH_TI_BILL_QUERY_SUCCESS = "9999";//山亭账单查询成功

    //销账通知状态
    public static final String PAY_CALL_BACK_SUCCESS = "SUCCESS";
    public static final String PAY_CALL_BACK_FAILED = "FAILED";//失败
    public static final Integer BILL_QUERY_SUCCESS = 1;//返回成功

    //销账，缴费
    public static final String YI_CH_BILL_WRITE_OFF = "YCBWO";//峄城区水务
    public static final String YI_CH_BILL_WRITE_OFF_WAY = "市民卡自营";//缴费来源
    public static final String YI_CH_KAI_PIAO_STATE = "0";//0:否；1：普票用户；2：专票用户
    public static final String YI_CH_IS_KAI_PIAO = "0";//0:不开票；1：开票

    //应用管理
    //渠道码
    public static final String APPLY_CHANNEL_CODE = "CHANNEL_CODE";
    //密钥
    public static final String APPLY_SECRET_KEY = "SECRET_KEY";
    //appid
    public static final String APPLY_APP_ID = "APP_ID";
    //状态 0-禁用 1-启用
    public static final String APPLY_STATUS_STOP = "0";
    public static final String APPLY_STATUS_START = "1";
    //审核状态 0-未审核 1-审核通过 2-驳回
    public static final String APPLY_CHECK_STATUS_ING = "0";
    public static final String APPLY_STATUS_START_YES = "1";
    public static final String APPLY_STATUS_START_NO = "2";


    //验证启用/禁用状态
    public enum STATUS{
        禁用("STOP", "0"),
        启用("START", "1"),
        ;

        private String name;
        private String index;

        private STATUS(String name, String index) {
            this.name = name;
            this.index = index;
        }

        public static String nameOf(String index) {
            for (STATUS c : STATUS.values()) {
                if (c.getIndex().equals(index)) {
                    return c.name;
                }
            }
            return null;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getIndex() {
            return index;
        }
        public void setIndex(String index) {
            this.index = index;
        }
    }


    //验证审核状态
    public enum CECKSTATUS{
        未审核("ING", "0"),
        审核通过("YES", "1"),
        审核驳回("NO", "2"),
        ;

        private String name;
        private String index;

        private CECKSTATUS(String name, String index) {
            this.name = name;
            this.index = index;
        }

        public static String nameOf(String index) {
            for (CECKSTATUS c : CECKSTATUS.values()) {
                if (c.getIndex().equals(index)) {
                    return c.name;
                }
            }
            return null;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getIndex() {
            return index;
        }
        public void setIndex(String index) {
            this.index = index;
        }
    }


    //验证字段枚举类型
    public enum FIELDTYPE{
        应用名称("apply_name", 1),
        渠道码("channel_code", 2),
        ;

        private String name;
        private int index;

        private FIELDTYPE(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public static String nameOf(int index) {
            for (FIELDTYPE c : FIELDTYPE.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
    }


    //验证字段枚举类型
    public enum TYPECODE{
        水("WATER", "WATER"),
        电("ELEC", "ELEC"),
        燃气("GAS", "GAS"),
        暖气("HEAT", "HEAT"),
        ;

        private String name;
        private String index;

        private TYPECODE(String name, String index) {
            this.name = name;
            this.index = index;
        }

        public static String nameOf(String index) {
            for (TYPECODE c : TYPECODE.values()) {
                if (c.getIndex().equals(index)) {
                    return c.name;
                }
            }
            return null;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getIndex() {
            return index;
        }
        public void setIndex(String index) {
            this.index = index;
        }
    }


    //文档类型
    public enum DOCTYPE {
        输入文档("IN", "1"),
        输出文档("OUT", "2"),
        ;

        private String name;
        private String index;

        private DOCTYPE(String name, String index) {
            this.name = name;
            this.index = index;
        }

        public static String nameOf(String index) {
            for (DOCTYPE c : DOCTYPE.values()) {
                if (c.getIndex().equals(index)) {
                    return c.name;
                }
            }
            return null;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getIndex() {
            return index;
        }
        public void setIndex(String index) {
            this.index = index;
        }
    }

}
