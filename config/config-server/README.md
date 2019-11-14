# Config Server

## 概述

Spring Cloud Config 服务器。

------

## 版本

**创建模块** -- **2019-09-04**

**加解密特性拆分** -- **2019-11-14**

------

## 问题

------

### 加密解密 (2019-11-14)

**BUG :**

​	**The encryption algorithm is not strong enough**

**Caused :**

​	需要配置 **encrypt.key** 属性，且该属性必须使用 **bootstrap.yml/properties** 配置文件。

**Resolve :**

1. 改用 **bootstrap.yml/properties** 配置文件。

2. 设置 **encrypt.key**。

**Details :**

1.  **spring.cloud.config.server.encrypt.enabled = false** 关闭加解密，直接返回远程配置内容。

2.  加解密端点 :

   ```shell
   # 加密
   curl http://localhost:8700/encrypt -d 明文
   # 解密
   curl http://localhost:8700/decrypt -d 密文
   ```

3. 非对称加密生成 Key Store[[1]](<https://cloud.spring.io/spring-cloud-static/spring-cloud-config/2.2.0.RC2/reference/html/#_creating_a_key_store_for_testing>)

   ```shell
   keytool -genkeypair -alias thekey -keyalg RSA \
     -dname "CN=Web Server,OU=Unit,O=Organization,L=City,S=State,C=US" \
     -keypass password -keystore server.jks -storepass letmein
   ```

------

## 参考

[1]  [Spring Cloud Config 官方文档 # Creating a Key Store for Testing](<https://cloud.spring.io/spring-cloud-static/spring-cloud-config/2.2.0.RC2/reference/html/#_creating_a_key_store_for_testing>)