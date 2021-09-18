package com.wmh.utils.httpasync;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @program: utils
 * @description: 异步Http请求
 * @author: Mr.Hou
 * @create: 2021-09-18 21:11
 **/
public class HttpAsyncUtils {

    private static final class MyCallback implements FutureCallback<HttpResponse> {


        @Override
        public void failed(final Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }


        @Override
        public void completed(final HttpResponse response) {

            try {
                System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }

        }


        @Override
        public void cancelled() {
            System.out.println("cancelled");
        }

    }

    public static void asyncHttp(String url) throws InterruptedException, IOException {
        CloseableHttpAsyncClient httpclient = HttpAsyncClients.custom().build();

        // .发起调用
        try {
            // .启动
            httpclient.start();

            // .请求参数
            HttpGet httpget1 = new HttpGet(url);
            HttpGet httpget2 = new HttpGet(url);

            // .发起请求，不阻塞，马上返回
            httpclient.execute(httpget1, new MyCallback());
            httpclient.execute(httpget2, new MyCallback());

            // .休眠s,避免请求执行完成前，关闭了链
            Thread.sleep(10000);

        } finally {
            httpclient.close();
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
       HttpAsyncUtils.asyncHttp("www.google.com");
    }
}
