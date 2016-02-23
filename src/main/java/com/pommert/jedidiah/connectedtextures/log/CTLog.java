package com.pommert.jedidiah.connectedtextures.log;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFormatMessage;

public class CTLog {
	public static Logger log;

	public static void init(Logger log) {
		CTLog.log = log;
	}

	public static void info(Object message) {
		log.info(message);
	}

	public static void warn(Object message) {
		log.warn(message);
	}

	public static void error(Object message) {
		log.error(message);
	}

	public static void log(Level level, Object message) {
		log.log(level, message);
	}

	public static void log(Level level, String message, Object... params) {
		log.log(level, new MessageFormatMessage(message, params));
	}
}
