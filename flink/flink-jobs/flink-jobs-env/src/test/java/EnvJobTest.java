import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class EnvJobTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(EnvJobTest.class);

    public static void main(String[] args){
        Map<String,String> map = System.getenv();
        // 获取系统用户名
        String userName = map.get("USERNAME");
        // 获取计算机名
        String computerName = map.get("COMPUTERNAME");
        // 获取计算机域名
        String userDomain = map.get("USERDOMAIN");
        // 获取计算机操作系统
        String operatingSystem = System.getProperty("os.name");
        LOGGER.info(userName);
        LOGGER.info(computerName);
        LOGGER.info(userDomain);
        LOGGER.info(operatingSystem);
    }
}
