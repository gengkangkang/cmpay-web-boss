package com.cmpay.boss.constant;

public class SystemConstant extends ConfigurableContants {

    static {
        init("/system.properties");
    }

    public static String       BATCHUP_TEMPLATE_FILE = getProperty("batchup.template.file");
    public static String       FILE_TEMP_DIR         = getProperty("file.temp.dir");

    // check config
    public static String       MQ_IP            = getProperty("");
    public static String       PORT_SERVICE          = getProperty("redis.port");
    public static String       CHECK_FILE_DIR        = getProperty("check.file.dir");

    public final static String INST_MER_ENABLE       = "Y";
    public final static String INST_MER_DISABLE      = "N";

    public final static String INST                  = "Y";
    public final static String CHANNEL               = "N";

    public final static String INST_MER_FILE_PATH    = "/app/uploadfile/";

    public static final String SUC_CODE              = "HTS0000";
    public static final String ERR_CODE              = "HTS1111";                           //
    public static final String MANAGE_ROLE_CODE      = "10";                                //
    public static final String APPROVE_ROLE_CODE     = "20";                                //
}
