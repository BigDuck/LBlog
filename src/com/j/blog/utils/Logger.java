package com.j.blog.utils;
public class Logger {

	private org.apache.log4j.Logger logger;
	private boolean open=true;//是否开启日志
	public void setClose(boolean open) {
		this.open = open;
	}
	
	/**
	 * 构造方法，初始化Log4j的日志对象
	 */
	private Logger(org.apache.log4j.Logger log4jLogger) {
		logger = log4jLogger;
	}

	/**
	 * 获取构造器，根据类初始化Logger对象
	 * 
	 * @param Class
	 *            Class对象
	 * @return Logger对象
	 */
	public static Logger getLogger(Class classObject) {
		return new Logger(org.apache.log4j.Logger.getLogger(classObject));
	}

	/**
	 * 获取构造器，根据类名初始化Logger对象
	 * 
	 * @param String
	 *            类名字符串
	 * @return Logger对象
	 */
	public static Logger getLogger(String loggerName) {
		return new Logger(org.apache.log4j.Logger.getLogger(loggerName));
	}

	public void debug(Object object) {
		if(open){
			logger.debug(object);
			
		}
	}

	public void debug(Object object, Throwable e) {
if(open){
	
	logger.debug(object, e);
}
	}

	public void info(Object object) {
if (open) {
	
	logger.info(object);
}
	}

	public void info(Object object, Throwable e) {
if (open) {
	
	logger.info(object, e);
}
	}

	public void warn(Object object) {
		if(open){
			
			logger.warn(object);
		}
	}

	public void warn(Object object, Throwable e) {
if(true){
	
	logger.warn(object, e);
}
	}

	public void error(Object object) {
		if(true){
		logger.error(object);
	}}

	public void error(Object object, Throwable e) {
		if(true){
		logger.error(object, e);
	}}

	public void fatal(Object object) {
		
		if(true){
		logger.fatal(object);
	}
	}
	public String getName() {
	
		return logger.getName();
	}

	public org.apache.log4j.Logger getLog4jLogger() {
		return logger;
	}

	public boolean equals(Logger newLogger) {
		return logger.equals(newLogger.getLog4jLogger());
	}
}