package com.annaru.upms.webservice;

import cn.hutool.db.Entity;
import com.sun.org.apache.xpath.internal.SourceTree;
import jdk.nashorn.internal.runtime.regexp.joni.constants.NodeType;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:XCK
 * Date:2019/5/16
 * Description:
 */
public class WebServiceXmlUtil {

    /**
     * XML格式字符串转换为Map
     *
     * @param strXML XML字符串
     * @return XML数据转换后的Map
     * @throws Exception
     */
    public static Map<String, Object> xmlToMap(String strXML) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
        InputStream stream = new ByteArrayInputStream(strXML.getBytes("gb2312"));
        Document document = documentBuilder.parse(stream);
        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();
        Map<String, Object> data = traversalXML(root);
        stream.close();
        return data;
    }

    /**
     * 将Map转换为XML格式的字符串
     *
     * @param data Map类型数据
     * @return XML格式的字符串
     * @throws Exception
     */
    public static String mapToXml(Map<String, String> data) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element root = document.createElement("Params");
        document.appendChild(root);
        for (String key: data.keySet()) {
            String value = data.get(key);
            if (value == null) {
                value = "";
            }
            value = value.trim();
            Element filed = document.createElement(key);
            filed.appendChild(document.createTextNode(value));
            root.appendChild(filed);
        }
        DOMSource source = new DOMSource(document);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        String output = writer.getBuffer().toString(); //.replaceAll("\n|\r", "");
        writer.close();
        return output;
    }

    /**
     * @Description: 递归遍历XML节点
     * @param currentNode 元素节点
     * @Author: XCK
     * @Date: 2019/5/20
     * @return Map<String, Object>
     */
    private static Map<String, Object> traversalXML(Node currentNode) {

        if(currentNode == null){
            return null;
        }

        Map<String, Object> data = new HashMap<>();
        List<Map<String, Object>> itemMapList = new ArrayList<>();
        // 获取结点的所有子结点
        NodeList childNodes = currentNode.getChildNodes();
        // 遍历
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            // 判断结点是否为元素
            if(node.getNodeType() == Node.ELEMENT_NODE){
                // 递归得到元素所有子结点
                Map<String, Object> itemMap = traversalXML(node);
                // 如果递归得到的itemMap为空，则说明当前元素没有更多元素结点
                if(itemMap == null || itemMap.isEmpty()){
                    String value = node.getFirstChild()!=null ? node.getFirstChild().getNodeValue() : "";
                    data.put(node.getNodeName(), value);
                }else{
                    if(data.isEmpty()){
                        // 当前结点（currentNode）的data为空时，先暂时把此次遍历的子结点的内容存放在list中，待遍历完毕之后在考虑其归处
                        itemMap.put("parentNode", node.getNodeName());
                        itemMapList.add(itemMap);
                    } else {
                        // 当前结点（currentNode）的data不为空时，表示该节点不是集合，是对象，直接保存itemMap
                        for (String key : itemMap.keySet()){
                            if(node.getNodeName().equals(key)){
                                data.putAll(itemMap);
                            }else{
                                data.put(node.getNodeName(), itemMap);
                            }
                        }
                    }
                }
            }
        }
        if(CollectionUtils.isNotEmpty(itemMapList)){
            // 当前结点（currentNode）的data为空时，表示该节点是集合、不为空时，表示该节点不是集合，是对象
            if(data.isEmpty()){
                data.put(currentNode.getNodeName(), itemMapList);
            } else {
                for (Map<String, Object> map : itemMapList) {
                    String parentNodeName = (String) map.get("parentNode");
                    map.remove("parentNode");
                    data.put(parentNodeName, map);
                }
            }
        }
        return data;
    }

    public static void main(String []args){
        String xmlstr = "<?xml version=\"1.0\" encoding=\"gb2312\"?>\n" +
                "<CBMLDataTrans>\n" +
                "  <ResultCode>0</ResultCode>\n" +
                "  <ResultContent>获取数据成功</ResultContent>\n" +
                "  <WEBCMD>DownLoadResult</WEBCMD>\n" +
                "  <Results>\n" +
                "    <Result>\n" +
                "      <ReportNO>14121801PCR089782</ReportNO>\n" +
                "      <AppBarcode>100001901105</AppBarcode>\n" +
                "      <ExeBarcode/>\n" +
                "      <SJGDM>98F003</SJGDM>\n" +
                "      <DJGDM>01</DJGDM>\n" +
                "      <SJRQ>2014-12-18 00:00:00</SJRQ>\n" +
                "      <BBZL>分泌物</BBZL>\n" +
                "      <BRXM>测试号</BRXM>\n" +
                "      <BRXB>012</BRXB>\n" +
                "      <BRNL>23</BRNL>\n" +
                "      <BYH>141218003217</BYH>\n" +
                "      <LCZD/>\n" +
                "      <SFJE>0.00</SFJE>\n" +
                "      <FJJE>0.00</FJJE>\n" +
                "      <SJJE>0.00</SJJE>\n" +
                "      <BGBH>14121801PCR000001</BGBH>\n" +
                "      <JYYS>康丽</JYYS>\n" +
                "      <SHYS>严字斐</SHYS>\n" +
                "      <PZR/>\n" +
                "      <CYSJ>2014-12-18 13:14:08</CYSJ>\n" +
                "      <JSSJ>2014-12-18 13:14:08</JSSJ>\n" +
                "      <JCSJ>2014-12-18 13:14:08</JCSJ>\n" +
                "      <SHSJ>2014-12-18 13:15:34</SHSJ>\n" +
                "      <WJBZ>0</WJBZ>\n" +
                "      <WCBZ>0</WCBZ>\n" +
                "      <BZ />\n" +
                "      <BBXZ>外观正常</BBXZ>\n" +
                "      <BGLX>1</BGLX>\n" +
                "      <ItemResultList>\n" +
                "        <ItemResult>\n" +
                "          <XH/>\n" +
                "          <XMBM>90007200</XMBM>\n" +
                "          <XMMC>HPV 6型11型</XMMC>\n" +
                "          <JCJG>阴性</JCJG>\n" +
                "          <XMDW />\n" +
                "          <XMCKZ>阴性</XMCKZ>\n" +
                "          <JGPD>N</JGPD>\n" +
                "          <WJZBZ>0</WJZBZ>\n" +
                "        </ItemResult>\n" +
                "        <ItemResult>\n" +
                "          <XH/>\n" +
                "          <XMBM>90007200</XMBM>\n" +
                "          <XMMC>HPV 6型11型</XMMC>\n" +
                "          <JCJG>阴性</JCJG>\n" +
                "          <XMDW/>\n" +
                "          <XMCKZ>阴性</XMCKZ>\n" +
                "          <JGPD>N</JGPD>\n" +
                "          <WJZBZ>0</WJZBZ>\n" +
                "        </ItemResult>\n" +
                "      </ItemResultList>\n" +
                "    </Result>\n" +
                "    <Result>\n" +
                "      <ReportNO>14121801PCR089782</ReportNO>\n" +
                "      <AppBarcode>100001901105</AppBarcode>\n" +
                "      <ExeBarcode/>\n" +
                "      <SJGDM>98F003</SJGDM>\n" +
                "      <DJGDM>01</DJGDM>\n" +
                "      <SJRQ>2014-12-18 00:00:00</SJRQ>\n" +
                "      <BBZL>分泌物</BBZL>\n" +
                "      <BRXM>测试号</BRXM>\n" +
                "      <BRXB>012</BRXB>\n" +
                "      <BRNL>23</BRNL>\n" +
                "      <BYH>141218003217</BYH>\n" +
                "      <LCZD/>\n" +
                "      <SFJE>0.00</SFJE>\n" +
                "      <FJJE>0.00</FJJE>\n" +
                "      <SJJE>0.00</SJJE>\n" +
                "      <BGBH>14121801PCR000001</BGBH>\n" +
                "      <JYYS>康丽</JYYS>\n" +
                "      <SHYS>严字斐</SHYS>\n" +
                "      <PZR/>\n" +
                "      <CYSJ>2014-12-18 13:14:08</CYSJ>\n" +
                "      <JSSJ>2014-12-18 13:14:08</JSSJ>\n" +
                "      <JCSJ>2014-12-18 13:14:08</JCSJ>\n" +
                "      <SHSJ>2014-12-18 13:15:34</SHSJ>\n" +
                "      <WJBZ>0</WJBZ>\n" +
                "      <WCBZ>0</WCBZ>\n" +
                "      <BZ />\n" +
                "      <BBXZ>外观正常</BBXZ>\n" +
                "      <BGLX>1</BGLX>\n" +
                "      <ItemResultList>\n" +
                "        <ItemResult>\n" +
                "          <XMBM>90007200</XMBM>\n" +
                "        </ItemResult>\n" +
                "        <ItemResult>\n" +
                "          <XH/>\n" +
                "          <XMBM>90007200</XMBM>\n" +
                "          <XMMC>HPV 6型11型</XMMC>\n" +
                "          <JCJG>阴性</JCJG>\n" +
                "          <XMDW/>\n" +
                "          <XMCKZ>阴性</XMCKZ>\n" +
                "          <JGPD>N</JGPD>\n" +
                "          <WJZBZ>0</WJZBZ>\n" +
                "        </ItemResult>\n" +
                "      </ItemResultList>\n" +
                "    </Result>\n" +
                "  </Results>\n" +
                "</CBMLDataTrans>";

        try {
            Map<String, Object> map = xmlToMap(xmlstr);
            System.out.println(map.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
