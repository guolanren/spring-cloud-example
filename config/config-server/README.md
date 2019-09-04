# Config Server

## 概述

Spring Cloud Config 服务器。

------

## 版本

**1.0.0: ** 创建模块 -- **2019.09.04**

------

## 问题

------

### 加密解密 (2019.09.04)

**BUG :**

​	**The encryption algorithm is not strong enough**

**Caused :**

​	需要配置 **encrypt.key** 属性，且该属性必须使用 **bootstrap.yml/properties** 配置文件。

**Resolve :**

1. 改用 **bootstrap.yml/properties** 配置文件。

2. 设置 **encrypt.key**。

**Details :**

​	**spring.cloud.config.server.encrypt.enabled = false** 关闭加解密，直接返回远程配置内容。

​	加解密端点 :

```shell
# 加密
curl http://localhost:8700/encrypt -d ${明文}
# 解密
curl http://localhost:8700/decrypt -d ${密文}
```

------

## 参考
