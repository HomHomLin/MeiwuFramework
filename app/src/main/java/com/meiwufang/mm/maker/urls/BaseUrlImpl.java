package com.meiwufang.mm.maker.urls;

/**
 * Created by linhomhom on 14-12-31.
 */
public class BaseUrlImpl implements BaseUrls{

    public final String total_url = "http://hudong.lanfw.com/api/newhouse/index.php";
    public String city_code = "fz";

    @Override
    public void setCityCode(String code) {
        city_code = code;
    }

    @Override
    public String getCtiyCode() {
        return city_code;
    }


    @Override
    public String getBaseUrl() {
        return total_url;
    }

    @Override
    public String getSearchTittle() {
        return getBaseUrl() + "/house/search_title/" + getCtiyCode();
    }

    @Override
    public String getUserLoginUrl() {
        return getBaseUrl() + "/user/login/" + getCtiyCode();
    }

    @Override
    public String getUsrePhoneCodeUrl() {
        return getBaseUrl() + "/user/buildcode";
    }

    @Override
    public String getUsreFindPasswordUrl() {
        return getBaseUrl() + "/user/backpassword/" + getCtiyCode();
    }

    @Override
    public String getUserRegisterUrl() {
        return getBaseUrl() + "/user/register/" + getCtiyCode();
    }

    @Override
    public String getCitysUrl() {
        return getBaseUrl() + "/house/city";
    }

    @Override
    public String getHouseTitlesUrl() {
        return getBaseUrl() + "/house/house/";
    }

    @Override
    public String getOldHouseTitlesUrl() {
        return getBaseUrl() + "/esf/";
    }

    @Override
    public String getHouseCondition() {
        return getBaseUrl() + "/house/condition/";
    }

    @Override
    public String getOldHouseCondition() {
        return getBaseUrl() + "/esf/condition/";
    }

    @Override
    public String getHouseNewsUrl() {
        return getBaseUrl() + "/house/cms/" + getCtiyCode();
    }

    @Override
    public String getHouseConfig() {
        return getBaseUrl() + "/house/config";
    }

    @Override
    public String getRenameUrl() {
        return getBaseUrl() + "/user/" + getCtiyCode() + "/1";
    }

    @Override
    public String getRePassword() {
        return getBaseUrl() + "/user/" + getCtiyCode() + "/2";
    }

    @Override
    public String getMobileCheckUrl() {
        return getBaseUrl() + "/user/authmobile/" + getCtiyCode();
    }

    @Override
    public String getIndexNewsUrl() {
        return getBaseUrl() + "/cms/recommend/" + getCtiyCode() + "/index";
    }

    @Override
    public String getDzyhHouseUrl() {
        return getBaseUrl() + "/house/preferential/";
    }

    @Override
    public String getIndexUrl() {
        return getBaseUrl() + "/house/index/" + getCtiyCode();
    }

    @Override
    public String getMssageListUrl() {
        return getBaseUrl() + "/message2_last/" + getCtiyCode();
    }

    @Override
    public String getChatListUrl() {
        return getBaseUrl() + "/message2/" + getCtiyCode();
    }

    @Override
    public String getChatPostUrl() {
        return getBaseUrl() + "/message2/" + getCtiyCode();
    }

    @Override
    public String getKftUrl() {
        return getBaseUrl() + "/house/houseroad/";
    }

    @Override
    public String getDetailUrl() {
        return getBaseUrl() + "/house/house/";
    }

    @Override
    public String getCheapUrl() {
        return getBaseUrl() + "/house/group/" + getCtiyCode();
    }

    @Override
    public String getCheapReportUrl() {
        return getBaseUrl() + "/house/preferential/" + getCtiyCode();
    }

    @Override
    public String getCheapCommitUrl() {
        return getBaseUrl() + "/house/preferential/" + getCtiyCode();
    }

    @Override
    public String getMyFenxiaoUrl() {
        return getBaseUrl() + "/house/distributor_customer/" + getCtiyCode();
    }

    @Override
    public String getDaKaUrl() {
        return "http://m.lanfw.com/index.php?city_id=" + getCtiyCode() + "&m=daka&from=app&sys_type=d900102";
    }

    @Override
    public String getOldDetailUrl() {
        return getBaseUrl() + "/esf/";
    }

    @Override
    public String getNeedKnowUrl() {
        return getBaseUrl() + "/house/need_know2/" + getCtiyCode();
    }

    @Override
    public String getFenXiaoListUrl() {
        return getBaseUrl() + "/house/distributor/" + getCtiyCode();
    }

    @Override
    public String getFenXiaoCommitUrl() {
        return getBaseUrl() + "/house/distributor/" + getCtiyCode() + "/";
    }

    @Override
    public String getValidUrl() {
        return " Fuck! What a fucking shit project! We have never saw! ";
    }

    @Override
    public String getBaomingKftUrl() {
        return getBaseUrl() + "/house/housegroup/";
    }
}
