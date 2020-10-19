# Sunny Weather

一个天气 App，数据来源于[彩云天气](https://open.caiyunapp.com/%E5%BD%A9%E4%BA%91%E5%A4%A9%E6%B0%94_API)。

## 打包须知

在当前目录下创建一个 `signing.properties`，里面填写上你的 keystore 的信息(字符串不需要加双引号)：

```properties
STORE_FILE=C\:\\Users\\xxxx\\build.jks
STORE_PASS=XXXXXXX
KEY_ALIAS=alias
KEY_PASS=XXXXXXX
```

创建一个 `apikey.properties`，里面填上你的彩云天气 token(字符串需要加双引号)：

```properties
# 这里示例用的是彩云天气官网的测试Token
CYTOKEN="TAkhjf8d1nlSlspN"
```

然后使用 grade sync 即可。
