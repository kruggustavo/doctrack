/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

/**
 *
 * @author usuario
 */
public class LoggerUtil {
    private static Logger log = Logger.getLogger(LoggerUtil.class.getName());
    private static String mdcKey = "";
    private static Object mdcValue = null;
    
    public static void setMDCParams(String key, Object value){
        mdcKey = key;
        mdcValue = value;
    }
    
    public static void logInfo(String msg){
        if (mdcValue != null && mdcKey.length() > 0){
            MDC.put(mdcKey, mdcValue);
        }
        log.info(msg);
    }
    
    public static void logError(String msg){
        if (mdcValue != null && mdcKey.length() > 0){
            MDC.put(mdcKey, mdcValue);
        }
        log.error(msg);
    }
    
}
