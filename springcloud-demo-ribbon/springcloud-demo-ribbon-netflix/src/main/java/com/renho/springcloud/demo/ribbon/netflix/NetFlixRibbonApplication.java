package com.renho.springcloud.demo.ribbon.netflix;

import com.google.common.collect.Lists;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import rx.Observable;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * @author renho
 * @date 2020/12/22
 */
public class NetFlixRibbonApplication {

    public static void main(String[] args) {
        // 服务列表
        List<Server> serverList = Lists.newArrayList(new Server("localhost", 9102), new Server("localhost", 9104));
        // 构建负载实例
        ILoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder().buildFixedServerListLoadBalancer(serverList);

        // 调用 5 次来测试效果
        for (int i = 0; i < 5; i++) {
            String result = LoadBalancerCommand.<String>builder().withLoadBalancer(loadBalancer).build()
                    .submit(server -> {
                        try {
                            String addr = "http://" + server.getHost() + ":" + server.getPort() + "/renho";
                            System.out.println(" 调用地址：" + addr);
                            URL url = new URL(addr);
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setRequestMethod("GET");
                            conn.connect();
                            InputStream in = conn.getInputStream();
                            byte[] data = new byte[in.available()];
                            in.read(data);
                            return Observable.just(new String(data));
                        } catch (Exception e) {
                            return Observable.error(e);
                        }
                    }).toBlocking().first();
            System.out.println(" 调用结果：" + result);
        }
    }

}
