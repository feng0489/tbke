package com.xudy.tbke.config;





import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.*;

import javax.xml.crypto.Data;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 用于模拟HTTP请求中GET/POST方式
 * @author landa
 *
 */
public class HttpUtils {

    /**
     * 发送GET请求
     *
     * @param url
     *            目的地址
     * @param parameters
     *            请求参数，Map类型。
     * @return 远程响应结果
     */
    public static String httpGet(String url, Map<String, String> parameters ,String refer){

        String result="";
        BufferedReader in = null;// 读取响应输入流
        StringBuffer sb = new StringBuffer();// 存储参数
        String params = "";// 编码之后的参数
        try {
            // 编码请求参数
            if(parameters.size()==1){
                for(String name:parameters.keySet()){
                    sb.append(name).append("=").append(
                            java.net.URLEncoder.encode(parameters.get(name),
                                    "UTF-8"));
                }
                params=sb.toString();
            }else{
                for (String name : parameters.keySet()) {
                    sb.append(name).append("=").append(
                            java.net.URLEncoder.encode(parameters.get(name),
                                    "UTF-8")).append("&");
                }
                String temp_params = sb.toString();
                params = temp_params.substring(0, temp_params.length() - 1);
            }
            String full_url = url + "?" + params;
            //System.out.println(full_url);//完整的地址
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(full_url);
            // 打开URL连接
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL
                    .openConnection();
            // 设置通用属性
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            if(refer != ""){
                httpConn.setRequestProperty("referer",refer);
            }
            // 建立实际的连接
            httpConn.connect();
            // 响应头部获取
           // Map<String, List<String>> headers = httpConn.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : headers.keySet()) {
//                System.out.println(key + "\t：\t" + headers.get(key));
//            }
            // 定义BufferedReader输入流来读取URL的响应,并设置编码方式
            in = new BufferedReader(new InputStreamReader(httpConn
                    .getInputStream(), "GBK"));
            String line;

            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result ;

    }

    /**
     * 发送POST请求
     *
     * @param url
     *            目的地址
     * @param parameters
     *            请求参数，Map类型。
     * @return 远程响应结果
     */
    public static String httpPost(String url, Map<String, String> parameters,String refer) {
        String result = "";// 返回的结果
        BufferedReader in = null;// 读取响应输入流
        PrintWriter out = null;
        StringBuffer sb = new StringBuffer();// 处理请求参数
        String params = "";// 编码之后的参数
        try {
            // 编码请求参数
            if(parameters.size() == 1) {
                for (String name : parameters.keySet()) {
                    sb.append(name).append("=").append(
                            java.net.URLEncoder.encode(parameters.get(name),
                                    "UTF-8"));
                }
                params = sb.toString();
            } else {
                for (String name : parameters.keySet()) {
                    sb.append(name).append("=").append(
                            java.net.URLEncoder.encode(parameters.get(name),
                                    "UTF-8")).append("&");
                }
                String temp_params = sb.toString();
                params = temp_params.substring(0, temp_params.length() - 1);
            }
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(url);
            // 打开URL连接
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL
                    .openConnection();
            // 设置通用属性
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            if(refer != ""){
                httpConn.setRequestProperty("referer",refer);
            }
            // 设置POST方式
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            // 获取HttpURLConnection对象对应的输出流
            out = new PrintWriter(httpConn.getOutputStream());
            // 发送请求参数
            out.write(params);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应，设置编码方式
            in = new BufferedReader(new InputStreamReader(httpConn
                    .getInputStream(), "UTF-8"));
            String line;
            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 主函数，测试请求
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * 淘宝获取优惠订单列表
         */
//        Map<String, String> parameters = new HashMap<String, String>();
//        parameters.put("pid", "mm_29947720_14832832_57874820");
//        parameters.put("category", "16,50006843");
//        parameters.put("queryCount", "500");
//        String result = httpGet("http://uland.taobao.com/cp/coupon_list", parameters,"");
//
//        /**
//         * json转为对象
//         */
//
//        JsonParser parse =new JsonParser();  //创建json解析器
//        try {
//            long time1=System.currentTimeMillis();
//            JsonObject json = (JsonObject) parse.parse(result);
//
//            //普通的json格式{"success":true,"message":""}
//            System.out.println("这个一个json数据类型："+json.get("result").getAsJsonObject());
//            System.out.println("这是个Boolean数据类型："+json.get("success").getAsBoolean());
//            System.out.print("这个是个String数据类型：");
//            System.out.println(json.get("message").toString()== null ? "":json.get("message").toString());
//            //包含数组格式的json{
//            //    "cat":"it",
//            //    "language":[
//            //        {"id":1,"ide":"eclipse","name":Java},
//            //        {"id":2,"ide":"XCode","name":"Swift"},
//            //        {"id":3,"ide":"Visual Stdio","name":"C#"}
//            //    ],
//            //    "pop":true
//            //}
//             JsonObject js = json.get("result").getAsJsonObject();
//             System.out.println("这个是个包含数组格式的json："+js.get("couponList").getAsJsonArray());
//             System.out.println("这个是个Int数据类型："+js.get("totalCount").getAsInt());
//
//             JsonArray jsarr = js.get("couponList").getAsJsonArray();
//
//            for(int i=0;i<jsarr.size();i++){
//                System.out.println("第"+(i+1)+"个---------------");
//                JsonObject subObject=jsarr.get(i).getAsJsonObject();
//                System.out.println("retStatus:"+subObject.get("retStatus").getAsInt());
//                System.out.println("couponKey:"+subObject.get("couponKey").getAsString());
//                System.out.println("effectiveStartTime:"+subObject.get("effectiveStartTime").getAsString());
//
//                JsonObject item = subObject.get("item").getAsJsonObject();
//                System.out.println("clickUrl:"+"http:"+item.get("clickUrl").getAsString());
//                System.out.println("picUrl:"+"http:"+item.get("picUrl").getAsString());
//                System.out.println("title:"+item.get("title").getAsString());
//            }
//
//            long time2=System.currentTimeMillis();
//           System.out.println("当前程序耗时："+(time2-time1)+"ms");
//        }catch (JsonParseException jse){
//            jse.printStackTrace();
//        }


//       https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxd9555f90fe443957&redirect_uri=http%3A%2F%2Fhbgcsz.cn%2Flogin.php&response_type=code&scope=snsapi_base&state=123#wechat_redirect


        /**
         * 微信登录三次握手
         */
        //获取微信授权链接
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize";
        String refer = "http://hbgcsz.cn/login.php";
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("appid", "wxd9555f90fe443957");
        parameters.put("redirect_uri", "http%3A%2F%2Fhbgcsz.cn%2Flogin.php");
        parameters.put("response_type", "code");
        parameters.put("scope", "snsapi_base");
        parameters.put("state", "123#wechat_redirect");
        String result = httpGet(url, parameters,refer);
        System.out.println(result);


    }
}
