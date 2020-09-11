# bleach
bleach 是一个封装了常用的工具类的方法,主要有以下工具类

### Maven引用
```$xslt
<dependency>
    <groupId>com.github.xinput123</groupId>
    <artifactId>bleach</artifactId>
    <version>0.0.5</version>
</dependency>
```

### system.propertie 配置文件参数
| key名称 | 描述 |
| :---: | :--- |
| wechat.appid | 微信应用唯一标识，在微信开放平台提交应用审核通过后获得 |
| wechat.secret | 微信开放平台获取 |
| http.idle.monitor | 是否开启http池回收，默认false |