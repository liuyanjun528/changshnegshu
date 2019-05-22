package com.annaru.upms.webservice;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Author:XCK
 * Date:2019/5/18
 * Description:
 */
public class HttpUtil {


    public static String httpSoapPostRequest(String strUrl, String reqBody, String soapAction, String contentType, int connectTimeoutMs, int readTimeoutMs) {
        HttpURLConnection httpURLConnection = null;
        OutputStream outputStream = null;
        InputStream inputStream =null;
        BufferedReader bufferedReader = null;
        String resp = null;
        try {
            String UTF8 = "UTF-8";

            URL httpUrl = new URL(strUrl);
            httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", contentType);
            if (null != soapAction) {
                httpURLConnection.setRequestProperty("SOAPAction", soapAction);
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(connectTimeoutMs);
            httpURLConnection.setReadTimeout(readTimeoutMs);
            httpURLConnection.connect();
            outputStream = httpURLConnection.getOutputStream();
            outputStream.write(reqBody.getBytes(UTF8));
            outputStream.flush();
            outputStream.close();

            // if (httpURLConnection.getResponseCode()!= HttpURLConnection.HTTP_OK) {
            //     throw new Exception(String.format("HTTP response code is %d, not 200", httpURLConnection.getResponseCode()));
            // }

            //获取内容
            inputStream = httpURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, UTF8));
            final StringBuffer stringBuffer = new StringBuffer();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            resp = stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader!=null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream!=null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream!=null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpURLConnection!=null) {
                httpURLConnection.disconnect();
            }
        }
        return resp;
    }

    public static void main(String[] args) {
        String url = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx";

        StringBuilder sb = new StringBuilder("");
        sb.append(
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" ")
                .append("xmlns:web=\"http://WebXml.com.cn/\"><soapenv:Header/><soapenv:Body>")
                .append("<web:getSupportProvince/></soapenv:Body></soapenv:Envelope>");
        /*
         * sb.append(
         * "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
         * ) .append(
         * "xmlns:web=\"http://WebXml.com.cn/\"><soapenv:Header/><soapenv:Body><web:getSupportCity>"
         * ) .append(
         * "<web:byProvinceName>河北</web:byProvinceName></web:getSupportCity></soapenv:Body></soapenv:Envelope>"
         * );
         */
        String dataXml = sb.toString();
        String contentType = "text/xml; charset=utf-8";
        String soapAction = "http://WebXml.com.cn/getSupportProvince";
        // String soapAction =
        // "\"document/http://pengjunnlee.com/CustomUI:GetWeatherById\"";
        String resultXml = HttpUtil.httpSoapPostRequest(url, dataXml, soapAction, contentType,10000,10000);
        System.out.println(resultXml);
    }

}
