package com.javarefresh.xsltToHtml;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
/**
 * These properties used in thymeleaf pages.
 * 
 * @author Yogesh Badgujar
 * email me in case any problem - badgujar.yogesh@gmail.com
 *
 */
public class Holder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;

	private int id;

	@NotNull(message = "Name cannot be null")
	private String xmlValue;

	@NotNull(message = "Name cannot be null")
	private String cssValue;

	@NotNull(message = "Name cannot be null")
	private String xsltValue;

	private String htmlResult;

	private String specialNote;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getXmlValue() {
		return xmlValue;
	}

	public void setXmlValue(String xmlValue) {
		this.xmlValue = xmlValue;
	}

	public String getCssValue() {
		return cssValue;
	}

	public void setCssValue(String cssValue) {
		this.cssValue = cssValue;
	}

	public String getXsltValue() {
		return xsltValue;
	}

	public void setXsltValue(String xsltValue) {
		this.xsltValue = xsltValue;
	}

	public String getHtmlResult() {
		return htmlResult;
	}

	public void setHtmlResult(String htmlResult) {
		this.htmlResult = htmlResult;
	}

	public String getSpecialNote() {
		return specialNote;
	}

	public void setSpecialNote(String specialNote) {
		this.specialNote = specialNote;
	}

}
