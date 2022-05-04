package com.ruoyi.common.constant;

import io.jsonwebtoken.Claims;

/**
 * General Constant Information
 * 
 * @author ruoyi
 */
public class Constants
{
    /**
     * UTF-8 character set
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK character set
     */
    public static final String GBK = "GBK";

    /**
     * http request
     */
    public static final String HTTP = "http://";

    /**
     * https requests
     */
    public static final String HTTPS = "https://";

    /**
     * Universal Success Mark
     */
    public static final String SUCCESS = "0";

    /**
     * Universal Failure Mark
     */
    public static final String FAIL = "1";

    /**
     * Login successful
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * Cancellation
     */
    public static final String LOGOUT = "Logout";

    /**
     * Register
     */
    public static final String REGISTER = "Register";

    /**
     * Error
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     *  redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * log user redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * repeat sumbit redis key
     */
    public static final String REPEAT_SUBMIT_KEY = "repeat_submit:";

    /**
     * rate limit redis key
     */
    public static final String RATE_LIMIT_KEY = "rate_limit:";

    /**
     * Captcha validity (minutes)
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;

    /**
     * Token
     */
    public static final String TOKEN = "token";

    /**
     * Token prefix
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * Token prefix
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

    /**
     * userID
     */
    public static final String JWT_USERID = "userid";

    /**
     * user name
     */
    public static final String JWT_USERNAME = Claims.SUBJECT;

    /**
     * useravatar
     */
    public static final String JWT_AVATAR = "avatar";

    /**
     * Creation time
     */
    public static final String JWT_CREATED = "created";

    /**
     * user Permissions
     */
    public static final String JWT_AUTHORITIES = "authorities";

    /**
     * Parameter management cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * Dictionary Management cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * Resource mapping path Prefix
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * RMI Remote Method Call
     */
    public static final String LOOKUP_RMI = "rmi://";

    /**
     * LDAP Remote Method Call
     */
    public static final String LOOKUP_LDAP = "ldap://";

    /**
     * Timed task violation character
     */
    public static final String[] JOB_ERROR_STR = { "java.net.URL", "javax.naming.InitialContext", "org.yaml.snakeyaml",
            "org.springframework.jndi" };
}