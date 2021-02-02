package com.myzone.demoutils.utils;

import com.google.i18n.phonenumbers.PhoneNumberToCarrierMapper;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;
import com.myzone.demoutils.dto.PhoneDto;

import java.util.Locale;

/**
 * 手机号归属地查询
 * jar依赖：com.googlecode.libphonenumber(Libphonenumber、Geocoder、Prefixmapper
 * 、Carrier) pom依赖：http://mvnrepository.com/search?q=libphonenumber
 * 项目地址：https://github.com/googlei18n/libphonenumber
 *
 */
public class PhoneUtil {

    /** 直辖市 */
    private final static String[] MUNICIPALITY = { "北京市", "天津市", "上海市", "重庆市" };

    /** 自治区 */
    private final static String[] AUTONOMOUS_REGION = { "新疆", "内蒙古", "西藏",
            "宁夏", "广西" };

    private static PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil
            .getInstance();

    /** 提供与电话号码相关的运营商信息 */
    private static PhoneNumberToCarrierMapper carrierMapper = PhoneNumberToCarrierMapper
            .getInstance();

    /** 提供与电话号码有关的地理信息 */
    private static PhoneNumberOfflineGeocoder geocoder = PhoneNumberOfflineGeocoder
            .getInstance();

    /** 中国大陆区区号 */
    private final static int COUNTRY_CODE = 86;

    /**
     * 根据手机号 判断手机号是否有效
     *
     * @param phoneNumber
     *            手机号码
     * @return true-有效 false-无效
     */
    public static boolean checkPhoneNumber(String phoneNumber) {
        long phone = Long.parseLong(phoneNumber);

        PhoneNumber pn = new PhoneNumber();
        pn.setCountryCode(COUNTRY_CODE);
        pn.setNationalNumber(phone);

        return phoneNumberUtil.isValidNumber(pn);

    }

    /**
     * 根据手机号 判断手机运营商
     *
     * @param phoneNumber
     *            手机号码
     * @return 如：广东省广州市移动
     */
    public static String getCarrier(String phoneNumber) {

        long phone = Long.parseLong(phoneNumber);

        PhoneNumber pn = new PhoneNumber();
        pn.setCountryCode(COUNTRY_CODE);
        pn.setNationalNumber(phone);
        // 返回结果只有英文，自己转成成中文
        String carrierEn = carrierMapper.getNameForNumber(pn, Locale.ENGLISH);
        String carrierZh = "";
        switch (carrierEn) {
            case "China Mobile":
                carrierZh += "移动";
                break;
            case "China Unicom":
                carrierZh += "联通";
                break;
            case "China Telecom":
                carrierZh += "电信";
                break;
            default:
                break;
        }
        return carrierZh;
    }

    /**
     * 根据手机号 获取手机归属地
     *
     * @param phoneNumber
     *            手机号码
     * @return 如：广东省广州市
     */
    public static String getGeo(String phoneNumber) {
        long phone = Long.parseLong(phoneNumber);

        PhoneNumber pn = new PhoneNumber();
        pn.setCountryCode(COUNTRY_CODE);
        pn.setNationalNumber(phone);
        return geocoder.getDescriptionForNumber(pn, Locale.CHINESE);
    }

    /**
     * 根据手机号 获取手机信息模型
     *
     * <pre>
     * 若返回值为null，则说明该号码无效
     * </pre>
     *
     * @param phoneNumber
     *            手机号码
     * @return 手机信息模型PhoneModel
     */
    public static PhoneDto getPhoneDto(String phoneNumber) {
        if (checkPhoneNumber(phoneNumber)) {
            String geo = getGeo(phoneNumber);
            PhoneDto phoneModel = new PhoneDto();
            String carrier = getCarrier(phoneNumber);
            phoneModel.setCarrier(carrier);
            // 直辖市
            for (String val : MUNICIPALITY) {
                if (geo.equals(val)) {
                    phoneModel.setProvinceName(val.replace("市", ""));
                    phoneModel.setCityName(val);
                    return phoneModel;
                }
            }
            // 自治区
            for (String val : AUTONOMOUS_REGION) {
                if (geo.startsWith(val)) {
                    phoneModel.setProvinceName(val);
                    phoneModel.setCityName(geo.replace(val, ""));
                    return phoneModel;
                }
            }

            // 其它
            String[] splitArr = geo.split("省");
            if (splitArr != null && splitArr.length == 2) {
                phoneModel.setProvinceName(splitArr[0]);
                phoneModel.setCityName(splitArr[1]);
                return phoneModel;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        PhoneDto phoneDto = PhoneUtil.getPhoneDto("13456555555");
        if(phoneDto != null){
            System.out.println(phoneDto.getProvinceName());
            System.out.println(phoneDto.getCityName());
            System.out.println(phoneDto.getCarrier());
        }else{
            System.err.println("该号码无效");
        }
    }

}
