package com.onlineJudge.juoj.util;

public class Utils {

    public static String exceptionFormatter(Throwable e) {
        StringBuilder sb = new StringBuilder();
        appendException(e, sb);
        Throwable cause = e.getCause();
        if (cause != null) {
            while (cause.getCause() != null) {
                appendException(cause, sb);
                cause = cause.getCause();
            }
        }
        return sb.toString();
    }

    private static void appendException(Throwable e, StringBuilder sb) {
        sb.append(" |||| Exception : " + e.getClass());
        if (e.getMessage() != null) {
            sb.append(" | Message : " + e.getMessage());
        }
        if (e.getCause() != null) {
            sb.append(" | Cause : " + e.getCause());
        }
        if (e.getStackTrace() != null) {
            sb.append(" | StackTrace : ");
            for (StackTraceElement ste : e.getStackTrace()) {
                sb.append(ste.toString());
                sb.append("    ");
            }
        }
    }
}
