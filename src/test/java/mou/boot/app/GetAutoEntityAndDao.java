package mou.boot.app;

import org.mybatis.generator.api.ShellRunner;

/**
 * @Author: JianTao Li
 * @Date: 2020/11/27 10:40
 */
public class GetAutoEntityAndDao {
    public static void main(String[] args) {
        args = new String[] { "-configfile", "src\\main\\resources\\mybatis-generator.xml", "-overwrite" };
        ShellRunner.main(args);
    }
}
