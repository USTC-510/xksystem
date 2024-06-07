package com.system.tool;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class IPv4AddressFinder {

    public static void main(String[] args) {
        String ipAddresses = getIPv4Addresses();
        System.out.println(ipAddresses);
    }

    public static String getIPv4Addresses() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        List<String> ipAddresses = new ArrayList<>(); // 使用ArrayList直接收集IP地址

        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            // 跳过非活动的和回环的接口
            if (!networkInterface.isUp() || networkInterface.isLoopback()) {
                continue;
            }

            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddress = inetAddresses.nextElement();
                // 检查是否是IPv4地址
                if (inetAddress instanceof Inet4Address) {
                    ipAddresses.add(inetAddress.getHostAddress()); // 直接添加到ArrayList中
                }
            }
        }

        // 如果需要，可以使用Collections.unmodifiableList(ipAddresses)来返回不可修改的列表
        return ipAddresses.get(2);
    }
}