package mou.boot.app.common.enums;

/**
 * 展示平台对接的厂商枚举
 */
public enum CompanyEnum {
    hik("hik","海康威视"),qygk("qygk","旗云高科"),znywglxt("znywglxt","智能运维管理系统");

    private String code;
    private String name;

    private CompanyEnum(String code, String name){
        this.code = code;
        this.name = name;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
