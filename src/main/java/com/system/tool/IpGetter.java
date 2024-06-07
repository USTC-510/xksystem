package com.system.tool;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class IpGetter
{
    public static String getIpAddress()
    {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress wlanIpv4Address = null;

            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                }

                // 检查接口名称是否包含"wlan"
                if (netInterface.getName().toLowerCase().contains("wlan")) {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        InetAddress ip = addresses.nextElement();
                        if (ip instanceof Inet4Address) {
                            wlanIpv4Address = ip;
                            break; // 找到IPv4地址后跳出内部循环
                        }
                    }

                    if (wlanIpv4Address != null) {
                        break; // 找到WLAN适配器的IPv4地址后跳出外部循环
                    }
                }
            }

            if (wlanIpv4Address != null) {
                return wlanIpv4Address.getHostAddress();
            }
        } catch (SocketException e) {
            System.err.println("IP地址获取失败: " + e.toString());
        }

        return ""; // 如果没有找到WLAN适配器的IPv4地址，则返回空字符串
    }

    public static void main(String[] args)
    {
        System.out.println(getIpAddress());
    }
}
