package com.system.tool;

public class Tool
{
    public static String identityMap(String identity)
    {
        //对于用户身份，把数字映射为英文单词
        switch(identity)
        {
            case "1":
                identity = "student";
                break;
            case "2":
                identity = "teacher";
                break;
            case "3":
                identity = "administrator";
        }
        return identity;
    }
}
