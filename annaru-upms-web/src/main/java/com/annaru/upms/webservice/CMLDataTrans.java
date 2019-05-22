
package com.annaru.upms.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="WEBCMD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Params" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "webcmd",
        "params"
})
@XmlRootElement(name = "CMLDataTrans")
public class CMLDataTrans {

    @XmlElement(name = "WEBCMD")
    protected String webcmd;
    @XmlElement(name = "Params")
    protected String params;

    /**
     * 获取webcmd属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWEBCMD() {
        return webcmd;
    }

    /**
     * 设置webcmd属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWEBCMD(String value) {
        this.webcmd = value;
    }

    /**
     * 获取params属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置params属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setParams(String value) {
        this.params = value;
    }

}
