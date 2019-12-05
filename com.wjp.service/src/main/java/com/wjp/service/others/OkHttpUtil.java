package com.wjp.service.others;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OkHttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(OkHttpUtil.class);

    private static String charsetName = "UTF-8";

    private static OkHttpClient okHttpClient = initOkHttpClient();

    private static OkHttpClient initOkHttpClient() {
        return builder().build();
    }

    public static OkHttpClient.Builder builder() {
        ConnectionPool connectionPool = new ConnectionPool(200, 5L, TimeUnit.MINUTES);
        return new OkHttpClient.Builder()
                //.sslSocketFactory(getSslSocketFactory(), getX509TrustManager())
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectionPool(connectionPool);
    }

    private static X509TrustManager getX509TrustManager() {
        return new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
    }

    private static SSLSocketFactory getSslSocketFactory() {
        return null;
    }

    public static synchronized void setOkHttpClient(OkHttpClient okHttpClient) {
        OkHttpUtil.okHttpClient = okHttpClient;
    }

    /**
     * get请求
     *
     * @param url
     * @return
     */
    public static String sendGet(String url) {
        Request request = new Request.Builder().url(url).get().build();
        return sendRequestString(request);
    }

    /**
     * get请求
     *
     * @param url
     * @return
     */
    public static String sendGetWithHeader(String url, Map<String, String> map) {
        Request.Builder builder = new Request.Builder().url(url).get();
        if (!CollectionUtils.isEmpty(map)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.header(entry.getKey(), entry.getValue());
            }
        }
        return sendRequestString(builder.build());
    }

    /**
     * get请求
     *
     * @param url
     * @param reqInfos
     * @return
     */
    public static String sendGet(String url, List<HttpReqInfo> reqInfos) {
        String requestUrl = url;
        Request.Builder builder = new Request.Builder();
        if (reqInfos == null || reqInfos.isEmpty()) {
            StringBuffer sb = new StringBuffer();
            reqInfos.forEach(info -> {
                // 参数头
                if (info.isHeader()) {
                    builder.addHeader(info.getParam(), info.getValue());
                }
                // 参数体
                if (!StringUtil.isEmpty(info.getParam())) {
                    sb.append("&").append(info.getParam()).append("=");
                    if (info.getValue() != null) {
                        sb.append(info.getValue());
                    }
                }
            });
            if (sb.length() > 0) {
                if (url.contains("?")) {
                    requestUrl += sb.substring(1);
                } else {
                    requestUrl += "?" + sb.substring(1);
                }
            }
        }
        Request request = new Request.Builder().url(requestUrl).get().build();
        return sendRequestString(request);
    }

    /**
     * 执行同步PostForm请求
     *
     * @param url
     * @param reqInfos
     * @return
     */
    public static String sendPostForm(String url, List<HttpReqInfo> reqInfos) {
        //构造请求体
        Request.Builder builder = new Request.Builder();
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (reqInfos == null || reqInfos.isEmpty()) {
            reqInfos.forEach(info -> {
                // 参数头
                if (info.isHeader()) {
                    builder.addHeader(info.getParam(), info.getValue());
                }
                // 参数体
                if (!StringUtil.isEmpty(info.getParam())) {
                    formBodyBuilder.add(info.getParam(), info.getValue());
                }
            });
        }
        Request request = builder.url(url).post(formBodyBuilder.build()).build();
        return sendRequestString(request);
    }

    /**
     * 发送多媒体请求
     *
     * @param url
     * @param reqInfos
     * @return
     */
    public static String sendPostMultipart(String url, List<HttpReqInfo> reqInfos) {
        //构造请求体
        Request.Builder builder = new Request.Builder();
        MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (reqInfos == null || reqInfos.isEmpty()) {
            reqInfos.forEach(info -> {
                // 参数头
                if (info.isHeader()) {
                    builder.addHeader(info.getParam(), info.getValue());
                }
                if (info.isFile()) {
                    RequestBody fileBody = RequestBody.create(MediaType.parse(info.getContentType()), info.getData());
                    multipartBodyBuilder.addFormDataPart(info.getParam(), info.getFileName(), fileBody);
                }
                if (!(info.isFile() || info.isHeader())) {
                    if (!StringUtil.isEmpty(info.getParam())) {
                        multipartBodyBuilder.addFormDataPart(info.getParam(), info.getValue());
                    }
                }
            });
        }
        Request request = builder.url(url).post(multipartBodyBuilder.build()).build();
        return sendRequestString(request);
    }

    /**
     * 发送json请求
     *
     * @param url
     * @param jsonObject
     * @return
     */
    public static String sendPostJsonObject(String url, Object jsonObject) {
        return sendPostJson(url, JSON.toJSONString(jsonObject));
    }

    /**
     * 发送post请求 json格式
     *
     * @param url
     * @param jsonString
     * @return
     */
    public static String sendPostJson(String url, String jsonString) {
        Request request = new Request.Builder().url(url)
                .post(RequestBody.create(MediaType.parse("application/json; charset=" + charsetName), jsonString))
                .build();
        return sendRequestString(request);
    }

    /**
     * 发送post请求 json格式（加请求头）
     *
     * @param url
     * @param jsonString
     * @param map
     * @return
     */
    public static String sendPostJsonWithHeader(String url, String jsonString, Map<String, String> map) {
        Request.Builder builder = new Request.Builder().url(url)
                .post(RequestBody.create(MediaType.parse("application/json; charset=" + charsetName), jsonString));
        if (!CollectionUtils.isEmpty(map)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.header(entry.getKey(), entry.getValue());
            }
        }
        return sendRequestString(builder.build());
    }

    /**
     * 发送post请求 xml格式
     *
     * @param url
     * @param xmlString
     * @return
     */
    public static String sendPostXml(String url, String xmlString) {
        Request request = new Request.Builder().url(url)
                .post(RequestBody.create(MediaType.parse("application/xml; charset=" + charsetName), xmlString))
                .build();
        return sendRequestString(request);
    }


    /**
     * 发送请求返回字符串数据
     *
     * @param request
     * @return
     */
    private static String sendRequestString(Request request) {
        String content = "";
        byte[] bytes = sendRequestByteArray(request);
        if (bytes != null) {
            try {
                content = new String(bytes, charsetName);
            } catch (UnsupportedEncodingException e) {
            }
        }
        return content;
    }

    /**
     * 发送请求
     *
     * @param request
     * @return
     */
    private static byte[] sendRequestByteArray(Request request) {
        byte[] result = null;
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                logger.debug("okhttp3 call {} response status is {} >> ex = {}",
                        request.url().toString(), response.code());
            }
            result = response.body().bytes();
        } catch (Exception e) {
            doException(request.url().toString(), e);
        } finally {
            closeResponse(response);
        }
        return result;
    }

    private static void closeResponse(Response response) {
        if (response != null) {
            response.close();
        }
    }

    private static void doException(String url, Exception e) {
        logger.error("okhttp3 call {} error >> ex = {}", url, ExceptionUtils.getStackTrace(e));
    }

}
